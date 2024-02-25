package a1704569.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a1704569.Bookstore.domain.Category;
import a1704569.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping (value="/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping (value="/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping (value="/categorysave", method = RequestMethod.POST)
	public String save(Category category) {
		creposity.save(category);
		return "redirect:categorylist";
	}
	

}
