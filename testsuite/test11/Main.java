import db.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user = User.create("Polina");

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            float tmp = rand.nextInt(100) + (float) rand.nextDouble();
            if (rand.nextInt(2) == 0)
                tmp *= -1;
            System.out.println(tmp);
            Purchase p = Purchase.create(tmp, user);
            user.addPurchases(p);
        }

        System.out.println(User.totalBalance(user) + " " + User.totalPos(user) + " " + User.totalNeg(user) + " " + User.totalBalance1(user));


        DBService.getInstance().close();
    }
}