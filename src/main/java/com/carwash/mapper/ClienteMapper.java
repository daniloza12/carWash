package com.carwash.mapper;

import java.util.List;

import com.carwash.dto.ClienteDTO;
import com.carwash.entity.ClienteEntity;

public interface ClienteMapper {

	ClienteDTO toDTO(ClienteEntity e);
	
	ClienteEntity toEntity(ClienteDTO d);
	
	List<ClienteDTO> toLstDTO(List<ClienteEntity> lstE);

}
