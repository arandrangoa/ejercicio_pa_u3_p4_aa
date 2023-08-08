package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public Producto seleccionarPorCodigo(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> query=this.entityManager.createQuery("select p from Producto p where p.codigoBarras= :datoCodigo", Producto.class);
		query.setParameter("datoCodigo", codigoBarras);
		
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
