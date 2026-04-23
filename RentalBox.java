import java.time.LocalDate;
/**
 * A fixed-capacity rental box that stores, rents, and accepts returns of media.
 * Supports stocking media, checking availability, processing rentals and dropoffs.
 */
public class RentalBox {
	
	private int capacity;
	private Media[] boxRental;
	
	/**
     * Constructs a RentalBox with the specified capacity.
     *
     * @param capacity the maximum number of media slots
     */
	public RentalBox(int capacity) {
		this.boxRental = new Media[capacity];
	}
	
	/**
     * Constructs a RentalBox with a default capacity of 100.
     */
	public RentalBox() {
		this.boxRental = new Media[100];
	}
	
	/**
     * Returns the total media slot capacity of this rental box.
     *
     * @return the total number of slots
     */
	public int boxCapacity() {
	    return boxRental.length;
	}
	
	/**
     * Returns the media at the specified slot, or null if the slot is empty.
     *
     * @param i the slot index
     * @return the media at index {@code i}, or null
     */
	public Media get(int i) {
		return boxRental[i]; 
	}
	
	/**
     * Checks whether the specified media is currently in stock.
     *
     * @param m the media to search for
     * @return true if found, false otherwise
     */
	public boolean inStock(Media m) {
		for (int i = 0; i < boxRental.length; i++) {
			if (boxRental[i] != null && boxRental[i].equals(m)) {
				return true;
			}
		}
		return false;
	}
	/**
     * Places the specified media into the first available empty slot.
     *
     * @param m the media to stock
     * @return true if successfully stocked, false if no slots are available
     */
	public boolean put(Media m) {
		int slot = getIndexOfEmptySlot();
		if (slot != -1) {
			boxRental[slot] = m;
			return true;
		}
		return false;
	}
	
	/**
     * Finds the index of the first empty slot in the rental box.
     *
     * @return the index of the first empty slot, or -1 if full
     */
	private int getIndexOfEmptySlot() {
	    for (int i = 0; i < boxRental.length; i++) {
	        if (boxRental[i] == null) {
	            return i; // found first empty slot in Media array.
	        }
	    }
	    return -1;
	}
	
	/**
     * Rents out the specified media by removing it from the box and creating a new {@link DailyRental}.
     *
     * @param m the media to rent
     * @param p the customer's payment method
     * @param d the rental start date
     * @return a new DailyRental, or null if the media is not in stock
     */
	public Rental rent(Media m, Payment p, LocalDate d) {
	    for (int i = 0; i < boxRental.length; i++) {
	        if (boxRental[i] != null && boxRental[i].equals(m)) {
	            Media foundMedia = boxRental[i];
	            boxRental[i] = null;
	            return new DailyRental(foundMedia, p, d, getDailyFee(foundMedia)); 
	        }
	    }
	    return null;
	}
	
	/**
     * Prints the payment confirmation in the format: "$AMOUNT paid by PAYMENT".
     *
     * @param p      the payment method
     * @param amount the amount charged
     */
	public void processPayment(Payment p, double amount) {
	    System.out.printf("$%.2f paid by %s%n", amount, p);
	}
	
	
	/**
     * Drops off a rental, restocks the media, and processes payment.
     * Returns false if the box is full or the rental was already returned.
     *
     * @param r     the rental to return
     * @param today the current date
     * @return true if successfully dropped off, false otherwise
     */
	public boolean dropoff(Rental r, LocalDate today) {
		if (hasRemainingSlot() && r.isRented()) {
			put(r.getMedia()); // place the media in first available slot
			processPayment(r.getPayment(), r.dropoff(today)); //dropoff rental and report total cost using processPayment method
			return true; 
		}
		return false;
	}
	
	/**
     * Checks whether the rental box has at least one empty slot.
     *
     * @return true if a slot is available, false if all slots are occupied
     */
	private boolean hasRemainingSlot() {
	    for (int i = 0; i < boxRental.length; i++) {
	        if (boxRental[i] == null) {
	            return true; // found empty boxRental, occupied
	        }
	    }
	    return false; // all slots were occupied
	}
	
	/**
     * Returns the daily rental fee based on media type:
     * DVD = $1.50, Bluray = $2.00, Game = $3.00, other = $0.00.
     *
     * @param m the media to evaluate
     * @return the daily rental fee
     */
	public double getDailyFee(Media m) {
	    if (m instanceof Video) {
	        return ((Video) m).getFormat() == Video.DVD ? 1.50 : 
	               ((Video) m).getFormat() == Video.BLURAY ? 2.00 : 0.00;
	    }
	    return m instanceof Game ? 3.00 : 0.00;
	}
	
	/**
     * Returns a string of all non-empty media in the box, each on a new line.
     *
     * @return a newline-separated list of stocked media
     */
	@Override public String toString() {
	    StringBuilder rentalBoxStr = new StringBuilder();
	    for (Media media : boxRental) {
	        if (media != null) {
	            rentalBoxStr.append(media).append("\n");
	        }
	    }
	    return rentalBoxStr.length() == 0 ? "No media in stock." : rentalBoxStr.toString();
	}
}
