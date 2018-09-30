package in.ashu.robot;

import org.springframework.boot.ansi.AnsiColor;
import org.springframework.stereotype.Service;

/**
 * Default implementation for {@link Robot}.
 *
 * @author ashutosh
 *
 */
@Service
public class RobotImplV1 implements Robot {

	private static final double NORMALWALK_KM_PER_1PC_CHARGE = 0.05; // Robot walks 5KM per charge(100%).

	private static final int NORMALWALK_CHARGECONSUMPTION_PER_KM = 20;

	private static final int CARRY_CHARGECONSUMTION_PER_KG = 2;

	/**
	 * A handler for {@link Display}.
	 */
	private final Display display;

	/**
	 * Battery charge percentage.
	 */
	private int charge = 100;

	/**
	 * Creates a {@link RobotImplV1} object with provided data.
	 *
	 * @param display {@link #display}
	 */
	public RobotImplV1(Display display) {
		super();
		this.display = display;
	}

	@Override
	public void carry(double distance, double weight) {

		if (weight > 10) {
			display.show(AnsiColor.RED, "Overweight");
		}

		double chargeConsumptionforWeight = CARRY_CHARGECONSUMTION_PER_KG * weight;
		double chargeConsumptionforWalking = NORMALWALK_CHARGECONSUMPTION_PER_KM * distance;
		int totalChargeConsumption = (int) (chargeConsumptionforWalking + chargeConsumptionforWeight);
		if (totalChargeConsumption > charge) {
			charge -= chargeConsumptionforWeight;
			double ableToWalk = charge * NORMALWALK_KM_PER_1PC_CHARGE;
			display.show(AnsiColor.DEFAULT,
					String.format("Battery is low,not able to walk.Remaining distance=%.1f", distance - ableToWalk));
			charge = 0;
		} else {
			charge -= totalChargeConsumption;
			display.show(AnsiColor.DEFAULT, "Walking complete.");
		}
		batteryLow();
	}

	@Override
	public void scan() {
		int price = 200; // scanner provides data.
		if (price != 0) { // scan failure
			display.show(AnsiColor.RED, "Scan Failure");
		} else {
			display.show(AnsiColor.DEFAULT, "Price is " + price);
		}
	}

	@Override
	public void reCharge() {
		display.show(AnsiColor.GREEN, String.format("Charging started,battery percentage=%d.", charge));
		charge = 100;
		display.show(AnsiColor.GREEN, "Charging completed.");
	}

	@Override
	public int showCharge() {
		return charge;
	}

	/**
	 * Validates if battery is low.
	 */
	private void batteryLow() {
		if (charge < 15) {
			display.show(AnsiColor.RED, "Low battery.");
		}
	}
}
