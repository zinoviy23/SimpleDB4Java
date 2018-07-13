import db.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user = User.create("kek");
        User user1 = User.create("lol");

        Forum f1 = Forum.create("f1");
        Forum f2 = Forum.create("f2");
        Forum f3 = Forum.create("f3");

        user.addForums(f1);
        user.addForums(f2);
        user.addForums(f3);
        user1.addForums(f1);
        user1.addForums(f2);
        user1.addForums(f3);

        Message.create(user, f1, "aa", 2);
        Message.create(user1, f2, "bb", 10);
        Message.create(user, f3, "cc", 6);
        Message.create(user, f2, "dd", 3);
        Message.create(user1, f3, "ee", 100);
        Message.create(user, f1, "ff", 8);
        Message.create(user, f3, "gg", 13);
        Message.create(user1, f2, "hh", 1);

        System.out.println(User.getAllUserMessagesToString(user, 5));
        System.out.println(User.getAllUserMessagesToString(user, 0));
        System.out.println(User.getAllUserMessagesToString(user1, 6));
        System.out.println(User.getAllUserMessagesToString(user1, 0));
        System.out.println(User.firstUserByAlphabet());
        System.out.println(User.getKek().getNickName());

        DBService.getInstance().close();
    }
}