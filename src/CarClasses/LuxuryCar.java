package CarClasses;

public class LuxuryCar extends Car{
 protected int ccm;
    public LuxuryCar(String brandAndModel, String fuelType, int registrationNumber, int registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable, int ccm) {
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
