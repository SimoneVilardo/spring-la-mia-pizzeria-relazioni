package org.java.spring.controller;

import org.java.spring.dto.PizzaOffertaSpecialeDTO;
import org.java.spring.pojo.OffertaSpeciale;
import org.java.spring.pojo.Pizza;
import org.java.spring.serv.OffertaSpecialeService;
import org.java.spring.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OffertaSpecialeController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private OffertaSpecialeService offertaspecialeService;
	
	
	@GetMapping("/pizzas/{id}/offertaspeciale")
    public String createDiscount(Model model, @PathVariable int id) {
        
        Pizza pizza = pizzaService.findById(id);
        
        OffertaSpeciale offerta = new OffertaSpeciale();
        
        offerta.setPizza(pizza);
        
        model.addAttribute("offerta", offerta);
        
        return "offertaspeciale-form";
    }
	
	
	@PostMapping("/pizzas/{id}/offertaspeciale")
	public String storeOffertaSpeciale(@ModelAttribute PizzaOffertaSpecialeDTO pizzaoffertaspecialeDTO, @PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		
		OffertaSpeciale offerta = new OffertaSpeciale(pizzaoffertaspecialeDTO.getTitolo(), pizzaoffertaspecialeDTO.getData_inizio(), pizzaoffertaspecialeDTO.getData_fine(), pizza);
		
		offertaspecialeService.save(offerta);
		
		return "redirect:/"; 
	}
	
	@GetMapping("/pizzas/{pizzaId}/offertaspeciale/edit/{offertaspecialeId}")
	public String editOffertaSpeciale (Model model, @PathVariable int pizzaId, @PathVariable int offertaspecialeId) {
	    OffertaSpeciale offerta = offertaspecialeService.findById(offertaspecialeId);
	    model.addAttribute("offerta", offerta);
	    return "offertaspeciale-form";
	}
	
	@PostMapping("/pizzas/{pizzaId}/offertaspeciale/edit/{offertaspecialeId}")
	public String updateOffertaSpeciale(@ModelAttribute PizzaOffertaSpecialeDTO pizzaoffertaspecialeDTO, @PathVariable int pizzaId, @PathVariable int offertaspecialeId) {
	    
	    Pizza pizza = pizzaService.findById(pizzaId);
	    OffertaSpeciale offerta = offertaspecialeService.findById(offertaspecialeId);

	    offerta.setTitolo(pizzaoffertaspecialeDTO.getTitolo());
	    offerta.setData_inizio(pizzaoffertaspecialeDTO.getData_inizio());
	    offerta.setData_fine(pizzaoffertaspecialeDTO.getData_fine());
	    offerta.setPizza(pizza);

	    offertaspecialeService.save(offerta);

	    return "redirect:/";
	}
	
	
}
