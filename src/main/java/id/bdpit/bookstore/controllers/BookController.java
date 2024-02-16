package id.bdpit.bookstore.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.bdpit.bookstore.models.Book;
import id.bdpit.bookstore.payloads.BookRequest;
import id.bdpit.bookstore.payloads.Response;
import id.bdpit.bookstore.payloads.ResponseData;
import id.bdpit.bookstore.services.book.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<?> showBooks(@RequestParam(defaultValue = "", value = "title") String title) {
        try {
            // deklarasikan wadah untuk menampung response
            ResponseData<List<Book>> response;
            // cek apakah menampilkan semua buku atau mencari berdasarkan title
            if (title == "" || title == null || Objects.isNull(title) || title.equals("")) {
                // panggil method getBook dari BookServicesdan isi response
                response = bookService.getBooks();
            } else {
                // panggil method getBooksByTitle dari BookServices dan isi response
                response = bookService.getBooksByTitle(title);
            }
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequest request) {
        try {
            Response response = bookService.postBook(request);
            return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody BookRequest request) {
        try {
            ResponseData<Book> responseData = this.bookService.updateBook(id, request);
            return ResponseEntity.ok().body(responseData);
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        try {
            Response response = this.bookService.deleteBook(id);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            throw e;
        }
    }

}
