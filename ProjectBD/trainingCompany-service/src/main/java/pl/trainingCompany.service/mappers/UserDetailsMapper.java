package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dbo.UserDetails;
import pl.trainingCompany.model.dto.DtoUserDetails;
import pl.trainingCompany.repo.AccountRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Palonek on 2016-04-02.
 */
@Component
public class UserDetailsMapper implements MapperInterface<UserDetails, DtoUserDetails> {

    @Autowired
    AccountRepo accountRepo;

    @Override
    public UserDetails convertToDBO(DtoUserDetails dtoUserDetails) {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(dtoUserDetails.getId());
        userDetails.setName(dtoUserDetails.getName());
        userDetails.setSurname(dtoUserDetails.getSurname());
        userDetails.setCity(dtoUserDetails.getCity());
        userDetails.setAddress(dtoUserDetails.getAddress());
        userDetails.setPhone(dtoUserDetails.getPhone());
        if (dtoUserDetails.getAccountId() != null) {
            Account account = accountRepo.findOne(dtoUserDetails.getAccountId());
            if (account != null) {
                userDetails.setAccount(account);
            } else {
                //TODO
            }
        }
        return userDetails;
    }

    @Override
    public DtoUserDetails convertToDTO(UserDetails userDetails) {
        DtoUserDetails dtoUserDetails = new DtoUserDetails();
        dtoUserDetails.setId(userDetails.getId());
        dtoUserDetails.setName(userDetails.getName());
        dtoUserDetails.setSurname(userDetails.getSurname());
        dtoUserDetails.setCity(userDetails.getCity());
        dtoUserDetails.setAddress(userDetails.getAddress());
        dtoUserDetails.setPhone(userDetails.getPhone());
        if (userDetails.getAccount() != null) {
            dtoUserDetails.setAccountId(userDetails.getAccount().getId());
        }
        return dtoUserDetails;
    }

    @Override
    public Iterable<UserDetails> convertToDBO(Iterable<DtoUserDetails> dtoUserDetailses) {
        List<UserDetails> userDetailsList = new ArrayList<>();
        dtoUserDetailses.forEach(d -> userDetailsList.add(convertToDBO(d)));
        return userDetailsList;
    }

    @Override
    public Iterable<DtoUserDetails> convertToDTO(Iterable<UserDetails> userDetailses) {
        List<DtoUserDetails> dtoUserDetailsList = new ArrayList<>();
        userDetailses.forEach(u -> dtoUserDetailsList.add(convertToDTO(u)));
        return dtoUserDetailsList;
    }
}
