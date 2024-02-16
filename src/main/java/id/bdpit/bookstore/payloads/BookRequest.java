package id.bdpit.bookstore.payloads;

import lombok.Data;

@Data // menambahkan setter getter
public class BookRequest {
    private String title;
    private String description;
}
