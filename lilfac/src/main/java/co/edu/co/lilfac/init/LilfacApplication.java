package co.edu.co.lilfac.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.co.lilfac"})
public class LilfacApplication {

	public static void main(String[] args) {
		SpringApplication.run(LilfacApplication.class, args);

	}

}
