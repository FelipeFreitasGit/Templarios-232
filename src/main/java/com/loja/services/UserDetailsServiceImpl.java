package com.loja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loja.models.UsuarioLogin;
import com.loja.repository.LoginRepository;
import com.loja.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private LoginRepository repo;

	@Override
	public UserDetails loadUserByUsername(String nivel) throws UsernameNotFoundException {
		
		UsuarioLogin user = repo.findByNivelLogin(nivel);
		if (user == null) {
			throw new UsernameNotFoundException(nivel);
		}
		
		return new UserSS(user.getId(), user.getNivelLogin(), user.getSenha(), user.getPerfis());
	}

}
