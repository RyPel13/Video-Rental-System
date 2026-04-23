/**
 * Represents a video media item with runtime, rating, and disc format.
 * Extends {@link Media} and supports DVD and Bluray formats.
 */
public class Video extends Media{

	public static final int DVD = 0;
	public static final int BLURAY = 1;
	private int runtime;
	private String rating;
	private int format;
	
	/**
     * Constructs a Video with the given name, year, runtime, rating, and format.
     *
     * @param name    the title of the video
     * @param year    the publication year
     * @param runtime the runtime in minutes
     * @param rating  the content rating (e.g., "PG-13")
     * @param format  the disc format ({@code DVD} or {@code BLURAY})
     */
	public Video(String name, int year, int runtime, String rating, int format) {
		super(name, year);
		this.runtime = runtime;
		this.rating = rating;
		this.format = format;
	}
	
	/**
     * Returns the runtime in minutes.
     *
     * @return the runtime
     */
	public int getRuntime() {
		return runtime;
	}
	
	/**
     * Returns the content rating.
     *
     * @return the rating
     */
	public String getRating() {
		return rating;
	}
	
	/**
     * Returns the disc format (DVD or BLURAY).
     *
     * @return the format
     */
	public int getFormat() {
		return format;
	}
	
	/**
     * Returns the video as a string in the format "NAME (YEAR) FORMAT [RATING, RUNTIME min]".
     *
     * @return a formatted string representation
     */
	@Override public String toString() {
	    String formatName = (format == DVD) ? "DVD" : "BLURAY";
	    return getName() + " (" + getYear() + ") " + formatName + " [" + getRating() + ", " + getRuntime() + " min]";
	}
}
