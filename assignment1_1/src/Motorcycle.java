public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, boolean hasSidecar) throws InvalidVehicleDetailException {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        // Fill in return statement
        // Answer:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        return super.toString()+", HasSideCar: "+hasSidecar;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////


    }
}
