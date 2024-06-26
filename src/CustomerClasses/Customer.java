package CustomerClasses;

import java.io.Serializable;

public class Customer implements Serializable,Comparable<Customer> {

    protected String driverName;
    protected String address;
    protected int postalCode;
    protected String city;
    protected int phoneNumber;
    protected String email;

    public Customer(String driverName, String address, int postalCode, String city, int phoneNumber, String email) {
        this.setDriverName(driverName);
        this.setAddress(address);
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
    }

    //compareTo method to sort Customers by name
    public int compareTo(Customer other){
        return this.driverName.compareTo(other.driverName);
    }

    @Override
    public String toString() {
        String customerType;
        if(this instanceof PrivateCustomer){
            customerType = "Private";
        } else {
            customerType = "Company";
        }
        return  "Customer Name: " +driverName + "\n" +
                "Customer Type: " + customerType + "\n" +
                "Address: " + address + ", " + postalCode + " " + city + "\n" +
                "Mobile Phone: " + phoneNumber + "\n" +
                "Email: " + email
                ;

    }

    ////////////////////////////////////////////////////////////////////////
    //                      Getters and Setters below                     //
    ////////////////////////////////////////////////////////////////////////

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
