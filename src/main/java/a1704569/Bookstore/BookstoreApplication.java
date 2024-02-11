package a1704569.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import a1704569.Bookstore.domain.Book;
import a1704569.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b0 = new Book("Testikirja", "Ruokonen", 1993, 8854545, 50);
			Book b1 = new Book("Testivihko", "Berg", 1988, 12153232, 10);
			repository.save(b0);
			repository.save(b1);
		};
	}

}
