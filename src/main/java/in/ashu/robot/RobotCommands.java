package in.ashu.robot;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * REPL for {@link Robot}.
 *
 * @author ashutosh
 *
 */
@ShellComponent
public class RobotCommands {

	/**
	 * A handler for {@link Robot}.
	 */
	private final Robot robot;

	/**
	 * Creates a {@link RobotCommands} object with provided data.
	 *
	 * @param robot
	 */
	public RobotCommands(Robot robot) {
		super();
		this.robot = robot;
	}

	@ShellMethod(value = "Robot carries the object of given weight in kg to the given distnace in km.",key= {"carry","walk"})
	public void carry(@ShellOption(defaultValue = "0") double distance,
			@ShellOption(defaultValue = "0") double weight) {
		robot.carry(distance, weight);
	}

	@ShellMethod(value = "Charge the robot battery.")
	public void charge() {
		robot.reCharge();
	}

	@ShellMethod(value = "Robot scans a barcode and displays it's price.")
	public void scan() {
		robot.scan();
	}

	@ShellMethod(value = "Show remaining charge.")
	public int status() {
		return robot.showCharge();
	}

	public Availability carryAvailability() {
		return robot.showCharge() > 0 ? Availability.available() : Availability.unavailable("battery is low,please charge battery.");
	}
}
