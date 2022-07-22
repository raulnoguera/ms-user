package com.medicalfollow.microservicios.app.users;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;

@Data
@Entity

public class user_1 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private LocalDateTime fechaRegistro;
	
	@PrePersist
	void prePersist() {
		setFechaRegistro(LocalDateTime.now());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
