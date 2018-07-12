import db.*;

public class Main {
    public static void main(String[] args) {
        User user = User.create(18, "Sasha", 1.8f);
        System.out.println(User.ageHeightDiff(user));

        DBService.getInstance().close();
    }
}