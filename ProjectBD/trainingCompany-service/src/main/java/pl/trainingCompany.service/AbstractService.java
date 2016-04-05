package pl.trainingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.service.mappers.MapperInterface;

/**
 * Created by Kamil S on 2016-03-16.
 */
//<Klasa DBO, Klasa DTO, Repository>
abstract public class AbstractService<DBO, DTO, R extends CrudRepository<DBO, Long>, M extends MapperInterface<DBO, DTO>> {

    @Autowired
    R repo;

    @Autowired
    M mapper;

    public DTO findOne(Long id) {
        DBO dbo = repo.findOne(id);
        if (dbo != null)
            return mapper.convertToDTO(dbo);
        return null;
    }

    public Iterable<DTO> findAll() {
        return mapper.convertToDTO(repo.findAll());
    }

    public void save(DTO modelToSave) {
        repo.save(mapper.convertToDBO(modelToSave));
    }

    public void save(Iterable<DTO> modelsToSave) {
        repo.save(mapper.convertToDBO(modelsToSave));
    }

    public void delete(DTO modelToDelete) {
        repo.delete(mapper.convertToDBO(modelToDelete));
    }

    public void delete(Iterable<DTO> modelsToDelete) {
        repo.delete(mapper.convertToDBO(modelsToDelete));
    }
}
