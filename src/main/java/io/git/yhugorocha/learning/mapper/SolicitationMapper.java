package io.git.yhugorocha.learning.mapper;

import io.git.yhugorocha.learning.dto.Solicitation;
import io.git.yhugorocha.learning.entities.SolicitationEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SolicitationMapper {

    SolicitationEntity toSolicitationEntity(Solicitation solicitation);
    Solicitation toSolicitation(SolicitationEntity solicitationEntity);

    void updateSolicitation(Solicitation solicitation, @MappingTarget SolicitationEntity solicitationEntity);

    @AfterMapping
    default void linkProducts(@MappingTarget SolicitationEntity solicitationEntity) {
        if (solicitationEntity.getProducts() != null) {
            solicitationEntity.getProducts().forEach(product -> product.setSolicitation(solicitationEntity));

        }
    }
}
