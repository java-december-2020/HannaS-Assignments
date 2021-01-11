package com.smithHanna.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.ProductsAndCategories.models.Category;
import com.smithHanna.ProductsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
	List<Product> findByCategoriesNotContaining(Category category);
}
