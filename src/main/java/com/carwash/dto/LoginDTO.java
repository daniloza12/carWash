package com.carwash.dto;

import lombok.Data;

@Data
public class LoginDTO{
	
	private Long id;
	private Integer dni;	
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String correo; 
	private String rol;

}


