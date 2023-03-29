package api;

import api.steps.user.UserSteps;
import org.testng.annotations.Test;

public class ApiTests {
    UserSteps userSteps = new UserSteps();

    @Test
    public void getUserByNameTest() {
        userSteps.getUserByName();
    }

    @Test public void postUserWithListTest() {
        userSteps.postUserWithList();
    }

    @Test public void postUserWithArrayTest() {
        userSteps.postUserWithArray();
    }
}
