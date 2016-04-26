package domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {

    private  StringProperty firstName;
    private  StringProperty lastName;
    private  StringProperty street;
    private  IntegerProperty postalCode;
    private  StringProperty city;
    private  ObjectProperty<LocalDate> birthday;
	private UUID personID;
    
    public String toString() {
    	return "Person " + this.personID + "\n" + 
    			this.firstName + " " + this.lastName + "\n" +
    			this.street + "\n" +
    			this.city + " " + this.postalCode + "\n" +
    			this.birthday;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate date) {
        this.birthday.set(date);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
    
    public UUID getPersonID() {
		return this.getPersonID();
	}
    
    public void setPersonID(UUID id) {
		this.personID = id;
	}
}