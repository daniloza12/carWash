package com.carwash.service;

import static java.util.Objects.isNull;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carwash.dto.ClienteDTO;
import com.carwash.dto.LoginDTO;
import com.carwash.entity.ClienteEntity;
import com.carwash.mapper.ClienteMapper;
import com.carwash.mapper.LoginMapper;
import com.carwash.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository clienteRepository;
	private final ClienteMapper clienteMapper;
	private final LoginMapper loginMapper;

	
	@Override
	public Optional<LoginDTO> findByCorreoAndPassword(String user, String password) throws ClienteException {
		ClienteEntity clienteEntity = clienteRepository.findByCorreoAndPassword(user, password);
		LoginDTO loginDTO = loginMapper.toDTO(clienteEntity);
		return Optional.ofNullable(loginDTO);
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
