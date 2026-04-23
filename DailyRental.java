import java.time.LocalDate;
/**
 * A daily rental that charges a per-day fee instead of a flat rate.
 * Extends {@link Rental} and overrides fee calculation to support daily
 * charges and an optional promo credit.
 */
public class DailyRental extends Rental {
	
	private double credit; // only need credit, other variables are inherited
	/**
     * Constructs a DailyRental with the specified media, payment, date, daily fee, and promo credit.
     *
     * @param media   the media being rented
     * @param payment the payment method
     * @param today   the rental start date
     * @param fee     the daily rental fee
     * @param credit  the promo credit to apply
     */
	public DailyRental(Media media, Payment payment, LocalDate today, double fee, double credit) {
		super(media, payment, today, fee);
		this.credit = credit;
	}
	 /**
     * Constructs a DailyRental with no promo credit (defaults to zero).
     *
     * @param media   the media being rented
     * @param payment the payment method
     * @param today   the rental start date
     * @param fee     the daily rental fee
     */
	public DailyRental(Media media, Payment payment, LocalDate today, double fee) {
		super(media, payment, today, fee);
	}
	
	public DailyRental(Media media, Payment payment, LocalDate today) {
		super(media, payment, today, 0.0);
	}
	
	/**
     * Returns the promo credit applied to this rental.
     *
     * @return the credit value
     */
	public double getCredit() {
		return credit;
	}

    /**
     * Calculates the total fee based on days rented multiplied by the daily rate,
     * minus any promo credit. Minimum charge is one day; minimum total is zero.
     *
     * @param today the current or return date
     * @return the total fee after applying the daily rate and promo credit
     */
	@Override public double getTotalFee(LocalDate today) {
	    int days = daysRented(today) < 1 ? 1 : daysRented(today);
	    double total = days * getFee() - credit;
	    return total < 0 ? 0 : total;
	}
}
