package com.carwash.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.carwash.dto.LoginDTO;
import com.carwash.entity.ClienteEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class LoginMapperImpl implements LoginMapper {
	
	public final ModelMapper modelMapper;

	@Override
	public LoginDTO toDTO(ClienteEntity e) {
		return modelMapper.map(e, LoginDTO.class);
	}

	@Override
	public List<LoginDTO> toLstDTO(List<ClienteEntity> lstE) {
		
		return lstE.stream().map(e-> this.toDTO(e)).toList();
	}

	@Override
	public ClienteEntity toEntity(LoginDTO d) {
		return modelMapper.map(d, ClienteEntity.class);
	}

}
