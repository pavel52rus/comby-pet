package com.task.library.controller;

import com.task.library.dto.AuthorDto;
import com.task.library.service.AuthorService;
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
@RequestMapping(API_PREFIX + "/author")
@RequiredArgsConstructor
public class AuthorController {

	private final AuthorService authorService;

	@GetMapping("/{author-id}")
	public ResponseEntity<AuthorDto> getBook(@PathVariable(name = "author-id") Long authorId) {
		return ResponseEntity.ok(authorService.getAuthor(authorId));
	}

	@PostMapping
	public ResponseEntity<Void> postBook(@RequestBody AuthorDto authorDto) {
		authorService.addAuthor(authorDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> putBook(@RequestBody AuthorDto authorDto) {
		authorService.updateAuthor(authorDto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{author-id}")
	public ResponseEntity<Void> deleteBook(@PathVariable(name = "author-id") Long authorId) {
		authorService.deleteAuthor(authorId);
		return ResponseEntity.ok().build();
	}
}
