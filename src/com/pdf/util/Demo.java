package com.pdf.util;


public class Demo {

	public static void main(String []args) {
		try {
			System.out.println(InvoicePdf.getInvoiceData("D:\\work\\���ӷ�Ʊpdfʶ��\\test5/test5.pdf"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}				
	}
	
}
