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
				System.out.println("图片不是二维码");
			}
		}
		throw new Exception("解析PDF未发现发票二维码图片");
	}
}
