package api.pojo.pet;

import java.util.ArrayList;

public class Pet {
    private final long id;
    private final Category category;
    private final String name;
    private final ArrayList<String> photoUrls;
    private final ArrayList<Tag> tags;
    private final String status;

    public Pet(long id, Category category, String name, ArrayList<String> photoUrls, ArrayList<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
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
}
