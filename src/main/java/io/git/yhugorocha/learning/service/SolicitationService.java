package io.git.yhugorocha.learning.service;

import io.git.yhugorocha.learning.dto.Solicitation;
import io.git.yhugorocha.learning.entities.SolicitationEntity;
import io.git.yhugorocha.learning.entities.enums.SolicitationSituation;
import io.git.yhugorocha.learning.entities.enums.SolicitationStatus;
import io.git.yhugorocha.learning.mapper.SolicitationMapper;
import io.git.yhugorocha.learning.repository.SolicitationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SolicitationService {

    private final SolicitationRepository solicitationRepository;
    private final SolicitationMapper solicitationMapper;

    @Transactional(rollbackOn = Exception.class)
    public Solicitation create(Solicitation solicitation){
        var entity = solicitationMapper.toSolicitationEntity(solicitation);
        entity.setStatus(SolicitationStatus.OPEN);
        entity.setSituation(SolicitationSituation.INITIATED);
        solicitationRepository.save(entity);
        return solicitationMapper.toSolicitation(entity);
    }

    @Transactional(rollbackOn = Exception.class)
    public Solicitation update(Long id, Solicitation solicitation){
        var entity = solicitationRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Solicitação não encontrada"));
        if(solicitation.products().isEmpty()){
            entity.getProducts().clear();
        }
        solicitationMapper.updateSolicitation(solicitation, entity);
        solicitationRepository.save(entity);
        return solicitationMapper.toSolicitation(entity);
    }

    public List<Solicitation> findAll(){
        return solicitationRepository.findAll().stream().map(solicitationMapper::toSolicitation).toList();
    }

    public Page<SolicitationEntity> findAllPageable(Pageable pageable){
        return solicitationRepository.findAll(pageable);
    }
}
