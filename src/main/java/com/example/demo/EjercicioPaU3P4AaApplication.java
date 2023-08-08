package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.FacturaDTO;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.ProductoDTO;
import com.example.demo.service.IProductoService;
import com.example.demo.service.IfacturaService;

@SpringBootApplication
public class EjercicioPaU3P4AaApplication implements CommandLineRunner{
	
	private static final Logger LOG=LoggerFactory.getLogger(EjercicioPaU3P4AaApplication.class);
	
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IfacturaService ifacturaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Producto p=new Producto();
		p.setCategoria("Analgesicos");
		p.setCodigoBarras("AN1");
		p.setNombre("Analgan");
		p.setPrecio(new BigDecimal(5));
		p.setStock(60);
		
		this.iProductoService.agregar(p);
		
		Producto p2=new Producto();
		p2.setCategoria("Maquillaje");
		p2.setCodigoBarras("MA1");
		p2.setNombre("Axepcia");
		p2.setPrecio(new BigDecimal(5));
		p2.setStock(60);
		
		this.iProductoService.agregar(p2);
		
		
		ProductoDTO pD=new ProductoDTO();
		pD.setCantidad(30);
		pD.setCodigoBarras("AN1");
		
		ProductoDTO pD2=new ProductoDTO();
		pD2.setCantidad(30);
		pD2.setCodigoBarras("MA1");
		
		List<ProductoDTO> productosDTO=new ArrayList<>();
		productosDTO.add(pD);
		productosDTO.add(pD2);
		
		this.ifacturaService.realizarFactura(productosDTO, "1727193847");
		
		
//		List<FacturaDTO> facturas=this.ifacturaService.reporte(LocalDate.of(2023, 8, 7));
//		
//		for(FacturaDTO f:facturas) {
//			System.out.println(f);
//		}

	}

}
