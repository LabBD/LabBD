package pl.trainingCompany.model.dto;

/**
 * Created by Mateusz on 2016-03-24.
 */
public class DtoOfferCategory {
    private long id;

    private String name;
    private String description;
    private Long parentCategoryId;              // przy tym daliśmy pytajnik więc pole do przemyślenia :)

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

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}
