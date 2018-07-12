import db.*;

public class Main {
    public static void main(String[] args) {
        User user = User.create(18, "Sasha");
        System.out.println(user.getAge());
        System.out.println(user.getId());
        System.out.println(user.getName());
        user.setAge(20);
        System.out.println(user.getAge());

        DBService.getInstance().close();
    }
}