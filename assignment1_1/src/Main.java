//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();

        try {
            // 차량 추가
            Vehicle car1 = new Car("Toyota", "Camry", 2020, 5);
            Vehicle car2 = new Car("Honda", "Accord", 2021, 5);
            Vehicle motorcycle1 = new Motorcycle("Harley-Davidson", "Street 750", 2019, false);


            System.out.println(car1);

            manager.addVehicle(car1);
            manager.addVehicle(car2);
            manager.addVehicle(motorcycle1);



        } catch (InvalidVehicleDetailException e) {
            System.out.println("Error creating vehicle: " + e.getMessage());
        } catch (DuplicateVehicleException e) {
            System.out.println("Error adding vehicle: " + e.getMessage());
        }
    }
}

