package com.pdf.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QrCode {
	
	public String getQrCodeText(String qrCodeImagePath) throws NotFoundException, IOException {
		System.out.println("��ά��ͼƬ·����" + qrCodeImagePath);
		MultiFormatReader formatReader = new MultiFormatReader();			
		//��ȡָ���Ķ�ά���ļ�			
		File  file= new File(qrCodeImagePath);			
		BufferedImage bufferedImage =ImageIO.read(file);			
		BinaryBitmap binaryBitmap= new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));			
		//�����ά�����			
		/*Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		Result result = formatReader.decode(binaryBitmap, hints);*/
		Result result = formatReader.decode(binaryBitmap);			
		//�����صĶ�ά����Ϣ			
		System.out.println("�������"+result.toString());			
		System.out.println("��ά���ʽ����"+result.getBarcodeFormat());			
		System.out.println("��ά���ı�"+result.getText());			
		bufferedImage.flush();	
		return result.getText();
	}
	
	public InvoiceData getInvoiceData(String qrCodeText) {
		InvoiceData data = new InvoiceData();
		String [] strArray = qrCodeText.split(",");
		data.setFpdm(strArray[2]);
		data.setFphm(strArray[3]);
		data.setBhsje(strArray[4]);
		SimpleDateFormat format = new SimpleDateFormat( "yyyyMMdd" ); 
		SimpleDateFormat resultFormat = new SimpleDateFormat( "yyyy��MM��dd��" );
		try {
			Date date = format.parse(strArray[5]);
			data.setKprq(resultFormat.format(date));
		} catch (ParseException e) {
			data.setKprq(strArray[5]);
		}
		data.setJym(strArray[6]);
		return data;
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
