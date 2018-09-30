package in.ashu.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the application.
 *
 * <p>Creates the application context and start the REPL.</p>
 *
 * @author ashutosh
 */

@SpringBootApplication
public class RobotAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotAppApplication.class, args);
	}
}
