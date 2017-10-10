package br.unicamp.bookstore.model;

public enum StatusEntregaEnum {
	A_ENVIAR("0"),
	EM_ANDAMENTO("1"),
	ENTREGUE("2");	
	String statusentrega;
	
	private StatusEntregaEnum(String statusentrega) {
		this.statusentrega = statusentrega;
	}
	
	public String getStatusEntrega() {
		return statusentrega;
}
}
