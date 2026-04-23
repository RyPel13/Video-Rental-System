/**
 * Stores credit card payment information for a customer.
 */
public class Payment {
	
	private String cardNo;
	private String name;
	private int expMonth;
	private int expYear;

	/**
     * Constructs a Payment with the given card number, name, and expiration date.
     * Month must be between 1–12 and year must not be in the past.
     *
     * @param cardNo   the credit card number
     * @param name     the cardholder's name
     * @param expMonth the expiration month (1–12)
     * @param expYear  the expiration year (2026 or later)
     * @throws IllegalArgumentException if the month is invalid or the card is expired
     */
	public Payment(String cardNo, String name, int expMonth, int expYear) {
	    this.cardNo = cardNo;
	    this.name = name;
	    this.expMonth = expMonth;
	    this.expYear = expYear;
	}
	
	/**
     * Returns the credit card number.
     *
     * @return the card number
     */
	public String getCardNo() {
		return cardNo;
	}
	
	/**
     * Returns the cardholder's name.
     *
     * @return the name
     */
	public String getName() {
		return name;
	}
	
	/**
     * Returns the expiration month.
     *
     * @return the expiration month (1–12)
     */
	public int getExpMonth() {
		return expMonth;
	}
	
	/**
     * Returns the expiration year.
     *
     * @return the expiration year
     */
	public int getExpYear() {
		return expYear;
	}
	
	/**
     * Returns payment info in the format "#CARDNUMBER (NAME), exp MONTH/YEAR".
     *
     * @return a formatted string representation
     */
	@Override public String toString() {
		return "#" + cardNo + " (" + name + "), exp " + expMonth + "/" + expYear; 
	}
}
