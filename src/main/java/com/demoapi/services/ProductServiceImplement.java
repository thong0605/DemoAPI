package com.demoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapi.entities.Product;
import com.demoapi.repositories.ProductRepository;

@Service("productService")
public class ProductServiceImplement implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Iterable<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Product find(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		return repository.save(product);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Product> search1(String keyword) {

		return repository.search1(keyword);
	}

	@Override
	public List<Product> search2(Double min, Double max) {
		return repository.search2(min, max);
	}

}
