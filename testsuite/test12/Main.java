import db.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user = User.create("Polina");

        user.addPets(Pet.create("Cat", 1, user));
        user.addPets(Pet.create("Dog", 2, user));
        user.addPets(Pet.create("Humster", 2, user));
        user.addPets(Pet.create("Guinea pig", 3, user));
        user.addPets(Pet.create("Sasha", 18, user));

        System.out.println(Pet.getAdultPetOfUser(user).getName());


        DBService.getInstance().close();
    }
}