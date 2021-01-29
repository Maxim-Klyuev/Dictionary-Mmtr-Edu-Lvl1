package mmtr.klyuev.dictionary;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("mmtr.klyuev.dictionary")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

}
