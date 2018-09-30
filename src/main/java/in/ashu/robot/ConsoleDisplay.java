package in.ashu.robot;

import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.stereotype.Service;

/**
 * Robot {@link Display} implementation for console.
 *
 * @author ashutosh
 *
 */
@Service
public class ConsoleDisplay implements Display {

	@Override
	public void show(AnsiColor color, String message) {
		System.out.println(AnsiOutput.toString(color, message, AnsiColor.DEFAULT));
	}

}
