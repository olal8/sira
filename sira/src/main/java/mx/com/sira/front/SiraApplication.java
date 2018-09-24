package mx.com.sira.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiraApplication.class, args);
	}
}
