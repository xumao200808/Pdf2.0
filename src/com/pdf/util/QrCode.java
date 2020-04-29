package com.pdf.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QrCode {
	public static void main(String []args) {
		
		parseQrCode("D:/work/���ӷ�Ʊpdfʶ��/test4/1.png");
	}
	
	
	
	
	public static void parseQrCode(String qrCodePath) {
		try {			
			MultiFormatReader formatReader = new MultiFormatReader();			
			//��ȡָ���Ķ�ά���ļ�			
			File  file= new File(qrCodePath);			
			BufferedImage bufferedImage =ImageIO.read(file);			
			BinaryBitmap binaryBitmap= new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));			
			//�����ά�����			
			Map<DecodeHintType, ?> hints = new HashMap<DecodeHintType, Object>();
		//	hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			Object object = (Object)"UTF-8"; 
//			hints.put(EncodeHintType.CHARACTER_SET, object);			
			Result result = formatReader.decode(binaryBitmap);			
			//�����صĶ�ά����Ϣ			
			System.out.println("�������"+result.toString());			
			System.out.println("��ά���ʽ����"+result.getBarcodeFormat());			
			System.out.println("��ά���ı�"+result.getText());			
			bufferedImage.flush();		
		} catch (NotFoundException e) {			
			e.printStackTrace();		
		} catch (IOException e) {					
			e.printStackTrace();		
		}
	}
	
	
	
	
	
	
	/*public static String qrCodeDecode(File imageFile) {
		String decodeData = null;
		QRCodeDecoder  decoder = new QRCodeDecoder();
		BufferedImage image = null;
		try {
			image = ImageIO.read(imageFile);
		}catch (Exception e) {
		}
		
		
		try {
			decodeData = new String (decoder.decode(new MyQRCodeImage(image)),"UTF-8");
		} catch (Exception e) {
		}
		 return decodeData;
	}
	static class MyQRCodeImage implements QRCodeImage {        
		BufferedImage image;         
		public MyQRCodeImage(BufferedImage image) {            
			this.image = image;        
		}         
		public int getWidth() {            
			return image.getWidth();        
		}         
		public int getHeight() {            
			return image.getHeight();        
		}         
		public int getPixel(int x, int y) {            
			return image.getRGB(x, y);        
		}    
	}*/
}
