package com.demoapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demoapi.entities.Product;
import com.demoapi.services.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Product>> findAll() {
		try {
			return new ResponseEntity<Iterable<Product>>(productService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Product>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "search1/{keyword}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Product>> search1(@PathVariable("keyword") String keyword) {
		try {
			return new ResponseEntity<Iterable<Product>>(productService.search1(keyword), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Product>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "search2/{min}/{max}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Product>> search2(@PathVariable("min") Double min, @PathVariable("max") Double max) {
		try {
			return new ResponseEntity<Iterable<Product>>(productService.search2(min, max), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
}
