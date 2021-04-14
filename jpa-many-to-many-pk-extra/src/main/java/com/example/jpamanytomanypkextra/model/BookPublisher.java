package com.example.jpamanytomanypkextra.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Book_publisher")
public class BookPublisher {

    @EmbeddedId
    private BookPublisherId id;
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private int id;
    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;


    @ManyToOne
   @MapsId("publisherId")
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "publisher_date")
    private Date publisheDate;

    public BookPublisher( Book book, Publisher publisher, Date publisheDate) {
        this.id = new BookPublisherId(book.getId(),publisher.getId());
        this.book = book;
        this.publisher = publisher;
        this.publisheDate = publisheDate;
    }




}
