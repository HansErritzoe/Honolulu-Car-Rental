package CustomerClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class PrivateCustomer extends Customer implements Serializable {

    protected int licenseNumber;
    protected LocalDate releaseDate;

    public PrivateCustomer(String driverName, String address, int postalCode, String city, int phoneNumber, String email, int licenseNumber, LocalDate releaseDate) {
        super(driverName, address, postalCode, city, phoneNumber, email);
        this.licenseNumber = licenseNumber;
        this.releaseDate = releaseDate;
    }
    @Override
    public String toString(){
        return super.toString() + "\n" +
                "Driver License Number: " + licenseNumber + "\n" +
                "Driver License Release Date: " + releaseDate
                ;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


}
