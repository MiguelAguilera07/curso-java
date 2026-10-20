package HouseExample;

public class HouseMain {
    public static void main(String[] args){

        House myHouse = new House(34,5,5);
        myHouse.setSize(4);
        myHouse.setWindows(5);
        myHouse.setDoors(3);


        House myHouse2 = new House(5,7,8);

      System.out.println(" La cantidad de puertas de la casa es + "+myHouse2.getDoors());
      myHouse2.openDoor();

      double area = myHouse2.calculateArea();
      System.out.println("El area de la casa es "+area);



    }

}
