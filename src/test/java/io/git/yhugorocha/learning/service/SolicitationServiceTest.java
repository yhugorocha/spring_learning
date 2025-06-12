package io.git.yhugorocha.learning.service;

import io.git.yhugorocha.learning.dto.Solicitation;
import io.git.yhugorocha.learning.entities.SolicitationEntity;
import io.git.yhugorocha.learning.mapper.SolicitationMapper;
import io.git.yhugorocha.learning.repository.SolicitationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SolicitationServiceTest {

    @Mock
    private SolicitationRepository solicitationRepository;
    @Mock
    private SolicitationMapper solicitationMapper;
    private SolicitationService solicitationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        solicitationService = spy(new SolicitationService(solicitationRepository, solicitationMapper));
    }

    @Test
    @DisplayName("Test create Solicitation")
    void testCreate() {
        Solicitation solicitation = mock(Solicitation.class);
        SolicitationEntity entity = mock(SolicitationEntity.class);
        Solicitation resultDto = mock(Solicitation.class);

        doReturn(entity).when(solicitationMapper).toSolicitationEntity(solicitation);
        doReturn(resultDto).when(solicitationMapper).toSolicitation(entity);
        doReturn(entity).when(solicitationRepository).save(any(SolicitationEntity.class));

        Solicitation result = solicitationService.create(solicitation);

        verify(solicitationMapper).toSolicitationEntity(any(Solicitation.class));
        verify(solicitationMapper).toSolicitation(any(SolicitationEntity.class));
        verify(solicitationRepository).save(any(SolicitationEntity.class));
        assertEquals(resultDto, result);
    }
}