package com.carwash.mapper;

import java.util.List;

import com.carwash.dto.LoginDTO;
import com.carwash.entity.ClienteEntity;

public interface LoginMapper {

	LoginDTO toDTO(ClienteEntity e);
	
	ClienteEntity toEntity(LoginDTO d);
	
	List<LoginDTO> toLstDTO(List<ClienteEntity> lstE);

}
