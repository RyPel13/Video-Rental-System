/**
 * Represents a game media item with platform, rating, disc count, and online support.
 * Extends {@link Media}.
 */
public class Game extends Media {
	
	private String platform;
	private String rating;
	private int discs;
	private boolean online;
	
	/**
     * Constructs a Game with the given name, year, platform, rating, disc count, and online status.
     *
     * @param name     the title of the game
     * @param year     the publication year
     * @param platform the gaming platform (e.g., "PS5")
     * @param rating   the content rating (e.g., "T")
     * @param discs    the number of discs
     * @param online   true if the game supports online play
     */
	public Game(String name, int year, String platform, String rating, int discs, boolean online) {
		super(name, year);
		this.platform = platform;
		this.rating = rating;
		this.discs = discs;
		this.online = online; 
	}
	
	/**
     * Returns the gaming platform.
     *
     * @return the platform
     */
	public String getPlatform() {
		return platform;
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
     * Returns the number of discs.
     *
     * @return the disc count
     */
	public int getDiscs() {
		return discs;
	}
	
	/**
     * Returns whether the game supports online play.
     *
     * @return true if online, false otherwise
     */
	public boolean isOnline() {
	    return online;
	}
	
	/**
     * Returns the game as a string in the format "NAME (YEAR) PLATFORM [RATING, DISCS discs]",
     * with ", online" appended if the game supports online play.
     *
     * @return a formatted string representation
     */
	@Override public String toString() {
	    return getName() + " (" + getYear() + ") " + getPlatform() + " [" + getRating() + ", " + getDiscs() + " discs" + (online ? ", online" : "") + "]";
	}
}
