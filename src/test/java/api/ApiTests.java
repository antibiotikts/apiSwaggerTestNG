package api;

import api.steps.pet.PetSteps;
import api.steps.user.UserSteps;
import org.testng.annotations.Test;

public class ApiTests {
    UserSteps userSteps = new UserSteps();
    PetSteps petSteps = new PetSteps();

    @Test public void getUserByNameTest() {
        userSteps.getUserByName();
    }

    @Test public void postUserWithListTest() {
        userSteps.postUserWithList();
    }

    @Test public void postUserWithArrayTest() {
        userSteps.postUserWithArray();
    }

    @Test public void postPetTest() {
        petSteps.postPet();
    }

    @Test public void putPetTest() {
        petSteps.putPet();
    }
}
