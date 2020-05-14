package com.azulitadev.springboot.backend.apicater.models.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.azulitadev.springboot.backend.apicater.models.entity.IProductsProjection;
import com.azulitadev.springboot.backend.apicater.models.entity.Products;
public interface IProductsDao extends JpaRepository<Products, String>{

@Query(value = "select * from v_products", nativeQuery = true)
public Page<IProductsProjection> find(Pageable pageable);

@Query(value = "select * from v_products where name like %:terminal%", nativeQuery = true)
public List<IProductsProjection>finByTerminal(@Param("terminal") String terminal);

}
