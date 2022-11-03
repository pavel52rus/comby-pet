package com.task.library.controller;

import com.task.library.dto.BookDto;
import com.task.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.task.library.base.LibraryConstant.API_PREFIX;

@RestController
@RequestMapping(API_PREFIX + "/book")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;

	@GetMapping("/{book-id}")
	public ResponseEntity<BookDto> getBook(@PathVariable(name = "book-id") Long bookId) {
		return ResponseEntity.ok(bookService.getBook(bookId));
	}

	@PostMapping
	public ResponseEntity<Void> postBook(@RequestBody BookDto bookDto) {
		bookService.addBook(bookDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> putBook(@RequestBody BookDto bookDto) {
		bookService.updateBook(bookDto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{book-id}")
	public ResponseEntity<Void> deleteBook(@PathVariable(name = "book-id") Long bookId) {
		bookService.deleteBook(bookId);
		return ResponseEntity.ok().build();
	}
}
