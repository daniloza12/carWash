package com.carwash.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.carwash.dto.ClienteDTO;
import com.carwash.entity.ClienteEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ClienteMapperImpl implements ClienteMapper {
	
	public final ModelMapper modelMapper;

	@Override
	public ClienteDTO toDTO(ClienteEntity e) {
		return modelMapper.map(e, ClienteDTO.class);
	}

	@Override
	public List<ClienteDTO> toLstDTO(List<ClienteEntity> lstE) {
		
		return lstE.stream().map(e-> this.toDTO(e)).toList();
	}

	@Override
	public ClienteEntity toEntity(ClienteDTO d) {
		return modelMapper.map(d, ClienteEntity.class);
	}

}
