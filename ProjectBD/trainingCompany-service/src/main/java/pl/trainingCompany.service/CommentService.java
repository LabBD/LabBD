package pl.trainingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dbo.Comment;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoComment;
import pl.trainingCompany.repo.AccountRepo;
import pl.trainingCompany.repo.CommentRepo;
import pl.trainingCompany.repo.OfferRepo;
import pl.trainingCompany.service.mappers.CommentMapper;

import java.util.Date;

/**
 * Created by Pawel on 20-May-16.
 */
@Service
public class CommentService extends AbstractService<Comment, DtoComment, CommentRepo, CommentMapper> {

    @Autowired
    OfferRepo offerRepo;

    @Autowired
    AccountRepo accountRepo;

    public Iterable<DtoComment> getCommentsByOfferId(Long offerId) {
        Offer offer = offerRepo.findOne(offerId);
        if(offer==null)
            return null;
        return mapper.convertToDTO(repo.findByOffer(offer));
    }
}
