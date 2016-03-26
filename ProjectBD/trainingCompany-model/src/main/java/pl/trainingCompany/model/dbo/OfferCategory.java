package pl.trainingCompany.model.dbo;

import javax.persistence.*;

/**
 * Created by Mateusz on 2016-03-24.
 */

@Entity
public class OfferCategory {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private OfferCategory offerCategoryParent;

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

    public OfferCategory getOfferCategoryParent() {
        return offerCategoryParent;
    }

    public void setOfferCategoryParent(OfferCategory offerCategoryParent) {
        this.offerCategoryParent = offerCategoryParent;
    }
}
