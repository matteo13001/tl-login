package mondo.conv.tra.tllogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "mondo.conv.tra")
@EntityScan(basePackages = "mondo.conv.tra.login.entity")
@EnableJpaRepositories("mondo.conv.tra.login.repository")
public class TlLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(TlLoginApplication.class, args);
	}

}
