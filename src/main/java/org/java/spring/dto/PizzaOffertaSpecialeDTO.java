package org.java.spring.dto;

import java.time.LocalDate;

public class PizzaOffertaSpecialeDTO {
	
		private String titolo;
	  	private LocalDate data_inizio;
	    private LocalDate data_fine;
	    
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
	   
	
}
