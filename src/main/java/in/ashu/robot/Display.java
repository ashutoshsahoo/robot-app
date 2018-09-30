package in.ashu.robot;

import org.springframework.boot.ansi.AnsiColor;

/**
 * Robot display contract.
 *
 * @author ashutosh
 *
 */
public interface Display {

	/**
	 * Displays the provided message.
	 *
	 * @param color {@linkplain AnsiColor} type
	 * @param message Message
	 */
	void show(AnsiColor color, String message);

}
