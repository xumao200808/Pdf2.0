package com.pdf.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfGetImages {
	
	private String pdfPath;
	private String imageFolderPath;
	private List<String> imagesPaths;
	
	public PdfGetImages(String pdfPath) {
		this.pdfPath = pdfPath;
		this.imagesPaths = new ArrayList<String>();
	}

	public void saveImagesOfPdf() throws IOException {
		covertImage(loadPages(loadPdf(this.pdfPath)));
	}
	
	public List<String> getImagesPaths(){
		return this.imagesPaths;		
	}
	
	
	private PDDocument loadPdf(String pdfPath) throws IOException {
		File file = new File(pdfPath);
		this.imageFolderPath = file.getParent();
		return PDDocument.load(file);
	}
	
	public Iterator<PDPage> loadPages(PDDocument document){
		PDPageTree pageTree = document.getPages();
		return pageTree.iterator();
	}
	
	public void covertImage(Iterator<PDPage> iterator) {
		while(iterator.hasNext()) {
			PDPage pdPage = iterator.next();
			PDResources pdResources = pdPage.getResources();
			Iterable<COSName> cosNames = pdResources.getXObjectNames();
			if(cosNames != null) {
				Iterator<COSName> cosNamesIter = cosNames.iterator();
				while (cosNamesIter.hasNext()) {
					COSName t = cosNamesIter.next();
					System.out.println("###########################################");							
					System.out.println();							
					//is ImageXObject							
					if(pdResources.isImageXObject(t)){								
						System.out.println("COSName "+t.getName()+" isImageXObject");								
						try {
							PDXObject pdXObject = pdResources.getXObject(t);								
							PDImageXObject pdImageXObject=(PDImageXObject) pdXObject;								
							String suffix=pdImageXObject.getSuffix();								
							System.out.println("Height:"+pdImageXObject.getHeight()+" Width:"+pdImageXObject.getWidth()+" Suffix:"+suffix);								
							BufferedImage image=pdImageXObject.getImage();
							File file = mkdirsFile(this.imageFolderPath, UUID.randomUUID().toString()+"."+suffix);
							this.imagesPaths.add(file.getAbsolutePath());
							ImageIO.write(image, suffix, file);
						} catch (IOException e) {
							System.out.println("Get Image Of Pdf Error:" + e.getMessage());
						}							
					}else{								
						System.out.println("COSName "+t.getName()+" isOtherXObject");							
					}							
					System.out.println();							
					System.out.println("###########################################");	
				}
			}
		}
		
		/*iterator.forEachRemaining(new Consumer<PDPage>() {			
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
									System.out.println("Height:"+pdImageXObject.getHeight()+" Width:"+pdImageXObject.getWidth()+" Suffix:"+suffix);								
									BufferedImage image=pdImageXObject.getImage();								
									ImageIO.write(image, suffix, mkdirsFile(, UUID.randomUUID().toString()+"."+suffix));							
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
			});*/
		}
			
		public File mkdirsFile(String dir, String realName) throws IOException {	
			File file = new File(dir, realName);		
			if (!file.exists()) {			
				if (!file.getParentFile().exists()) {				
					file.getParentFile().mkdirs();			
					}			
				file.createNewFile();		
				}		
			return file;	
		}
		public String getPdfPath() {
			return pdfPath;
		}
		public void setPdfPath(String pdfPath) {
			this.pdfPath = pdfPath;
		}
}
