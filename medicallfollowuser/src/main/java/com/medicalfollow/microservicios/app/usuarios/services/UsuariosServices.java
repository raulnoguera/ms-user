package com.medicalfollow.microservicios.app.usuarios.services;

import java.util.Optional;

import com.medicalfollow.microservicios.app.usuarios.models.entity.Usuarios;

public interface UsuariosServices {
	public Iterable<Usuarios> findAll();
	
	public Optional<Usuarios> findById(Long id);
	
	public Usuarios save(Usuarios Usuarios);
	
	public void deleteById(Long id);
	

}
