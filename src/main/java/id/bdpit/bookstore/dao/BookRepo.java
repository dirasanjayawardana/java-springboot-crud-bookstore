package id.bdpit.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.bdpit.bookstore.models.Book;

public interface BookRepo extends JpaRepository<Book, String> {
    // berisi method untuk melakukan query ke database
    // secara default sudah ada method findAll(), save(), findById()
    // jika ingin menambahkan custom query bisa ditambahkan disini

    // contoh method untuk mencari data tertentu dengan native query
    @Query(value = "SELECT * FROM book WHERE UPPER(title) LIKE UPPER(CONCAT('%', ?, '%'));", nativeQuery = true)
    List<Book> searchByTitle(String title);

    // contoh custom method lainnya
    List<Book> findByTitleIgnoreCaseLike(String title);
}
