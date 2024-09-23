package com.carwash.service;

import static java.util.Objects.isNull;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carwash.dto.ClienteDTO;
import com.carwash.entity.ClienteEntity;
import com.carwash.mapper.ClienteMapper;
import com.carwash.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository clienteRepository;
	private final ClienteMapper clienteMapper;
 
	
	@Override
	public Optional<ClienteDTO> findByCorreoAndPassword(String user, String password) throws ClienteException {
		ClienteEntity clienteEntity = clienteRepository.findByCorreoAndPassword(user, password);
		ClienteDTO clienteDTO = clienteMapper.toDTO(clienteEntity);
		return Optional.ofNullable(clienteDTO);
	}

	@Override
	public Long save(ClienteDTO clienteDTO) throws ClienteException {
		ClienteEntity clienteEntity= clienteRepository.save(clienteMapper.toEntity(clienteDTO));	
		if (isNull(clienteEntity)) {
			throw new ClienteException("Error al resgitrar cliente");
		}
		return clienteEntity.getId();
	}
}
