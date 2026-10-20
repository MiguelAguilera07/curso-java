package Strings;

public class ExaampleString {
    public static void main(String[] args) {

        // NO cambia Nunca
        String name = "Miguel";
        String name2 = "Miguel";

        System.out.println(name==name2);

        String name3 = new String("Miguel");

        System.out.println(name3==name);

        System.out.println(name.toUpperCase());

        System.out.println(name);

        Person person = new Person("Grabiel", "Chaldu");
        System.out.println(person.toString());




    }
}
