package com.openclassrooms.mareu.model;

/**
 * Model object that represent a place for the meeting
 * We've chosen to use a Place object instead of a String, because it's more flexible
 * and easier to maintain in the long run (for example, if we want to add a picture to a place)
 */
public class Place { // we may also call it Room or Venue

    /**
     * Name of the place
     */
    private String mName;

    /**
     * Constructor with name
     *
     * @param name Name of the place
     */
    public Place(String name) {
        this.mName = name;
    }

    /**
     * Getter for name
     * @return Name of the place
     */
    public String getName() {
        return mName;
    }

    /**
     * Setter for name
     * @param name Name of the place
     */
    public void setName(String name) {
        this.mName = name;
    }

    /**
     * Compare two places by name
     * @param o Place to compare
     * @return 0 if equals, -1 if this is before o, 1 if this is after o
     */
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (this == o) return true;
        // if o is null or not an instance of Place then return false
        if (o == null || getClass() != o.getClass()) return false;

        // typecast o to Place so that we can compare their members
        Place place = (Place) o;

        // Compare their members and return accordingly
        return mName.equals(place.mName);
    }

    /**
     * Compute the hash code
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return mName.hashCode();
    }
}
