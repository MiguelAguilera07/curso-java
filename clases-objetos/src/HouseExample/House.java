package HouseExample;

public class House {
    private int doors;
     private int windows;
     private double size;


    public House(double size, int windows, int doors) {
        this.size = size;
        this.windows = windows;
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    void openDoor(){
        System.out.println("La puerta es abierta");
    }

    double calculateArea(){
        return  size * size;
    }
}
