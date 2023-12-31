package dev.pavan.productservice;

import dev.pavan.productservice.inheritancemappings.joinedtable.MentorRepository;
import dev.pavan.productservice.inheritancemappings.joinedtable.UserRepository;
import dev.pavan.productservice.models.Category;
import dev.pavan.productservice.models.Price;
import dev.pavan.productservice.models.Product;
import dev.pavan.productservice.repositories.CategoryRepository;
import dev.pavan.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication{ //implements CommandLineRunner {

//	private MentorRepository mentorRepository;
//
//
//	private UserRepository userRepository;
//	private final ProductRepository productRepository;
//	private final CategoryRepository categoryRepository;
//
//	@Autowired
//	public ProductserviceApplication(@Qualifier("jt_mr") MentorRepository mentorRepository,
//									 @Qualifier("jt_ur") UserRepository userRepository,
//									 ProductRepository productRepository,
//									 CategoryRepository categoryRepository) {
//		this.mentorRepository = mentorRepository;
//		this.userRepository = userRepository;
//		this.productRepository = productRepository;
//		this.categoryRepository = categoryRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Naman");
//        mentor.setEmail("Naman@scaler.com");
//        mentor.setAverageRating(4.65);
//        mentorRepository.save(mentor);
//
//        User user = new User();
//        user.setName("Sarath");
//        user.setEmail("sarathcool@yopmail.com");
//        userRepository.save(user);
//
//        List<User> users = userRepository.findAll();
//        for (User user1: users) {
//            System.out.println(user1);
//        }

//		Category category = new Category();
//		category.setName("Apple Devices");
//	//	Category savedCategory = categoryRepository.save(category);
//
//		Price price = new Price();
//	//  Price savedPrice = priceRepository.save(price);


//		Product product = new Product();
//		product.setTitle("iPhone 15 Pro");
//		product.setDescription("The best iPhone Ever");
//		product.setCategory(category);
//		product.setPrice(price);
//
//		productRepository.save(product);
//
//		productRepository.deleteById(UUID.fromString("c3146983-47d1-4c29-9114-18dbe54d5080"));

//		Category category1 = categoryRepository.findById(UUID.fromString("1059c662-cca5-4f3e-b608-b3b263eef744")).get();
//		System.out.println("Category name is: " + category1.getName());
//		System.out.println("Printing all products in the category");
//		Thread.sleep(1000);
//
//        category1.getProducts().forEach(
//                product1 -> System.out.println(product1.getTitle())
//        );

//        for (Product product1: category1.getProducts()) {
//            try {
//                System.out.println(product1.getTitle());
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//	}
}
