package com.pdf.util;


public class Demo {

	public static void main(String []args) {
		try {
			System.out.println(InvoicePdf.getInvoiceData("D:\\work\\电子发票pdf识别\\test5/test5.pdf"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}				
	}
	
}
