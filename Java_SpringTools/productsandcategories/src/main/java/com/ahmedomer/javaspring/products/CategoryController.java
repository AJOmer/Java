package com.ahmedomer.javaspring.products;


import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmedomer.javaspring.products.models.Category;
import com.ahmedomer.javaspring.products.models.Product;
import com.ahmedomer.javaspring.products.services.CategoryProductService;

@Controller
public class CategoryController {
	private final CategoryProductService categoryProductService;
	
	public CategoryController(CategoryProductService categoryProductService) {
		this.categoryProductService = categoryProductService;
	}
	////ROUTES\\\\
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("catObj")Category category, Model model) {
		return "/products/newcat.jsp";
	}
	@RequestMapping(value ="/newCat", method=RequestMethod.POST)
	public String addCat(@Valid @ModelAttribute("catObj")Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/newcat.jsp";
		}
		else {
			categoryProductService.addCat(category);
			return "redirect:/categories/new";
		}
	}
	@RequestMapping("/categories/{id}")
	public String catInfo(@PathVariable("id") long id, Model model) {
		model.addAttribute("category", categoryProductService.findCat(id));
		List<Product> productList = categoryProductService.allProducts();
		List<Product> myproduct = categoryProductService.findCat(id).getProducts();
		for(int i = 0; i < myproduct.size();i++) {
			if(productList.contains(myproduct.get(i))) {
			productList.remove(myproduct.get(i));
			}
			else {
				return"redirect:/categories/new";
			}
		}
		model.addAttribute("caegory", myproduct);
		model.addAttribute("availProducts", productList);
		return "/products/catinfo.jsp";
	}
	@PostMapping("/addProduct")
	private String add(@RequestParam("product_id") long product_id, @RequestParam("category_id") long category_id) {
		//get category and product that are gonna be modified\\
		Category freshCat = categoryProductService.findCat(category_id);
		Product addedProd = categoryProductService.findProduct(product_id);
		
		///get category's product list, add product to it\\\
		List<Product> prodList = freshCat.getProducts();
		prodList.add(addedProd);
		
		///set category's product list, update category\\\
		freshCat.setProducts(prodList);
		categoryProductService.update(freshCat);
		
		return "redirect:/categories/"+ category_id;
	}
}
