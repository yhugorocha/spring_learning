package io.git.yhugorocha.learning.controller;

import io.git.yhugorocha.learning.dto.Solicitation;
import io.git.yhugorocha.learning.entities.SolicitationEntity;
import io.git.yhugorocha.learning.service.SolicitationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/solicitacoes")
public class SolicitationController {

    private final SolicitationService solicitationService;

    @PostMapping
    public ResponseEntity<Solicitation> createSolicitation(@Valid @RequestBody Solicitation solicitation){
        return ResponseEntity.ok(solicitationService.create(solicitation));
    }

    @GetMapping
    public ResponseEntity<List<Solicitation>> getSolicitations(){
        return ResponseEntity.ok(solicitationService.findAll());
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<SolicitationEntity>> getSolicitations(Pageable pageable){
        return ResponseEntity.ok(solicitationService.findAllPageable(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitation> updateSolicitation(@PathVariable("id") Long id, @RequestBody Solicitation solicitation){
        return ResponseEntity.ok(solicitationService.update(id, solicitation));
    }
}
