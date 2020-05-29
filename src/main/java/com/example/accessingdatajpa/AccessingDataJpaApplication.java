package com.example.accessingdatajpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

  private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataJpaApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CustomerRepository repository, AccountRepository repository2) {
    return (args) -> {
      // save a few customers
      repository.save(new Customer("Jack", "Bauer"));
      repository.save(new Customer("Chloe", "O'Brian"));
      repository.save(new Customer("Kim", "Bauer"));
      repository.save(new Customer("David", "Palmer"));
      repository.save(new Customer("Michelle", "Dessler"));
      Customer b = new Customer("Mateusz" ,"Wysocki");
      repository.save(b);
      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Customer customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      Customer customer = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });

      log.info("");
      
      log.info("********************************************************");
		repository2.save(new Account("Jack", 1000));
		repository2.save(new Account("Chloe", 800));
		repository2.save(new Account("Kim", 700));
		repository2.save(new Account("David", 900));
		repository2.save(new Account("Michelle", 500));
		repository2.save(new Account("Mateusz", 1400));
		repository2.save(new Account("Mateusz", 1700));

		
		log.info("Get accounts, which balance is in between desired values.");
		List<Account> account = repository2.findByBalanceBetween(1400, 1700);
		log.info(account.toString());
		log.info("-------------------------------");
		
		log.info("Get accounts, which name starts with some string.");
		log.info("-------------------------------");
		for (Account startWith: repository2.findByNameStartingWith("K")) {
			log.info(startWith.toString());
		}
		log.info("-------------------------------");
		
		log.info("Get accounts by id.");
		for (Account findid : repository2.findById(8)) {
			log.info(findid.toString());
		}
    };
  }

}