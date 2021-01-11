package com.smithHanna.ProductsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smithHanna.ProductsAndCategories.models.Category;
import com.smithHanna.ProductsAndCategories.models.Product;
import com.smithHanna.ProductsAndCategories.services.ProductAndCategoryService; 

@Controller
public class MainController {
	
	@Autowired
	private ProductAndCategoryService pService; 
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		return "newproduct.jsp"; 
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product")Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newproduct.jsp"; 
		}
		this.pService.createProduct(product);
		return "redirect:/products"; 
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category")Category category) {
		return "newcategory.jsp"; 
	}
	
	@PostMapping("/categories/new")
	public String createProduct(@Valid @ModelAttribute("category")Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newcategory.jsp"; 
		}
		this.pService.createCategory(category);
		return "redirect:/categories"; 
	}
	
	@GetMapping("/categories")
	public String allCategories(Model model) {
		List<Category> allCategories = this.pService.allCategories();
		model.addAttribute("allCategories", allCategories);
		return "allcategories.jsp"; 
	}
	
	@GetMapping("/products")
	public String allProducts(Model model) {
		List<Product> allProducts = this.pService.allProducts();
		model.addAttribute("allProducts", allProducts);
		return "allproducts.jsp"; 
	}
	
	@GetMapping("products/{id}")
	public String getCategoryInfo(@PathVariable("id")Long id, Model model) {
		Product product = this.pService.findProductById(id);
		model.addAttribute("product", product);
		model.addAttribute("noCategories", this.pService.findCategoriesNotInProducts(product));
		return "showprod.jsp"; 
		
	}
	
	@PostMapping("/products/{id}" )
	public String addCategory(@PathVariable("id")Long proId, @RequestParam("category")Long catId) {
		Product product = this.pService.findProductById(proId);
		Category category = this.pService.findCategoryById(catId);
		pService.updateProductCategory(product, category);
		return "redirect:/products/{id}"; 
	}
	@GetMapping("/categories/{id}")
	public String getProductInfo(@PathVariable("id")Long id, Model model) {
	Category category = this.pService.findCategoryById(id);
	List<Product> noProducts = this.pService.findProductsNotInCategory(category);
	model.addAttribute("category", category);
	model.addAttribute("noProducts", noProducts);
	return "showcat.jsp"; 
	}
	
	@PostMapping("/categories/{id}")
	public String addProduct(@PathVariable("id")Long id,@RequestParam("product") Long proId) {
		Product product = this.pService.findProductById(proId);
		Category category = this.pService.findCategoryById(id);
		this.pService.updateProductCategory(product, category);
		return "redirect:/categories/{id}"; 
	}
	
}

