public class Vehicle {
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year) throws InvalidVehicleDetailException {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if (year < 1886){
            throw new InvalidVehicleDetailException("Year must be 1886 or later.");
        }
        this.brand = brand; this.model = model; this.year = year;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidVehicleDetailException {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if (year < 1886){
            throw new InvalidVehicleDetailException("Year must be 1886 or later.");
        }
        this.year = year;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public String toString() {
        ///////////////////////////////////////////////////////////////////////////////////////////////
        return "[Vehicle] Brand: "+brand+", Model: "+model+", year: "+year;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}
