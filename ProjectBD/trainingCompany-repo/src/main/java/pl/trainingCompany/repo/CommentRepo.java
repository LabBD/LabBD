package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Comment;
import pl.trainingCompany.model.dbo.Offer;

/**
 * Created by Pawel on 20-May-16.
 */
public interface CommentRepo extends CrudRepository<Comment,Long > {
    Iterable<Comment> findByOffer(Offer offer);

}
