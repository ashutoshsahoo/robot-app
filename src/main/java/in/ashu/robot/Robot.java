package in.ashu.robot;

/**
 * Robot contract.
 *
 * @author ashutosh
 *
 */
public interface Robot {

	/**
	 * Robot walks with provided weight to the given distance.
	 *
	 * @param distance distance in km
	 * @param weight   weight in kg
	 */
	void carry(double distance, double weight);

	/**
	 * Scans a barcode.
	 */
	void scan();

	/**
	 * Charges robot battery.
	 */
	void reCharge();

	/**
	 * Provides robot battery status.
	 *
	 * @return battery percentage
	 */
	int showCharge();

}
