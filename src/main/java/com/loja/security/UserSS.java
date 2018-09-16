package com.loja.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.loja.models.enums.Perfil;

public class UserSS implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nivel;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public Long getId() {
		return id;
	}
	
	public UserSS() {
		
	}
	
	public UserSS(Long id, String nivel, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.nivel = nivel;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {	
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return nivel;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
}
