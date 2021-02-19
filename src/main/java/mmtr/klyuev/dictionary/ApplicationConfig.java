package mmtr.klyuev.dictionary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("mmtr.klyuev.dictionary")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Bean
    DictionaryStorage latinDictionary(@Value("${latinDictionary}") String pathName) {
        return new DictionaryStorageOnFileSystem(pathName);
    }

    @Bean
    DictionaryStorage digitDictionary(@Value("${digitDictionary}") String pathName) {
        return new DictionaryStorageOnFileSystem(pathName);
    }
}
