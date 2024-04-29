package CarClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class LuxuryCar extends Car implements Serializable {
 protected int ccm;

    public LuxuryCar(String brand, String model, String fuelType, String registrationNumber, LocalDate registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable, int ccm) {
        super(brand, model, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, isAvailable);
        this.ccm = ccm;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    public int getCcm() {
        return ccm;
    }

    public void setCcm(int ccm) {
        this.ccm = ccm;
    }
}
