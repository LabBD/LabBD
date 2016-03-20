package pl.trainingCompany.model.dto;


import java.util.List;

/**
 * Created by Kamil S on 2016-03-20.
 */
public class DtoOffer {

    private long id;

    private String name;

    private String description;

    private List<String> photosNames;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPhotosNames() {
        return photosNames;
    }

    public void setPhotosNames(List<String> photosNames) {
        this.photosNames = photosNames;
    }
}
