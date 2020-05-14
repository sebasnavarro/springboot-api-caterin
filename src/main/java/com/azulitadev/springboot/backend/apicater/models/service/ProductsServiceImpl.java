package com.azulitadev.springboot.backend.apicater.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.azulitadev.springboot.backend.apicater.models.dao.IProductsDao;
import com.azulitadev.springboot.backend.apicater.models.entity.IProductsProjection;
import com.azulitadev.springboot.backend.apicater.models.entity.Products;

@Service
public class ProductsServiceImpl implements IProductsService {
	
	@Autowired
	private IProductsDao productsDao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<IProductsProjection> find(Pageable pageable) {
		// TODO Auto-generated method stub
		return productsDao.find(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<IProductsProjection> finByTerminal(String terminal) {
		// TODO Auto-generated method stub
		return productsDao.finByTerminal(terminal);
	}



	@Override
	@Transactional(readOnly = true)
	public List<Products> findAll() {
		return (List<Products>)productsDao.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Products findById(String id) {
		return productsDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Products save(Products articulo) {
		// TODO Auto-generated method stub
		return productsDao.save(articulo);
	}

	@Override
	@Transactional
	public void delete(String id) {
		productsDao.deleteById(id);
	}


	

}
