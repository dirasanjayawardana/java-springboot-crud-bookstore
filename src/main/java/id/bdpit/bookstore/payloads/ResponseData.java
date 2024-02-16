package id.bdpit.bookstore.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// <T> generic class, tipe data dideklarasikan saat object dibuat
@Setter
@Getter
@NoArgsConstructor
public class ResponseData<T> extends Response {
    private T data;

    public ResponseData(String message, Boolean success, T data) {
        super(message, success);
        this.data = data;
    }
}
