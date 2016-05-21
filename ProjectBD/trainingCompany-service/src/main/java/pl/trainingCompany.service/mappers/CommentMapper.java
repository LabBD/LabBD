package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Comment;
import pl.trainingCompany.model.dto.DtoComment;
import pl.trainingCompany.repo.AccountRepo;
import pl.trainingCompany.repo.OfferRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 20-May-16.
 */
@Component
public class CommentMapper implements MapperInterface<Comment, DtoComment> {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    OfferRepo offerRepo;

    @Override
    public Comment convertToDBO(DtoComment dtoComment) {
        Comment comment = new Comment();
        comment.setId(dtoComment.getId());
        comment.setAuthor(accountRepo.findByUsername(dtoComment.getAuthorName()));
        comment.setOffer(offerRepo.getOfferByName(dtoComment.getOfferName()));
        comment.setText(dtoComment.getText());
        comment.setDate(dtoComment.getDate());
        comment.setRate(dtoComment.getRate());
        return comment;
    }

    @Override
    public DtoComment convertToDTO(Comment comment) {
        DtoComment dtoComment = new DtoComment();
        dtoComment.setId(comment.getId());
        dtoComment.setAuthorName(comment.getAuthor().getUsername());
        dtoComment.setOfferName(comment.getOffer().getName());
        dtoComment.setText(comment.getText());
        dtoComment.setDate(comment.getDate());
        dtoComment.setRate(comment.getRate());
        return dtoComment;
    }

    @Override
    public Iterable<Comment> convertToDBO(Iterable<DtoComment> dto) {
        List<Comment> comments = new ArrayList<Comment>();
        for (DtoComment dtoComment : dto) {
            comments.add(convertToDBO(dtoComment));
        }
        return comments;
    }

    @Override
    public Iterable<DtoComment> convertToDTO(Iterable<Comment> dbo) {
        List<DtoComment> dtoComments = new ArrayList<DtoComment>();
        for (Comment comment : dbo) {
            dtoComments.add(convertToDTO(comment));
        }
        return dtoComments;
    }
}
