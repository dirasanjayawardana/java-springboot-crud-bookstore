package id.bdpit.bookstore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//=== bentuk request ada 3 macam
// query params (localhost:4000/?namaQuery=value) --> @RequestParam
// path variabel/params (localhost:4000/name/:namaParams) --> @PathVariable
// body req ({name: "dira", age: 24}) --> @RequestBody

@RestController // anotasi class
public class greetingController {

    @GetMapping("/hello") // anotasi method
    // @RequestaParam --> localhost:8080/?name=value
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/hello2/{userId}") // anotasi method
    // @RequestaParam --> localhost:8080/hello2/123
    public String hello2(@PathVariable(value = "userId") String id) {
        return "IDnya adalah " + id;
    }

    @PostMapping("/user")
    // Object --> tipe data global (bisa untuk tipe data apa saja), jadi data yang di body boleh apa saja
    public Object addUser(@RequestBody Object data){
        return data;
    }
}
