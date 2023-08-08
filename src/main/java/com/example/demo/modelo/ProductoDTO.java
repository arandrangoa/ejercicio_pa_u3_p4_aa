package com.example.demo.modelo;

public class ProductoDTO {
	
	private String codigoBarras;
	
	private Integer cantidad;

	public ProductoDTO() {
	}
	

	public ProductoDTO(String codigoBarras, Integer cantidad) {
		super();
		this.codigoBarras = codigoBarras;
		this.cantidad = cantidad;
	}



	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	

}
