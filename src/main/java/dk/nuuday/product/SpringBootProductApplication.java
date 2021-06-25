package dk.nuuday.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableCaching
@SpringBootApplication
public class SpringBootProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductApplication.class, args);
	}
}