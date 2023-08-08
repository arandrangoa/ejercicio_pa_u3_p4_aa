package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<FacturaDTO> reporte(LocalDate fechaFactura) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaDTO> query=this.entityManager.createQuery("select new com.example.demo.modelo.FacturaDTO(f.fecha) from Factura f where f.fecha= :datoFecha", FacturaDTO.class);
		query.setParameter("datoFecha", fechaFactura);
		return query.getResultList();
	}

}
