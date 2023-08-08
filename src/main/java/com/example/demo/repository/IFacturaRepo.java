package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.FacturaDTO;

public interface IFacturaRepo {
	
	public void insertar(Factura factura);
	
	public List<FacturaDTO> reporte(LocalDate fechaFactura);

}
