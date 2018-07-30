package rocks.raccoon.terrarium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TerrariumApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerrariumApplication.class, args);
	}
}
