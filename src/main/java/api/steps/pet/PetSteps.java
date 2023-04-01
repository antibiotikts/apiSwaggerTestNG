package api.steps.pet;

import api.generators.PetGenerator;
import api.pojo.ApiResponse;
import api.pojo.pet.Pet;
import api.steps.BaseStep;
import org.testng.Assert;

public class PetSteps extends BaseStep {

    public void getPetById() {
        ApiResponse expectedApiResponse = new ApiResponse(1, "error", "Pet not found");
        ApiResponse apiResponse = methods.getRequest("pet/{petId}", "0", 404).then().extract().as(ApiResponse.class);

        Assert.assertEquals(apiResponse.getCode(), expectedApiResponse.getCode());
        Assert.assertEquals(apiResponse.getType(), expectedApiResponse.getType());
        Assert.assertEquals(apiResponse.getMessage(), expectedApiResponse.getMessage());
    }

    public void postPet() {
        Pet pet = PetGenerator.createPet();
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
        Pet pet = PetGenerator.createPet();
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
