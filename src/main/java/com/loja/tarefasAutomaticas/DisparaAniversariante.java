package com.loja.tarefasAutomaticas;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class DisparaAniversariante {
	
	private static final String TIME_ZONE = "America/Sao_Paulo";
	
	@Scheduled(cron = "0 0 12 * * *", zone = TIME_ZONE)
	public void mandaEmailDeAniversário() {
		System.out.println("disparando teste");
	}
}
