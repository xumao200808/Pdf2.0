package com.pdf.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import java.util.function.Consumer;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfGetImages {
	
	public static void main(String [] args) {
		try {
			covertImage(loadPages(loadPdf("D:\\work\\电子发票pdf识别\\test5-1/test5.pdf")));
		} catch (IOException e) {
		}
	}
	

	private static PDDocument loadPdf(String pdfPath) throws IOException {
		return PDDocument.load(new File(pdfPath));
	}
	
	public static  Iterator<PDPage> loadPages(PDDocument document){
		PDPageTree pageTree = document.getPages();
		return pageTree.iterator();
	}
	
	public static void covertImage(Iterator<PDPage> iterator) {
		iterator.forEachRemaining(new Consumer<PDPage>() {			
			public void accept(PDPage pdPage) {				
				//load resoure				
				PDResources pdResources=pdPage.getResources();				
				//load XObjectNames				
				Iterable<COSName> iterable = pdResources.getXObjectNames();				
				//loadXObject				
				iterable.forEach(new Consumer<COSName>() {					
					public void accept(COSName t) {						
						try {							
								System.out.println("###########################################");							
								System.out.println();							
								//is ImageXObject							
								if(pdResources.isImageXObject(t)){								
									System.out.println("COSName "+t.getName()+" isImageXObject");								
									PDXObject pdXObject = pdResources.getXObject(t);								
									PDImageXObject pdImageXObject=(PDImageXObject) pdXObject;								
									String suffix=pdImageXObject.getSuffix();								
									System.out.println("Height:"+pdImageXObject.getHeight()+"Width:"+pdImageXObject.getWidth()+"Suffix:"+suffix);								
									BufferedImage image=pdImageXObject.getImage();								
									ImageIO.write(image, suffix, mkdirsFile("D:\\work\\电子发票pdf识别\\test5-1", UUID.randomUUID().toString()+"."+suffix));							
								}else{								
									System.out.println("COSName "+t.getName()+" isOtherXObject");							
								}							
								System.out.println();							
								System.out.println("###########################################");						
						} catch (IOException e) {							
							e.printStackTrace();						
						}											
					}				
					});			
				}		
			});
		}
			
		public static File mkdirsFile(String dir, String realName) throws IOException {	
			File file = new File(dir, realName);		
			if (!file.exists()) {			
				if (!file.getParentFile().exists()) {				
					file.getParentFile().mkdirs();			
					}			
				file.createNewFile();		
				}		
			return file;	
		}

}
