package com.medicalfollow.microservicios.app.usuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicalfollow.microservicios.app.usuarios.models.entity.Usuarios;
import com.medicalfollow.microservicios.app.usuarios.models.repository.UsuariosRepository;

@Service

public class UsuariosServicesImpl implements UsuariosServices {

	@Autowired
	private UsuariosRepository repository;
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuarios> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuarios> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Usuarios save(Usuarios Usuarios) {
		return repository.save(Usuarios);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
