import db.*;

public class Main {
    public static void main(String[] args) {
        User.create(18, "A");
        User.create(13, "B");
        User.create(15, "C");
        User.create(19, "D");
        User.create(5, "E");
        User.create(100, "F");
        User.create(21, "G");

        User.adults().forEach(user -> System.out.println(user.getName()));

        DBService.getInstance().close();
    }
}