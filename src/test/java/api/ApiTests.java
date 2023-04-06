package api;

import api.generators.PetGenerator;
import api.methods.Post;
import api.pojo.pet.Pet;
import org.testng.annotations.Test;

public class ApiTests extends BaseTest {

	@Test
	public void getUserByNameTest() {
		userSteps.getUserByNameAndAssert();
	}

	@Test
	public void postUserWithListTest() {
		userSteps.postUserWithListAndAssert();
	}

	@Test
	public void postUserWithArrayTest() {
		userSteps.postUserWithArrayAndAssert();
	}

	@Test
	public void postPetTest() {
		petSteps.postPetAndAssert();
	}

	@Test
	public void putPetTest() {
		petSteps.putPetAndAssert();
	}

	@Test
	public void getPetByIdTest() {
		petSteps.getPetByIdAndAssert();
	}

	@Test
	public void postPetTest2() {
		Pet pet = PetGenerator.createPet();
		Post post = new Post(pet, new Pet());
		post.checkResponseCode(200).postRequest("pet");
		Pet expectedPet = (Pet) post.getResponse();

		pet.assertResponse(expectedPet, false, true, true, true);
	}
}