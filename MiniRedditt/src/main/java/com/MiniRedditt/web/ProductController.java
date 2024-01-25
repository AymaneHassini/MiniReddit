package com.MiniRedditt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.MiniRedditt.domain.Product;
import com.MiniRedditt.domain.User;
import com.MiniRedditt.repositories.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/products")
	public String getProducts(ModelMap model) {
		return "product";
	}

	@GetMapping("/products/{productId}")
	public String getProduct(@PathVariable Long productId) {
		return "product";
	}

	// HTTP post means create
	@PostMapping("/products")
	public String createProduct(@AuthenticationPrincipal User user) {
		// annotation uses the authen user
		Product product = new Product();
		product.setPublished(false);
		product = productRepo.save(product);
		return "redirect:/products/" + product.getId(); // always redirect when doing a post
	}
}
