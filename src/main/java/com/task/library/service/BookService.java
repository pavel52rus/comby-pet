package com.task.library.service;

import com.task.library.dto.BookDto;
import com.task.library.mapper.BookMapper;
import com.task.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;

	private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

	public BookDto getBook(Long bookId) {
		return bookMapper.entityToDto(bookRepository.findById(bookId).orElseThrow());
	}

	public void addBook(BookDto bookDto) {
		bookRepository.save(bookMapper.dtoToEntity(bookDto));
	}

	public void updateBook(BookDto bookDto) {
		bookRepository.save(bookMapper.dtoToEntity(bookDto));
	}

	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}
}
