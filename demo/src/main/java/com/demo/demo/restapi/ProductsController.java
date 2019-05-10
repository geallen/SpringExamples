package com.demo.demo.restapi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.business.IProductService;
import com.demo.demo.entities.Product;

@RestController
@RequestMapping("/api")
public class ProductsController {

	IProductService productService;

	public ProductsController(IProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public List<Product> get(){
		return productService.getAll();
	}
	
	@PostMapping("/addProduct")
	public Product add(@RequestBody Product p) {
		productService.add(p);
		return p;
			
	}
	
	@PutMapping("/updateProduct")
	public Product update(@RequestBody Product p) {
		productService.update(p);
		return p;
			
	}
	
	@DeleteMapping("/deleteProduct")
	public Product delete(@RequestBody Product p) {
		productService.delete(p);
		return p;
			
	}
	
	@GetMapping("/getByCategoryId")
	public List<Product> getByCategoryId(@RequestParam(required=false, defaultValue = "1") int categoryId){
		return productService.getByCategoryId(categoryId);
		
	}
	
	@GetMapping("/search")
	public List<Product> search(@RequestParam String productName, @RequestParam String description){
		return productService.search(productName, description);
	}
	
}
