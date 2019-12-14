package com.ahmedomer.javaspring.products;

import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmedomer.javaspring.products.models.Category;
//import com.ahmedomer.javaspring.products.models.CategoryProduct;
import com.ahmedomer.javaspring.products.models.Product;
import com.ahmedomer.javaspring.products.services.CategoryProductService;

@Controller
public class ProductsController {
	private final CategoryProductService categoryProductService;
	
	public ProductsController(CategoryProductService categoryProductService) {
		this.categoryProductService = categoryProductService;
	}
	////ROUTES\\\
	@RequestMapping("/products/new")
	public String index(@ModelAttribute("prodObj")Product product, Model model) {
		return "/products/index.jsp";
	}
	@RequestMapping(value="/newProd", method=RequestMethod.POST)
	public String addProd(@Valid @ModelAttribute("prodObj")Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/index.jsp";
		}
		else {
			categoryProductService.newProduct(product);
			return "redirect:/products/new";
		}
	}
	@RequestMapping("/products/{id}")
	public String prodInfo(@PathVariable("id")long id, Model model) {
		model.addAttribute("product", categoryProductService.findProduct(id));
		List<Category> catList = categoryProductService.allCategories();
		List<Category> mycategories = categoryProductService.findProduct(id).getCategories();
		for(int i=0; i < mycategories.size(); i++) {
			if(catList.contains(mycategories.get(i))) {
				catList.remove(mycategories.get(i));
			}
		}
		model.addAttribute("prodprod", mycategories);
		model.addAttribute("availCategory", catList);
		return "/products/prodinfo.jsp";
	}
	@PostMapping("/addCategory")
	public String catToProd(@RequestParam("thisCat")long category_id,@RequestParam("thisProd")long product_id, Model model) {
		//get category and product that are gonna be modified\\
		Product addedCat = categoryProductService.findProduct(product_id);
		Category freshProd = categoryProductService.findCat(category_id);
		
		///get category's product list, add product to it\\\
		List<Category> catList = addedCat.getCategories();
		catList.add(freshProd);
		
		///set category's product list, update category\\\
		addedCat.setCategories(catList);
		categoryProductService.update(freshProd);
		
		return "redirect:/products/"+ product_id;
	}
}
