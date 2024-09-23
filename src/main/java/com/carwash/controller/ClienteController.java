package com.carwash.controller;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.dto.ClienteDTO;
import com.carwash.dto.LoginDTO;
import com.carwash.service.ClienteService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

	private final ClienteService clienteService;
 
	
	@PostMapping("/login")
	public ResponseEntity<LoginDTO> login(@RequestBody ClienteDTO clienteDTO) {
		try {
			Optional<LoginDTO> clienteDTOResult = clienteService.findByCorreoAndPassword(clienteDTO.getCorreo(), 
																							clienteDTO.getPassword());
			if (isNull(clienteDTOResult)) {
				return ResponseEntity.badRequest().build();
			}		 
			return ResponseEntity.ok().body(clienteDTOResult.get());
		} catch (Exception e) {
			 
		 
			
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO) {
		try {
			Long id = clienteService.save(clienteDTO);
			if (isNull(id)) {
				return ResponseEntity.badRequest().build();
			}
			Map<String, Object> resp = new HashMap<>();
			resp.put("message", "El cliente fue registrado con exito");
			resp.put("ide", id);
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	 
}
