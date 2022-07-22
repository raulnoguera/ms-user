package com.medicalfollow.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalfollow.microservicios.app.usuarios.models.entity.Usuarios;
import com.medicalfollow.microservicios.app.usuarios.services.UsuariosServices;

@RestController
public class UsuariosController {

	@Autowired
	private UsuariosServices service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Usuarios> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Usuarios Usuarios){
		Usuarios usuarioDb = service.save(Usuarios);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody Usuarios Usuarios, @PathVariable Long id){
		Optional<Usuarios> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuarios usuarioDb = o.get();
		usuarioDb.setNombre(Usuarios.getNombre());
		usuarioDb.setApellido(Usuarios.getApellido());
		usuarioDb.setEmail(Usuarios.getEmail());
		usuarioDb.setPassword(Usuarios.getPassword());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioDb));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
