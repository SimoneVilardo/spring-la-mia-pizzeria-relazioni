package org.java.spring.controller;

import java.util.List;

import org.java.spring.pojo.Ingrediente;
import org.java.spring.serv.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@GetMapping("/ingredienti")
    public String getIngredienti(Model model) {
        List<Ingrediente> ingredienti = ingredienteService.findAll();
        model.addAttribute("ingredienti", ingredienti);
        return "ingrediente_index";
    }
	
	@GetMapping("/ingredienti/create")
    public String createIngrediente(Model model) {
        Ingrediente ingrediente = new Ingrediente();
        model.addAttribute("ingrediente", ingrediente);
        return "ingrediente-form";
    }
	

	@PostMapping("/ingredienti/create")
	public String storeIngredienti(@ModelAttribute Ingrediente ingrediente, Model model) {
		
		ingredienteService.save(ingrediente);
		
		model.addAttribute("ingrediente", ingrediente);
		
		return "redirect:/ingredienti";
	}
	
	
	
	@PostMapping("/ingredienti/delete/{id}")
    public String deleteIngrediente(@PathVariable int id) {
        Ingrediente ingrediente = ingredienteService.findById(id);
        ingredienteService.delete(ingrediente);
        return "redirect:/ingredienti";
    }
}
