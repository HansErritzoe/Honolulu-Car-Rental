package CarClasses;

import java.io.Serializable;

public class LuxuryCar extends Car implements Serializable {
 protected int ccm;
    public LuxuryCar(String brandAndModel, String fuelType, String registrationNumber, int registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable, int ccm) {
        super(brandAndModel, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, isAvailable);
        this.ccm = ccm;
    }

    public int getCcm() {
        return ccm;
    }

    public void setCcm(int ccm) {
        this.ccm = ccm;
    }
}
