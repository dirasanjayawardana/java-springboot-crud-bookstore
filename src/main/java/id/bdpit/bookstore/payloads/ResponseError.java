package id.bdpit.bookstore.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // menambahkan setter getter
@AllArgsConstructor
public class ResponseError {
    private int status;
    private String error;
    private String message;
}
