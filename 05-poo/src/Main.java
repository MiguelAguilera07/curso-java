public class Main {

    public static void main(String[] args) {
        /*Vehicle vehicle = new Vehicle("Toyota","Hilux",2025);


        Vehicle moto = new Vehicle("KTM","DUKE",2025);
 System.out.println(vehicle.toString());
        System.out.println(moto.toString());
    */

        Vehicle  car = new Car("toyota","Corola",2022 ,3);
        Vehicle  motorcycle = new Motorcycle("ktm","duke",2025,false);

         car.start();
         motorcycle.start();

         System.out.println(car);
         System.out.println(motorcycle);

         printVehicle(car);
        printVehicle(motorcycle);
        ((Car)car).setDoors(3);
        }
        public static void printVehicle(Vehicle car){
        System.out.println(car.toString());

    }
} 