import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
	
	private Media media;
    private Payment payment;
    private double fee;
    private final LocalDate today;
    private LocalDate returnDate;

	/**
	 * A Rental object uses a provided payment method, beginning rental period date, 
	 * and rental fee while media is rented out.
	 * 
	 * @param media   rental media object
     * @param payment  payment method for rental
     * @param today rental date
     * @param fee  rental fee
	 */
	public Rental(Media media, Payment payment, LocalDate today, double fee) {
		this.media = media;
		this.payment = payment;
		this.today = (today != null) ? today : LocalDate.now();
		this.fee = fee;
	}
	/**
	 * Returns the rented media item.
	 *
	 * @return the media
	 */
	public Media getMedia() {
		return media;
	}
	
	/**
	 * Returns the payment method used for this rental.
	 *
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}
	
	/**
	 * Returns the date the media was rented.
	 *
	 * @return the rental date
	 */
	public LocalDate getRentDate() {
		return today;
	}
	
	/**
	 * Returns the rental fee.
	 *
	 * @return the fee
	 */
	public double getFee() {
		return fee;
	}
	
	/**
	 *  * Records the video return on the given date and returns the total rental fee.
	 * If not yet returned, sets the return date to {@code today}; otherwise, the
	 * existing return date is preserved. Either way, the total fee is returned.
	 * 
	 * @param today the current date to use as the return date if not already set
	 * @return the total rental fee based on the return date
	 */
	public double dropoff(LocalDate today) {
		if (returnDate == null) {
	        // not yet returned, set the return date
	        returnDate = today;
	    }
		// whether already returned or not, report the total fee
	    return getTotalFee(returnDate);
	}
	
	//return date being null means the rented media is still rented out.	
	public boolean isRented() {
	    return returnDate == null; //still rented
	}
	
	/**
	 * Returns the total number of days the video was/has been rented.
	 * If already returned, uses the return date; otherwise, uses {@code today}.
	 *
	 * @param today the current date, used if the video has not yet been returned
	 * @return the number of days between the rental date and the return (or current) date
	 */
	public int daysRented(LocalDate today) {
		LocalDate endDate = (returnDate != null) ? returnDate : today;
		long daysRented = this.today.until(endDate, ChronoUnit.DAYS);
		return (int) daysRented; 
	}
	
	/**
	 * computes the total fee for the rental based on
	 * how many days the media has been rented.
	 * 
	 * @param Local Date of todays date.
	 * @return total fees 
	 */
	public double getTotalFee(LocalDate today) {
	    return fee;
	}
	
	/**
	 * Returns string representation of rental object (media, today, payment)
	 *
	 * @return the string Rental
	 */
	@Override public String toString() {
		return media + ", rented on " + today + " using " + payment; 
	}
}
