package com.trybe.spring.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.trybe.spring.domain.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  @DisplayName("add - Cenário de Sucesso")
  void add() {
    Book book = postBook("Teste Add Name", "Teste Add Author");
    Assertions.assertEquals("Teste Add Author", book.getAuthor());
  }

  @Test
  @DisplayName("findById - Cenário de Sucesso")
  void findById() {
    Book newBook = postBook("name findById1", "author findById1");
    Book book = this.restTemplate
        .exchange(getUrl() + "/" + newBook.getId().toString(), HttpMethod.GET, null, Book.class)
        .getBody();
    Assertions.assertEquals("name findById1", book.getName());
  }

  @Test
  @DisplayName("findById - Cenário de Erro - Livro não encontrado (404)")
  void findByIdNotFound() {
    ResponseEntity<?> response = this.restTemplate.exchange(getUrl() + "/" + UUID.randomUUID(),
        HttpMethod.GET, null, Void.class);
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }

  @Test
  @DisplayName("findAll - Cenário de Sucesso")
  void findAll() {
    Book book1 = postBook("name findAll1", "author findAll1");
    Book book2 = postBook("name findAll2", "author findAll2");
    List<Book> books = this.restTemplate
        .exchange(getUrl(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {})
        .getBody();
    Assertions.assertTrue(books.contains(book1));
    Assertions.assertTrue(books.contains(book2));
  }

  @Test
  @DisplayName("update - Cenário de Sucesso")
  void update() {
    Map<String, String> params = new HashMap<>();
    params.put("filter", "updateName1");

    Book book = postBook("Post name 1", "Post author 1");
    book.setName("updateName1");
    putBook(book);
    List<Book> books = this.restTemplate.exchange(getUrl() + "?filter={filter}", HttpMethod.GET,
        null, new ParameterizedTypeReference<List<Book>>() {}, params).getBody();
    Assertions.assertEquals(1, books.size());
    Assertions.assertEquals(book, books.get(0));
  }

  @Test
  @DisplayName("update - Cenário de Erro - Livro não encontrado (404)")
  void updateNotFound() {
    Book book = new Book("name updateNotFound", "author updateNotFound");
    ResponseEntity<?> response = putBook(book);
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }

  @Test
  @DisplayName("remove - Cenário de Sucesso")
  void remove() {
    Map<String, String> params = new HashMap<>();
    params.put("filter", "deleteName1");

    Book book = postBook("deleteName1", "deleteAuthor1");
    List<Book> books = this.restTemplate.exchange(getUrl() + "?filter={filter}", HttpMethod.GET,
        null, new ParameterizedTypeReference<List<Book>>() {}, params).getBody();
    Assertions.assertEquals(1, books.size());
    Assertions.assertEquals(book, books.get(0));

    deleteBook(book.getId());
    books = this.restTemplate.exchange(getUrl() + "?filter={filter}", HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Book>>() {}, params).getBody();
    Assertions.assertEquals(0, books.size());
  }

  @Test
  @DisplayName("remove - Cenário de Erro - Livro não encontrado (404)")
  void removeNotFound() {
    ResponseEntity<?> response = deleteBook(UUID.randomUUID());
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }

  private String getUrl() {
    return "http://localhost:" + port + "/api/books";
  }

  private Book postBook(String name, String author) {
    return this.restTemplate.postForObject(getUrl(), new BookDTO(name, author), Book.class);
  }

  private ResponseEntity<?> putBook(Book book) {
    return this.restTemplate.exchange(getUrl() + "/" + book.getId().toString(), HttpMethod.PUT,
        new HttpEntity<>(book), Void.class);
  }

  private ResponseEntity<?> deleteBook(UUID id) {
    return this.restTemplate.exchange(getUrl() + "/" + id.toString(), HttpMethod.DELETE, null,
        Void.class);
  }


  class BookDTO {

    public String name;
    public String author;

    public BookDTO(String name, String author) {
      this.name = name;
      this.author = author;
    }
  }
}
