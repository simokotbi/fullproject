package com.ahmed.fullproject.mapper;

import com.ahmed.fullproject.dto.AbstractDTO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ReferenceMapper {

    private final EntityManager em;
    Logger logger = LoggerFactory.getLogger(ReferenceMapper.class);

    public ReferenceMapper(EntityManager em) {
        this.em = em;
    }

    @ObjectFactory
    public <T extends AbstractEntity<?>> T resolve(AbstractDTO<?> sourceDTO,
                                                   @TargetType Class<T> type) {
        T entity = null;
        if (sourceDTO.getId() != null) entity = em.find(type, sourceDTO.getId());
        try {
            if (entity == null) {
                entity = type.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            logger.error(e.getMessage());
        }
        return entity;
    }
}