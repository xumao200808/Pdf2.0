package com.pdf.util;

import java.util.List;

import com.google.zxing.NotFoundException;

public class InvoicePdf {

	
	public static InvoiceData getInvoiceData(String pdfPath) throws Exception {
		PdfGetImages pdfImgUti = new PdfGetImages(pdfPath);
		pdfImgUti.saveImagesOfPdf();
		List<String> imagesPdf = pdfImgUti.getImagesPaths();
		QrCode codeParse = new QrCode();
		String text = null;
		for(String path : imagesPdf) {
			try {
				text = codeParse.getQrCodeText(path);
				System.out.println("=======================================");
				InvoiceData data = codeParse.getInvoiceData(text);
				return data;
			} catch (NotFoundException e) {
				System.out.println("ͼƬ���Ƕ�ά��");
			}
		}
		throw new Exception("����PDFδ���ַ�Ʊ��ά��ͼƬ");
	}
}
