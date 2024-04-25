package CustomerClasses;

import java.io.Serializable;

public class CompanyCustomer extends Customer implements Serializable {

    protected String companyName;
    protected String companyAddress;
    protected int companyPhone;
    protected int crn;

    public CompanyCustomer(String driverName, String address, int postalCode, String city, int phoneNumber, String email, String companyName, String companyAddress, int companyPhone, int crn) {
        super(driverName, address, postalCode, city, phoneNumber, email);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhone = companyPhone;
        this.crn = crn;
    }

    ////////////////////////////////////////////////////////////////////////
    //                      Getters and Setters below                     //
    ////////////////////////////////////////////////////////////////////////

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public int getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(int companyPhone) {
        this.companyPhone = companyPhone;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }
}
