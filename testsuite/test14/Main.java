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

        Message.create(user, f1, "aa");
        Message.create(user1, f2, "bb");
        Message.create(user, f3, "cc");
        Message.create(user, f2, "dd");
        Message.create(user1, f3, "ee");
        Message.create(user, f1, "ff");
        Message.create(user, f3, "gg");
        Message.create(user1, f2, "hh");

        System.out.println(User.getAllUserMessagesToString(user));
        System.out.println(User.getAllUserMessagesToString(user1));

        DBService.getInstance().close();
    }
}