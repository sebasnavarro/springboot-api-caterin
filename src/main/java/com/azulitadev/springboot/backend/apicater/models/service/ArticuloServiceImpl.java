package com.azulitadev.springboot.backend.apicater.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.azulitadev.springboot.backend.apicater.models.dao.IArticuloDao;
import com.azulitadev.springboot.backend.apicater.models.entity.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService {
	
	@Autowired
	private IArticuloDao articuloDao;

	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAll() {
		return (List<Articulo>)articuloDao.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Articulo findById(String id) {
		return articuloDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Articulo save(Articulo articulo) {
		// TODO Auto-generated method stub
		return articuloDao.save(articulo);
	}

	@Override
	@Transactional
	public void delete(String id) {
		articuloDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Articulo fecthByIdWithPrice(String id) {
		// TODO Auto-generated method stub
		return articuloDao.fecthByIdWithPrice(id);
	}

}
