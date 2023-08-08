package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepo iProductoRepo;
	
	@Override
	public void modificar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepo.actualizar(producto);
	}
	
	
	@Override
	public void agregar(Producto producto) {
		// TODO Auto-generated method stub
		Producto pEncontrado=this.iProductoRepo.seleccionarPorCodigo(producto.getCodigoBarras());
		
		if(pEncontrado==null) {
			this.iProductoRepo.insertar(producto);
		}else {
			int stockAnterior=pEncontrado.getStock();
			int stockNuevo=producto.getStock();
			int stockAtualizado=stockAnterior+stockNuevo;
			pEncontrado.setStock(stockAtualizado);
			this.iProductoRepo.actualizar(pEncontrado);
		}
		
	}


	@Override
	public Producto buscarPorCodigo(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoRepo.seleccionarPorCodigo(codigoBarras);
	}

}
