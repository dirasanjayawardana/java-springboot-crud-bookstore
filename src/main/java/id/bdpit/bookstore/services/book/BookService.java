package id.bdpit.bookstore.services.book;

import java.util.List;

import id.bdpit.bookstore.models.Book;
import id.bdpit.bookstore.payloads.BookRequest;
import id.bdpit.bookstore.payloads.Response;
import id.bdpit.bookstore.payloads.ResponseData;

public interface BookService {
    // read
    ResponseData<List<Book>> getBooks();
    ResponseData<List<Book>> getBooksByTitle(String title);

    // create
    Response postBook(BookRequest request);

    // update
    ResponseData<Book> updateBook(String id, BookRequest request);

    // delete
    Response deleteBook(String id);
}
