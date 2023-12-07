package org.java.spring.serv;

import java.util.List;

import org.java.spring.pojo.OffertaSpeciale;
import org.java.spring.repo.OffertaSpecialeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffertaSpecialeService {

	@Autowired
	private OffertaSpecialeRepo offertaspecialeRepo;
	
	public List<OffertaSpeciale> findAll(){
		
		return offertaspecialeRepo.findAll();

	}
	
	public OffertaSpeciale findById(int id) {
		
		return offertaspecialeRepo.findById(id).get();
	}
	
	public void save(OffertaSpeciale offertaspeciale) {
		
		offertaspecialeRepo.save(offertaspeciale);
	}
	
	public void delete(OffertaSpeciale offertaspeciale) {
		
		offertaspecialeRepo.delete(offertaspeciale);
	}
	
	
}
