package vttp.batchb.ssf.day18_person.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Person {
    
    @NotNull(message= "Name cannot be empty")
    @NotEmpty(message="Name cannot be empty")
    private String fullName;

    @Email(message="Must be a valid email")
    private String email;

    @NotNull(message= "Postal code cannot be empty")
    @NotEmpty(message="Postal code cannot be empty")
    private String postalCode;
    
    @NotNull(message= "Phone number cannot be empty")
    @NotEmpty(message="Phone number cannot be empty")
    private String phoneNumber;

    @Override
    public String toString() {
        return fullName + ","
                + email + "," 
                + postalCode + "," 
                + phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static Person StringToPerson(String contactString) {

        Person person = new Person();

        String[] contactDetails = contactString.split(",");

        person.setFullName(contactDetails[0]);
        person.setEmail(contactDetails[1]);
        person.setPostalCode(contactDetails[2]);
        person.setPhoneNumber(contactDetails[3]);

        return person;
    }
}
