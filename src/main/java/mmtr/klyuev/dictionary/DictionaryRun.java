package mmtr.klyuev.dictionary;

import mmtr.klyuev.dictionary.config.ApplicationConfig;
import mmtr.klyuev.dictionary.menu.ConsoleMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DictionaryRun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ConsoleMenu consoleMenu = context.getBean("consoleMenu", ConsoleMenu.class);

        consoleMenu.runConsole();

        context.close();
    }
}
