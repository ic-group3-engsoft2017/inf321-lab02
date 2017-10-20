package br.unicamp.bookstore.model;

import javax.xml.bind.annotation.XmlElement;

public class Rastreio {

   @XmlElement(name = "codigorastreio")
   private String CodigoRastreio;
   
   @XmlElement(name = "status")
	private String StatusEntrega;
   
	
	public String getCodigoRastreio() {
	return CodigoRastreio;
}


	

public void setCodigoRastreio(String codigoRastreio) {
	CodigoRastreio = codigoRastreio;
}



	public Rastreio(String codigoRastreio, String statusEntrega) {
		// TODO Auto-generated constructor stub
		this.CodigoRastreio = codigoRastreio;
		this.StatusEntrega = statusEntrega;
	}

	
	//public enum StatusEntregaEnum {
	//	A_ENVIAR("0"),
	//	EM_ANDAMENTO("1"),
	//	ENTREGUE("2");
		

		
		public void setStatusEntregaEnum(String statusentrega) {
			this.StatusEntrega = statusentrega;
		}
		
		public String getStatusEntrega() {
			return this.StatusEntrega;
	}
	}



