package in.ashu.robot;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

/**
 * Main entry point for the application.
 *
 * <p>
 * Creates the application context and start the REPL.
 * </p>
 *
 * @author ashutosh
 */

@SpringBootApplication
public class RobotAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotAppApplication.class, args);
	}

	@Bean
	public PromptProvider myPromptProvider() {
		return () -> new AttributedString("robot:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
	}
}
