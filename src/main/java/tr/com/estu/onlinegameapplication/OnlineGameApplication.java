package tr.com.estu.onlinegameapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "tr.com.estu.onlinegameapplication.repository.mongo")
public class OnlineGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineGameApplication.class, args);
	}

}
