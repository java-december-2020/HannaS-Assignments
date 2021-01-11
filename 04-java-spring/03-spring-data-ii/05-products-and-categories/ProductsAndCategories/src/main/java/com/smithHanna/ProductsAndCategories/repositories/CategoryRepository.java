package com.smithHanna.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.ProductsAndCategories.models.Category;
import com.smithHanna.ProductsAndCategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	List<Category> findAll();
	
	List<Category> findByProductsNotContaining(Product product);
}
