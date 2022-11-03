package com.task.library.mapper;

import com.task.library.dto.BookDto;
import com.task.library.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

	BookDto entityToDto(BookEntity bookEntity);

	BookEntity dtoToEntity(BookDto bookDto);

}
