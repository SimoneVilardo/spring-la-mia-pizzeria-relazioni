package org.java.spring;

import org.java.spring.pojo.Ingrediente;
import org.java.spring.pojo.Pizza;
import org.java.spring.serv.IngredienteService;
import org.java.spring.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbPizzeriaApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DbPizzeriaApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		Ingrediente ing1 = new Ingrediente("Mozzarella");
		Ingrediente ing2 = new Ingrediente("Pomodoro");
		Ingrediente ing3 = new Ingrediente("Funghi");
		Ingrediente ing4 = new Ingrediente("Prosciutto");
		Ingrediente ing5 = new Ingrediente("Peperoni");
		Ingrediente ing6 = new Ingrediente("Cipolla");
		Ingrediente ing7 = new Ingrediente("Olive");
		Ingrediente ing8 = new Ingrediente("Salsiccia");
		Ingrediente ing9 = new Ingrediente("Basilico");
		Ingrediente ing10 = new Ingrediente("Capperi");
		
		ingredienteService.save(ing1);
		ingredienteService.save(ing2);
		ingredienteService.save(ing3);
		ingredienteService.save(ing4);
		ingredienteService.save(ing5);
		ingredienteService.save(ing6);
		ingredienteService.save(ing7);
		ingredienteService.save(ing8);
		ingredienteService.save(ing9);
		ingredienteService.save(ing10);
		
		pizzaService.save(new Pizza("Margherita", "Pizza classica con pomodoro, mozzarella e basilico.", "https://images.prismic.io/eataly-us/ed3fcec7-7994-426d-a5e4-a24be5a95afd_pizza-recipe-main.jpg?auto=compress,format", 9.3, ing1, ing2, ing9));
		pizzaService.save(new Pizza("Diavola", "Pizza piccante con salame pizzante e formaggio fuso.", "https://www.lucianopignataro.it/wp-content/uploads/2023/02/Elementi-Pizzeria-Diavola-480x480.png", 10.5, ing3, ing4));
		pizzaService.save(new Pizza("Siciliana", "Pizza in stile siciliano con pomodori, olive e capperi.", "https://italianspizza.it/wp-content/uploads/2022/06/FAMILY-PIZZA-SICILIANA-online-pizza-sconti-eventi-feste-delivery-consegna-a-domicilio-san-colombano-al-lambro-lambrinia-monteleone-lodi-milano-italia.jpg", 11.7, ing5, ing8));
		pizzaService.save(new Pizza("Quattro Stagioni", "Pizza con vari ingredienti rappresentanti le quattro stagioni.", "https://i0.wp.com/www.piccolericette.net/piccolericette/wp-content/uploads/2016/07/3017_Pizza.jpg?resize=895%2C616&ssl=1", 12.9, ing10, ing7));
		pizzaService.save(new Pizza("Capricciosa", "Carciofi, prosciutto, funghi e olive rendono questa pizza saporita.", "https://i0.wp.com/www.pizzeriagirasole.net/wp-content/uploads/2021/02/WhatsApp-Image-2021-02-10-at-12.40.27.jpeg?fit=1188%2C1135&ssl=1", 13.1, ing6, ing10, ing1));
		pizzaService.save(new Pizza("Marinara", "Pizza semplice con pomodoro, aglio, origano e olio d'oliva.", "https://it.ooni.com/cdn/shop/articles/marinara-for-web.jpg?crop=center&height=800&v=1635275961&width=800", 8.2, ing2, ing4, ing6, ing8, ing9));
		pizzaService.save(new Pizza("Napoletana", "Pizza napoletana tradizionale con pomodoro, mozzarella e basilico.", "https://www.saporinostri.it/wp-content/uploads/2020/10/le-origini-della-pizza-napoletana-e1601990439881.jpg", 9.4, ing8, ing9, ing3));

		
	}

}
