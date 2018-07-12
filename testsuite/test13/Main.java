import db.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 110; i++)
            NNumber.create("tmp");

        NNumber.getNumbers().forEach(n -> System.out.println(n.getId()));


        DBService.getInstance().close();
    }
}