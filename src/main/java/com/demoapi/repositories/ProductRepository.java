package com.demoapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demoapi.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("from Product where name like %:keyword%")
	public List<Product> search1(@Param("keyword") String keyword);

	@Query("from Product where price >= :min and price <= :max")
	public List<Product> search2(@Param("min") Double min, @Param("max") Double max);
}
