import db.*;

public class Main {
    public static void main(String[] args) {
        User user = User.create(18, "Sasha");
        Pet pet = Pet.create("Cat");
        user.addPets(pet);

        System.out.println(User.firstPetName(user));

        DBService.getInstance().close();
    }
}