package pl.trainingCompany.service.mappers;

/**
 * Created by Kamil S on 2016-03-17.
 */
public interface AbstractMapper<DBO,DTO> {

    public DBO convertToDBO(DTO dto);

    public DTO convertToDTO(DBO dbo);

    public Iterable<DBO> convertToDBO(Iterable<DTO>  dto);

    public Iterable<DTO> convertToDTO(Iterable<DBO> dbo);





}
