package com.loja.tarefasAutomaticas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.loja.models.Aniversariante;
import com.loja.repository.AniversarianteRepository;
import com.loja.services.EmailService;

@Component
@EnableScheduling
public class DisparaAniversariante {
	
	private static final String TIME_ZONE = "America/Sao_Paulo";
	
	@Autowired
	private AniversarianteRepository aniversarianteRepository;
	
	@Autowired
	private EmailService email;
	
	@Scheduled(cron = "0/20 * * * * ?", zone = TIME_ZONE)
	public void mandaEmailDeAniversário() {
		
		List<Aniversariante> aniversariantes = aniversarianteRepository.findAll();
						
		for (Aniversariante aniversariante : aniversariantes) {
			
			List<Aniversariante> getDatasAniversariantes = 
			  aniversarianteRepository.findAniversarianteByDataAniversario(aniversariante.getDataAniversario());
			
			if (getDatasAniversariantes != null) {
				
				System.out.println("Preparando email...");
				
				
					
					email.enviar(
							aniversariante.getEmail(), 
							"Aniversáriantes - Loja Templários!", 
							"Temos aniversáriantes hoje, de parabéns para " + "");
				
				
				System.out.println("email enviado!");
			}
		}
		
	} 
}
