package com.example.demo.service;

import com.example.demo.modelo.Producto;

public interface IProductoService {
	
	public void agregar(Producto producto);
	
	public void modificar(Producto producto);
	
	public Producto buscarPorCodigo(String codigoBarras);

}
