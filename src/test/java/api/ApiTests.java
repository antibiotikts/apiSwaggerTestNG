package api;

import api.generators.PetGenerator;
import api.methods.Post;
import api.pojo.pet.Pet;
import api.steps.pet.PetSteps;
import api.steps.user.UserSteps;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiTests {
    private final String URL = "https://petstore.swagger.io/v2/";
    UserSteps userSteps = new UserSteps();
    PetSteps petSteps = new PetSteps();

    @BeforeTest
    public void setUrlAndContentType() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }

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

        Assert.assertEquals(pet.getName(), expectedPet.getName());
    }

}
