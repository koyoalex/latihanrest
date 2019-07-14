package com.eksad.latihanrest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.latihanrest.dao.BrandDao;
import com.eksad.latihanrest.dao.ProductDao;
import com.eksad.latihanrest.model.Brand;
import com.eksad.latihanrest.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value= "/api/v1")
@Api(tags = "Product")
public class ProductController {

	@Autowired
	ProductDao productDao;

	@Autowired
	BrandDao brandDao;
	
	@ApiOperation(
			value = "API to retrieve Product's data by Brand ID",
			notes = "Return data with JSON format",
			tags = "Get Data API"
			)
	@RequestMapping("getByBrandId/{brandId}")
	public List<Product> getByBrandId(@PathVariable Long brandId) {
		List<Product> result = new ArrayList<Product>();
		productDao.findByBrandId(brandId).forEach(result::add);
		return result;
	}
	@ApiOperation(
			value = "Saving the new Product's Data",
			notes = "Saving the data to database",
			tags = "Data Manipulation API"
			)
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public Product save(@RequestBody Product product) {
		Brand brand = brandDao.findById(product.getBrandId()).orElse(null);
		if (brand != null) {
			product.setBrand(brand);
			return productDao.save(product);
		}
		return null;

		// update delete cari berdasarkan nama

	}
	@ApiOperation(
			value = "Update Products data",
			notes = "Update Products data to database",
			tags = "Data Manipulation API"
			)
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		Product productSelected = productDao.findById(id).orElse(null) ;
		if (productSelected != null) {
			productSelected.setBrand(product.getBrand());
			productSelected.setName(product.getName());
			productSelected.setType(product.getType());
			productSelected.setPrice(product.getPrice());
			productDao.save(productSelected);
			return productDao.save(productSelected);
			
		} else {
			
			return null;
		}


	}
	@ApiOperation(
			value = "Delete Product's Data",
			notes = "Delete Product's data from database",
			tags = "Data Manipulation API"
			)
	@RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
	public HashMap<String, Object> delete (@PathVariable Long id) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("massage", "sudah dihapus");
		return result;
		
	}
	@ApiOperation(
			value = "API to retrieve Product's data by Product's name",
			notes = "Return data with JSON format",
			tags = "Get Data API"
			)
	@RequestMapping("getByName/{name}")
	public List<Product> getByName(@PathVariable String name) {
		List<Product> result = new ArrayList<>();
		productDao.findByName(name).forEach(result::add);
		return result;
		
		
	}
	
}

		
		
	

