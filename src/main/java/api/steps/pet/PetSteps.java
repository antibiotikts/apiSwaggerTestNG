package api.steps.pet;

import api.methods.ApiMethods;
import api.pojo.pet.Category;
import api.pojo.pet.Pet;
import api.pojo.pet.Tag;
import api.steps.BaseStep;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;

public class PetSteps extends BaseStep {
    ApiMethods methods = new ApiMethods(URL);

    public void postPet() {
        Category category = new Category(0, "dog");
        ArrayList<Tag> teg = new ArrayList<Tag>(Collections.singletonList(new Tag(0, "str")));
        ArrayList<String> photoUrls = new ArrayList<String>(Collections.singletonList("qwq"));
        Pet pet = new Pet(0, category, "doggie", photoUrls, teg, "available" );

        Pet expectedPet = methods.postRequest(pet, "pet", 200).then().extract().as(Pet.class);

        Assert.assertEquals(pet.getCategory().getId(), expectedPet.getCategory().getId());
        Assert.assertEquals(pet.getCategory().getName(), expectedPet.getCategory().getName());
        Assert.assertEquals(pet.getName(), expectedPet.getName());
        Assert.assertEquals(pet.getStatus(), expectedPet.getStatus());
        Assert.assertEquals(pet.getPhotoUrls(), expectedPet.getPhotoUrls());
        Assert.assertEquals(pet.getTags().get(0).getName(), expectedPet.getTags().get(0).getName());
        Assert.assertEquals(pet.getTags().get(0).getId(), expectedPet.getTags().get(0).getId());
    }

    public void putPet() {
        Category category = new Category(0, "dog");
        ArrayList<Tag> teg = new ArrayList<Tag>(Collections.singletonList(new Tag(0, "str")));
        ArrayList<String> photoUrls = new ArrayList<String>(Collections.singletonList("qwq"));
        Pet pet = new Pet(0, category, "doggie", photoUrls, teg, "available" );

        Pet expectedPet = methods.putRequest(pet, "pet", 200).then().extract().as(Pet.class);

        Assert.assertEquals(pet.getCategory().getId(), expectedPet.getCategory().getId());
        Assert.assertEquals(pet.getCategory().getName(), expectedPet.getCategory().getName());
        Assert.assertEquals(pet.getName(), expectedPet.getName());
        Assert.assertEquals(pet.getStatus(), expectedPet.getStatus());
        Assert.assertEquals(pet.getPhotoUrls(), expectedPet.getPhotoUrls());
        Assert.assertEquals(pet.getTags().get(0).getName(), expectedPet.getTags().get(0).getName());
        Assert.assertEquals(pet.getTags().get(0).getId(), expectedPet.getTags().get(0).getId());
    }
}
