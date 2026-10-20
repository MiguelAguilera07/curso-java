package relaciones;

public class House {

    private Romm romm; //Composicion
    private Door door; // Composicion
    private  Owner owner; // Asociacion

    public House(Romm romm, Door door, Owner owner) {
        this.romm = romm;
        this.door = door;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "House{" +
                "romm=" + romm +
                ", door=" + door +
                ", owner=" + owner +
                '}';
    }
}
