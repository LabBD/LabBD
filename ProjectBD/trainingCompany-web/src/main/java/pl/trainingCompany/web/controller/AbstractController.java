package pl.trainingCompany.web.controller;

import pl.trainingCompany.service.mappers.MapperInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.trainingCompany.service.AbstractService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kamil S on 2016-03-16.
 */
//@RequestMapping("/abstract")
//<Klasa DBO, Klasa DTO, Service>
abstract public class AbstractController<DBO, DTO, S extends AbstractService<DBO, DTO, ? extends CrudRepository<DBO, Long>, ? extends MapperInterface<DBO, DTO>>> {

    @Autowired
    S service;

    @RequestMapping("/{id}")
    public DTO findOne(@PathVariable int id,HttpServletRequest request) {
        return service.findOne(new Long(id));
    }

    @RequestMapping("/all")
    public Iterable<DTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody DTO modelToSave) {
        service.save(modelToSave);
    }

    @RequestMapping(value = "/save/all", method = RequestMethod.POST)
    public void save(@RequestBody Iterable<DTO> modelsToSave) {
        service.save(modelsToSave);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@RequestBody DTO modelToDelete, @PathVariable int id) {
        service.delete(modelToDelete);
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.POST)
    public void delete(@RequestBody Iterable<DTO> modelsToDelete) {
        service.delete(modelsToDelete);
    }
}
