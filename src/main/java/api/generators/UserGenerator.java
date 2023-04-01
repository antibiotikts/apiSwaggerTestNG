package api.generators;

import api.pojo.user.User;

public class UserGenerator {

    public static User crateUser() {
        return new User(0, "bobi", "bob", "tesla", "bob@g.com", "ff", "333", 0);
    }
}
