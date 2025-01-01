public class Car extends Vehicle {
    private int seats;

    public Car(String brand, String model, int year, int seats) throws InvalidVehicleDetailException {
        super(brand, model, year);
        // Fill in this line
        // Answer
        //////////////////////////////////////////////////////////////////////////////////////////////
        if (seats < 0){
            throw new InvalidVehicleDetailException("Seats must be greater than zero");
        }
        this.seats = seats;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) throws InvalidVehicleDetailException {
        // Fill in the if statement and throw exception if necessary
        // Answer:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if (seats < 0){
            throw new InvalidVehicleDetailException("Seats must be greater than zero");
        }
        this.seats = seats;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public String toString() {
        // Fill in return statement
        // Answer

        //////////////////////////////////////////////////////////////////////////////////////////////
        return super.toString()+", Seats: "+seats;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}
