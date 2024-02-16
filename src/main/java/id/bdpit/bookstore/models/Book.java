package id.bdpit.bookstore.models;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@NoArgsConstructor
// @Data // membuat setter dan getter
@Setter
@Getter 
public class Book {
    @Id 
    @UuidGenerator // generate random id
    private String id;

    @Column(nullable = false)
    private String title;

    private String description;

    private Boolean isDeleted = false;

    @CreationTimestamp 
    private Instant createdAt;

    @UpdateTimestamp 
    private Instant updateAt;

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }
}

// @Entity: Menandakan bahwa kelas Book merupakan entitas yang akan dipetakan ke dalam tabel database.

// @Entity: Menandakan bahwa kelas Book merupakan entitas yang akan dipetakan ke dalam tabel database.

// @Table(name = "book"): Menentukan nama tabel database yang akan digunakan untuk menyimpan objek dari kelas Book. Dalam hal ini, tabel tersebut diberi nama "book".

// @NoArgsConstructor: Anotasi Lombok yang memberikan konstruktor default tanpa parameter.

// @Setter dan @Getter: Anotasi Lombok yang otomatis menghasilkan metode setter dan getter untuk semua atribut kelas.

// @Id: Menandakan bahwa atribut id adalah kunci utama (primary key) dari entitas ini.

// @UuidGenerator: Anotasi yang menandakan bahwa nilai atribut id akan dihasilkan menggunakan UUID generator.

// @Column(nullable = false): Menentukan bahwa kolom yang sesuai dengan atribut title tidak boleh bernilai null.

// @CreationTimestamp: Anotasi Hibernate yang menghasilkan nilai timestamp saat entitas dibuat.

// @UpdateTimestamp: Anotasi Hibernate yang menghasilkan nilai timestamp saat entitas diupdate.

// Atribut isDeleted: Atribut ini mungkin digunakan untuk menandai apakah entitas ini telah dihapus atau tidak.

// Konstruktor public Book(String title, String desc): Konstruktor untuk membuat objek Book dengan memberikan nilai awal pada atribut title dan desc.