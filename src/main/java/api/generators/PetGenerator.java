package api.generators;

import api.pojo.pet.Category;
import api.pojo.pet.Pet;
import api.pojo.pet.Tag;

import java.util.ArrayList;
import java.util.Collections;

public class PetGenerator {

    public static Pet createPet() {
        Category category = new Category(0, "dog");
        ArrayList<Tag> teg = new ArrayList<Tag>(Collections.singletonList(new Tag(0, "str")));
        ArrayList<String> photoUrls = new ArrayList<String>(Collections.singletonList("qwq"));
        return new Pet(0, category, "doggie", photoUrls, teg, "available" );
    }
}
