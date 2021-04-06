package com.demoapi.services;

import java.util.List;

import com.demoapi.entities.Product;

public interface ProductService {
	public Iterable<Product> findAll();

	public Product find(int id);

	public Product save(Product product);

	public boolean delete(int id);

	public List<Product> search1(String keyword);

	public List<Product> search2(Double min, Double max);
}
