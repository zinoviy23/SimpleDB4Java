public class User {
    private long id;

    public long getId() {
        return id;
    }

    private int age;

    public int getAge() {
        return age;
    }

    private String name;

    public String getName() {
        return name;
    }

    public static User getMaxAgeUser() {
        return User.max((user1, user2) -> Integer.compare(user1.age, user2.age));
    }

    public static int getMinAgeUserId() {
        return User.min((user1, user2) -> Integer.compaer(user1.age, user2.age)).getId();
    }

    public static User min(Comparator<User> comp) {
        return allUsers().min(comp);
    }

    public static User max(Comparator<User> comp) {
        return allUsers().max(comp);
    }

    public static Stream<User> allUsers() {
        return executor.exequteQuery("select * from User", set -> {
            List<User> users = new LinkedList<>();
            while (set.next()) {
                users.add(new User(...));
            }
            return users.stream();
        });
    }
}

class User {
    int age;
    String name;
    Animal[] animals;

    query User getMaxAgeUser() : User.max(User.age);
    query int getMinAgeUserId() : User.min(User.age).id;
}