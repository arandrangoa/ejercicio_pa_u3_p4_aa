package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.DetalleFactura;
import com.example.demo.modelo.Factura;
import com.example.demo.modelo.FacturaDTO;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.ProductoDTO;
import com.example.demo.repository.IFacturaRepo;

@Service
public class FacturaServiceImpl implements IfacturaService{
	
	@Autowired
	private IFacturaRepo facturaRepo;
	
	@Autowired
	private IProductoService iProductoService;

	@Override
	public void agregar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepo.insertar(factura);
	}

	@Override
	public void realizarFactura(List<ProductoDTO> productos, String cedula) {
		// TODO Auto-generated method stub
		
		Factura f=new Factura();
		f.setFecha(LocalDate.now());
		f.setCedulaCliente(cedula);
		
		List<DetalleFactura> detalles=new ArrayList<>();
		BigDecimal valorTotal=new BigDecimal(0);
		
		for(ProductoDTO pro:productos) {
			Producto p=this.iProductoService.buscarPorCodigo(pro.getCodigoBarras());
			
			DetalleFactura deta=new DetalleFactura();
			deta.setCantidad(pro.getCantidad());
			deta.setFactura(f);
			deta.setPrecioUnitario(p.getPrecio());
			deta.setProducto(p);
		
			if(p.getStock()>=pro.getCantidad()) {
				deta.setSubtotal(p.getPrecio().multiply(new BigDecimal(pro.getCantidad())));
				valorTotal=valorTotal.add(deta.getSubtotal());
				
				p.setStock(p.getStock()-pro.getCantidad());
				this.iProductoService.modificar(p);
			} else {
				throw new RuntimeException();
			}
		detalles.add(deta);
		}
		
		f.setDetalles(detalles);
		f.setTotalFactura(valorTotal);
		this.facturaRepo.insertar(f);
		
	}

	@Override
	public List<FacturaDTO> reporte(LocalDate fechaFactura) {
		// TODO Auto-generated method stub
		return this.facturaRepo.reporte(fechaFactura);
	}
	
	

}
