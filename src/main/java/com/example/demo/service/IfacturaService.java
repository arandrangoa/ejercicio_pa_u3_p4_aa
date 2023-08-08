package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.FacturaDTO;
import com.example.demo.modelo.ProductoDTO;

public interface IfacturaService {
	
	public void agregar(Factura factura);
	
	public void realizarFactura(List<ProductoDTO> productos,String cedula );
	
	public List<FacturaDTO> reporte(LocalDate fechaFactura);

}
