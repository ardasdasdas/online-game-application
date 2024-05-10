package tr.com.estu.onlinegameapplication.service.base;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.dto.base.BaseDTO;
import tr.com.estu.onlinegameapplication.exception.ItemNotFoundException;
import tr.com.estu.onlinegameapplication.exception.error.GenericErrorMessage;
import tr.com.estu.onlinegameapplication.mapper.Mapper;
import tr.com.estu.onlinegameapplication.model.base.BaseAdditionalFields;
import tr.com.estu.onlinegameapplication.model.base.BaseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public abstract class BaseService<E extends BaseEntity, A extends BaseDTO, D extends JpaRepository<E, Long>> {
    private static final Integer DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_SIZE = 10;

    private final D dao;
    private final Class<A> dtoClass;
    private final Class<E> persistantClass;

    protected Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public List<A> findAll(){
        return Mapper.mapList(dao.findAll(), dtoClass);
    }

    public A save(A dto){
        E entity = Mapper.map(dto, persistantClass);
        setAdditionalFields(entity);
        entity = dao.save(entity);

        return Mapper.map(entity, dtoClass);
    }

    public void setAdditionalFields(E entity) {

        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();

        if (isNull(baseAdditionalFields)){
            baseAdditionalFields = new BaseAdditionalFields();
            entity.setBaseAdditionalFields(baseAdditionalFields);
        }

        if (isNull(entity.getId())){
            baseAdditionalFields.setCreateDate(new Date());
        }

        baseAdditionalFields.setUpdateDate(new Date());
    }

    public void deleteById(Long id){
        dao.deleteById(id);
    }

    public A findByIdWithControl(Long id) {

        Optional<E> entityOptional = findById(id);

        E entity;
        if (entityOptional.isPresent()){
            entity = entityOptional.get();
        } else {
            throw new ItemNotFoundException(GenericErrorMessage.ITEM_NOT_FOUND);
        }

        return Mapper.map(entity, dtoClass);
    }

    public boolean existsById(Long id){
        return dao.existsById(id);
    }

    public PageRequest getPageRequest(Optional<Integer> pageOptional, Optional<Integer> sizeOptional) {
        Integer page = getPage(pageOptional);
        Integer size = getSize(sizeOptional);

        return PageRequest.of(page, size);
    }

    public Integer getSize(Optional<Integer> sizeOptional) {

        Integer size = DEFAULT_SIZE;
        if (sizeOptional.isPresent()){
            size = sizeOptional.get();
        }
        return size;
    }

    public Integer getPage(Optional<Integer> pageOptional) {

        Integer page = DEFAULT_PAGE;
        if (pageOptional.isPresent()){
            page = pageOptional.get();
        }
        return page;
    }
}
