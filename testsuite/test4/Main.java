import db.*;

public class Main {
    public static void main(String[] args) {
        User user = User.create(18, "Sasha");
        for (int i = 0; i < 10; i++)
            user.addArr(i);

        user.removeArr(4);

        user.getArr().forEach(System.out::println);

        DBService.getInstance().close();
    }
}