package api;

import api.generators.PetGenerator;
import api.methods.Post;
import api.pojo.pet.Pet;
import api.steps.pet.PetSteps;
import api.steps.user.UserSteps;
import org.testng.annotations.Test;

public class ApiTests  extends BaseTest {

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

    @Test public void getPetByIdTest() {
        petSteps.getPetById();
    }

    @Test
    public void postPetTest2() {
        Pet pet = PetGenerator.createPet();
        Post post = new Post(pet, new Pet());
        post.checkResponseCode(200).postRequest("pet");
        Pet expectedPet = (Pet) post.getResponse();

        pet.assertResponse(expectedPet,false, true, true, true);
    }
}