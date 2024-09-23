package com.carwash.service;

import java.util.Optional;

import com.carwash.dto.ClienteDTO;
import com.carwash.dto.LoginDTO;

public interface ClienteService {
	
	Optional<LoginDTO> findByCorreoAndPassword(String user, String password) throws ClienteException, IllegalArgumentException, InterruptedException;
 
	Long save(ClienteDTO clienteDTO)throws ClienteException;
	
}
