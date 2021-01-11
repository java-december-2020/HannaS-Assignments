package com.smithHanna.ProductsAndCategories.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List; 

import com.smithHanna.ProductsAndCategories.models.Category;
import com.smithHanna.ProductsAndCategories.models.Product;
import com.smithHanna.ProductsAndCategories.repositories.CategoryRepository;
import com.smithHanna.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductAndCategoryService {
	
	@Autowired
	private ProductRepository pRepo; 
	@Autowired
	private CategoryRepository cRepo; 
	
	public ProductAndCategoryService() {
		
	}

	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public List<Product> allProducts(){
		return this.pRepo.findAll(); 
	}
	
	public List<Category> allCategories(){
		return this.cRepo.findAll();
	}
	
	public Product findProductById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public Category findCategoryById(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public void addCategory(Category category, Product product) {
		List<Category> categories = product.getCategories();
		categories.add(category);
		this.pRepo.save(product);
	}
	
	public List<Category> findCategoriesNotInProducts(Product product){
		return this.cRepo.findByProductsNotContaining(product);
	}
	
	public void addProduct(Product product, Category category) {
		List<Product> products = category.getProducts(); 
		products.add(product);
		this.cRepo.save(category);
	}
	
	public List<Product> findProductsNotInCategory(Category category){
		return this.pRepo.findByCategoriesNotContaining(category);
	}
	 public void updateProductCategory(Product product, Category category) {
	    	product.getCategories().add(category);
	    	pRepo.save(product);
	    }
} 
