import db.*;

public class Main {
    public static void main(String[] args) {
        User.create(18, "A", 1.7f);
        User.create(13, "B", 1.4f);
        User.create(15, "C", 1.5f);
        User.create(19, "D", 1.3f);
        User.create(5, "E", 1.8f);
        User.create(100, "F", 1.1f);

        System.out.println(User.highestUser().getName());

        DBService.getInstance().close();
    }
}