package banhang.banhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BanhangApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanhangApplication.class, args);
	}

}
