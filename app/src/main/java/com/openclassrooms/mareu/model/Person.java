package com.openclassrooms.mareu.model;

/**
 * Model object that represents a Person
 * We've chosen to use a Person object instead of a String, because it's more flexible and
 * easier to maintain in the long run (for example, if we want to add a picture to a person)
 */
public class Person implements Comparable<Person> { // we may also call it User

    /**
     * Email of the person
     */
    private String mEmail;

    /**
     * Constructor with email
     *
     * @param email Email of the person
     */
    public Person(String email) {
        setEmail(email);
    }

    /**
     * Getter for email
     *
     * @return Email of the person
     */
    public String getEmail() {
        return mEmail;
    }

    /**
     * Setter for email
     *
     * @param email Email of the person
     */
    public void setEmail(String email) {
        this.mEmail = email;
    }

    /**
     * Compare two persons by email
     * @param o Person to compare
     * @return 0 if equals, -1 if this is before o, 1 if this is after o
     */
    @Override
    public int compareTo(Person o) {
        return mEmail.compareTo(o.getEmail());
    }

    /**
     * Compare two persons by email
     * @param o Object to compare
     * @return true if equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (this == o) return true;
        // if o is null or not an instance of Person then return false
        if (o == null || getClass() != o.getClass()) return false;

        // typecast o to Place so that we can compare their members
        Person that = (Person) o;

        // Compare their members and return accordingly
        return mEmail.equals(that.mEmail);
    }

    /**
     * Hashcode of a person, based on email
     * @return Hashcode of a person
     */
    @Override
    public int hashCode() {
        return mEmail.hashCode();
    }
}
