package com.task.library.service;

import com.task.library.dto.AuthorDto;
import com.task.library.mapper.AuthorMapper;
import com.task.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

	private final AuthorRepository authorRepository;

	private final AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);

	public AuthorDto getAuthor(Long authorId) {
		return authorMapper.entityToDto(authorRepository.findById(authorId).orElseThrow());
	}

	public void addAuthor(AuthorDto authorDto) {
		authorRepository.save(authorMapper.dtoToEntity(authorDto));
	}

	//Возможно логика будет расширяться исходя из бизнес требований, поэтому лучше оставить дубль методу addAuthor
	public void updateAuthor(AuthorDto authorDto) {
		authorRepository.save(authorMapper.dtoToEntity(authorDto));
	}

	public void deleteAuthor(Long authorId) {
		authorRepository.deleteById(authorId);
	}
}
