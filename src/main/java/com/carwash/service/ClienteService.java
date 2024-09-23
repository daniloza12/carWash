package com.carwash.service;

import java.util.Optional;

import com.carwash.dto.ClienteDTO;

public interface ClienteService {
	
	Optional<ClienteDTO> findByCorreoAndPassword(String user, String password) throws ClienteException, IllegalArgumentException, InterruptedException;

	 
	
	Long save(ClienteDTO clienteDTO)throws ClienteException;
	
}
