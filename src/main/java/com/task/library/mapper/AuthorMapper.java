package com.task.library.mapper;

import com.task.library.dto.AuthorDto;
import com.task.library.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {

	AuthorDto entityToDto(AuthorEntity authorEntity);

	AuthorEntity dtoToEntity(AuthorDto authorDto);

}
