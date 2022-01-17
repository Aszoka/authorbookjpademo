package com.example.demo.dataloader;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Dataloader implements ApplicationListener<ContextRefreshedEvent> {

    AuthorRepository authorRepository;
    BookRepository bookRepository;
    PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        initData();
    }

    private void initData() {

        Author auth1 = new Author("Robert", "Jordan");
        Publisher publisher1 = new Publisher("Orbit Books", "N/A");
        Book book1 = new Book("Wheel of Time", "572295");
        auth1.getBooks().add(book1);
        book1.getAuthors().add(auth1);
        book1.setPublisher(publisher1);
        authorRepository.save(auth1);
        publisherRepository.save(publisher1);
        bookRepository.save(book1);

        Author auth2 = new Author("Andrzej", "Sapkowski");
        Publisher publisher2 = new Publisher("SuperNowa", "N/A");
        Book book2 = new Book("The witcher", "65232");
        auth2.getBooks().add(book2);
        book2.getAuthors().add(auth2);
        book2.setPublisher(publisher2);
        authorRepository.save(auth2);
        publisherRepository.save(publisher2);
        bookRepository.save(book2);
    }
}
