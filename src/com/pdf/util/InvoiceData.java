package com.pdf.util;

public class InvoiceData {
	//��˰�ϼ�
	private String jshj;
	
	//����˰���
	private String bhsje;
	
	//���۷�
	private String xsf;	

	//���۷���˰��ʶ���
	private String xsf_nsrsbh;

	//����
	private String gmf_nsrsbh;
	
	//��Ʊ����
	private String kprq;

	//��Ʊ����
	private String fpdm;
	
	//��Ʊ����
	private String fphm;

	//У����
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
    	return "��Ʊ���룺"+fphm +" ;��Ʊ���룺"+fpdm+" ;��Ʊ���ڣ�"+kprq +" ;У���룺"+jym  + " ;����˰��"+bhsje;
    }
}
