package com.eksad.latihanrest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eksad.latihanrest.model.Brand;

public interface BrandDao extends CrudRepository<Brand,Long>

{
	public List<Brand> findByName(String name);
	public List<Brand> findByProductType(String type);
	
//	public List<Brand> findByList<Brand> findByProductType(String productType);
//	
//	
//	@Query ("select b from Brand b where name = :search")
//	public List<Brand> 
//	findBySearch("search")String search);
	
	}
