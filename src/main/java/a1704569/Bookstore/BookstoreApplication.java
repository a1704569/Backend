package a1704569.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import a1704569.Bookstore.domain.Book;
import a1704569.Bookstore.domain.BookRepository;
import a1704569.Bookstore.domain.Category;
import a1704569.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository Crepository) {
		return (args) -> {
			Category category0= new Category("Fantasy");
			Category category1= new Category("Science");
			Category category2= new Category("Romance");
			Crepository.save(category0);
			Crepository.save(category1);
			Crepository.save(category2);
			
			Book b0 = new Book("Testikirja", "Ruokonen", 1993, 8854545, 50, category0);
			Book b1 = new Book("Testivihko", "Berg", 1988, 12153232, 10, category1);
			brepository.save(b0);
			brepository.save(b1);
			
			log.info("Getting Books for you!");
			for (Book book: brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
