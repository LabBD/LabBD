package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Company;

/**
 * Created by Mateusz on 2016-03-26.
 */
public interface CompanyRepo extends CrudRepository<Company, Long>{
}
