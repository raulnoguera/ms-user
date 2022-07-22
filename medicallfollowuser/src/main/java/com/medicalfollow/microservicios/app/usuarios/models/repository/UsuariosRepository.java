package com.medicalfollow.microservicios.app.usuarios.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.medicalfollow.microservicios.app.usuarios.models.entity.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {

}
