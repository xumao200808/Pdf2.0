package com.pdf.util;

public class InvoiceData {
	//价税合计
	private String jshj;
	
	//不含税金额
	private String bhsje;
	
	//销售方
	private String xsf;	

	//销售方纳税人识别号
	private String xsf_nsrsbh;

	//购买方
	private String gmf_nsrsbh;
	
	//开票日期
	private String kprq;

	//发票代码
	private String fpdm;
	
	//发票号码
	private String fphm;

	//校验码
	private String jym;
	
	public String getJshj() {
		return jshj;
	}

	public void setJshj(String jshj) {
		this.jshj = jshj;
	}

	public String getBhsje() {
		return bhsje;
	}

	public void setBhsje(String bhsje) {
		this.bhsje = bhsje;
	}

	public String getXsf() {
		return xsf;
	}

	public void setXsf(String xsf) {
		this.xsf = xsf;
	}

	public String getXsf_nsrsbh() {
		return xsf_nsrsbh;
	}

	public void setXsf_nsrsbh(String xsf_nsrsbh) {
		this.xsf_nsrsbh = xsf_nsrsbh;
	}

	public String getGmf_nsrsbh() {
		return gmf_nsrsbh;
	}

	public void setGmf_nsrsbh(String gmf_nsrsbh) {
		this.gmf_nsrsbh = gmf_nsrsbh;
	}

	public String getKprq() {
		return kprq;
	}

	public void setKprq(String kprq) {
		this.kprq = kprq;
	}

	public String getFpdm() {
		return fpdm;
	}

	public void setFpdm(String fpdm) {
		this.fpdm = fpdm;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

   
	
	
    public String getJym() {
		return jym;
	}

	public void setJym(String jym) {
		this.jym = jym;
	}

	public String toString(){
    	return "发票号码："+fphm +" ;发票代码："+fpdm+" ;开票日期："+kprq +" ;校验码："+jym  + " ;不含税金额："+bhsje;
    }
}
