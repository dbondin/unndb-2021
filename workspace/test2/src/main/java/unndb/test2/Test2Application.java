package unndb.test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test2Application {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("org.postgresql.Driver");
		SpringApplication.run(Test2Application.class, args);
	}

}
