import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) throws DuplicateVehicleException {
        // Fill in the duplicate check and throw exception if necessary
        // Answer:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if(vehicles.contains(vehicle)) {
            throw new DuplicateVehicleException("Duplicate vehicle");
        }
        vehicles.add(vehicle);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public Vehicle searchVehicle(String brand, String model) throws VehicleNotFoundException {
        // Fill in the search logic and throw exception if necessary
        // Answer:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        Vehicle searchVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getBrand().equals(brand) && vehicle.getModel().equals(model)) {
                searchVehicle = vehicle;
            }
        }
        if(searchVehicle == null) {
            throw new VehicleNotFoundException("Vehicle not found");
        }
        return searchVehicle;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void removeVehicle(Vehicle vehicle) throws VehicleNotFoundException {
        // Fill in the remove logic and throw exception if necessary
        // Answer:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        Vehicle removeVehicle = searchVehicle(vehicle.getBrand(), vehicle.getModel());
        vehicles.remove(removeVehicle);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void printAllVehicles() {
        // Fill in the print logic
        // Answer:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
