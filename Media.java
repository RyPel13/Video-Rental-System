/**
 * Represents a media item with a name and publication year.
 * Serves as the parent class for all media types.
 */

public class Media {
	
	private String name; // instance variables
	private int year;
	
	/**
     * Constructs a Media item with the given name and year.
     *
     * @param name the title of the media
     * @param year the publication year
     */
	public Media(String name, int year) {
		this.name = name;
		this.year = year;
	}
	
	/**
     * Returns the name of the media.
     *
     * @return the media title
     */
	public String getName() {
		return name;
	}
	
	/**
     * Returns the publication year of the media.
     *
     * @return the media year
     */
	public int getYear() {
		return year;
	}
	
	/**
     * Checks equality based on name and year.
     *
     * @param other the object to compare
     * @return true if both name and year match, false otherwise
     */
	@Override public boolean equals(Object other) {
	    if (other instanceof Media) {
	        Media otherMedia = (Media) other; //other should be verified as a Media instance before casting
	        return getName().equals(otherMedia.getName()) && getYear() == otherMedia.getYear(); 
	    }
	    return false; 
	}
	/**
     * Returns a hash code based on name and year.
     *
     * @return the computed hash code
     */
	@Override public int hashCode() {
	    return getName().hashCode();
	}
	
	/**
     * Returns the media as a string in the format "NAME (YEAR)".
     *
     * @return a formatted string representation
     */
	@Override public String toString() {
	    return name + " (" + year + ")"; 
	}
}
