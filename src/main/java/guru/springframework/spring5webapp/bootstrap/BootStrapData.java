package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Set<Author> patelAuthor = new HashSet<>() ;
        Set<Book> books = new HashSet<>() ;
        Author patel = new Author("bipin", "patel",books);
        patelAuthor.add(patel);
        Book   airlines = new Book("airlines", "123", patelAuthor);
        Book   missionImpossible = new Book("missionImpossible", "456", patelAuthor);
        Book   inception = new Book("inception", "789", patelAuthor);
        books.add(airlines);
        books.add(missionImpossible);
        books.add(inception);

        authorRepository.save(patel);
        bookRepository.save(airlines);
        bookRepository.save(missionImpossible);
        bookRepository.save(inception);

        System.out.println("started in boostrap");
        System.out.println("number of books added " + bookRepository.count());
        System.out.println("number of authors added " + authorRepository.count());
    }
}
