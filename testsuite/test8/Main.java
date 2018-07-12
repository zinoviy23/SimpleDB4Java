import db.*;

public class Main {
    public static void main(String[] args) {
        User.badNames().forEach(System.out::println);

        DBService.getInstance().close();
    }
}