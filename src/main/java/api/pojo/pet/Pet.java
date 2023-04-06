package api.pojo.pet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;

public class Pet {

	private final static Logger logger = LogManager.getLogger(Pet.class);

	private long id;
	private Category category;
	private String name;
	private ArrayList<String> photoUrls;
	private ArrayList<Tag> tags;
	private String status;

	public Pet() {

	}

	public Pet(long id, Category category, String name, ArrayList<String> photoUrls, ArrayList<Tag> tags, String status) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;

		logger.info("Create new pet");
	}

	public long getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getPhotoUrls() {
		return photoUrls;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public String getStatus() {
		return status;
	}

	public void assertResponse(Pet expectedPet,
							   boolean checkPetId,
							   boolean checkCategoryId,
							   boolean checkCategoryName,
							   boolean checkPhotoUrlList) {
		if (checkPetId) {
			Assert.assertEquals(this.id, expectedPet.getId());
		}

		if (checkCategoryId) {
			Assert.assertEquals(this.category.getId(), expectedPet.getCategory().getId());
		}

		if (checkCategoryName) {
			Assert.assertEquals(this.category.getName(), expectedPet.getCategory().getName());
		}

		if (checkPhotoUrlList) {
			for (int i = 0; i < this.photoUrls.size(); i++) {
				Assert.assertEquals(this.photoUrls.get(i), expectedPet.getPhotoUrls().get(i));
			}
		}
	}
}
