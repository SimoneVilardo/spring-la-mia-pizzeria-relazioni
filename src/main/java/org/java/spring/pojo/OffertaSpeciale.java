package org.java.spring.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OffertaSpeciale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titolo;
	private LocalDate data_inizio;
	private LocalDate data_fine;
	
	@ManyToOne
	private Pizza pizza;
	
	public OffertaSpeciale() { }
	public OffertaSpeciale(String titolo, LocalDate data_inizio, LocalDate data_fine, Pizza pizza) {
		
		setTitolo(titolo);
		setData_inizio(data_inizio);
		setData_fine(data_fine);
		setPizza(pizza);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public LocalDate getData_inizio() {
		return data_inizio;
	}
	public void setData_inizio(LocalDate data_inizio) {
		this.data_inizio = data_inizio;
	}
	public LocalDate getData_fine() {
		return data_fine;
	}
	public void setData_fine(LocalDate data_fine) {
		this.data_fine = data_fine;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getTitolo() + " - " + getData_inizio() + " - " + getData_fine();
	}
	
}
