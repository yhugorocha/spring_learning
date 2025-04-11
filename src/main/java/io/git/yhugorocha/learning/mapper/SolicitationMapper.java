package io.git.yhugorocha.learning.mapper;

import io.git.yhugorocha.learning.dto.Solicitation;
import io.git.yhugorocha.learning.entities.SolicitationEntity;
import io.git.yhugorocha.learning.entities.enums.SolicitationSituation;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SolicitationMapper {

    @Mapping(source = "situation", target = "situation", qualifiedByName = "stringToSituation")
    SolicitationEntity toSolicitationEntity(Solicitation solicitation);

    @Mapping(source = "situation", target = "situation", qualifiedByName = "situationToString")
    Solicitation toSolicitation(SolicitationEntity solicitationEntity);

    void updateSolicitation(Solicitation solicitation, @MappingTarget SolicitationEntity solicitationEntity);

    @AfterMapping
    default void linkProducts(@MappingTarget SolicitationEntity solicitationEntity) {
        if (solicitationEntity.getProducts() != null) {
            solicitationEntity.getProducts().forEach(product -> product.setSolicitation(solicitationEntity));

        }
    }

    @Named("situationToString")
    static String situationToString(SolicitationSituation situation) {
        return situation != null ? situation.getSituation() : null;
    }

    @Named("stringToSituation")
    static SolicitationSituation stringToSituation(String situationStr) {
        if(situationStr != null){
            for (SolicitationSituation situation : SolicitationSituation.values()) {
                if (situation.getSituation().equalsIgnoreCase(situationStr)) {
                    return situation;
                }
            }
            throw new IllegalArgumentException("Situação inválida: " + situationStr);
        }
        return null;
    }
}
