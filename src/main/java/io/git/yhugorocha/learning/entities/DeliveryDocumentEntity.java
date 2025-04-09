package io.git.yhugorocha.learning.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "tb_delivery_document")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "rg", nullable = false)
    private boolean rg;
    @Column(name = "cpf", nullable = false)
    private boolean cpf;
    @Column(name = "proof_of_residence", nullable = false)
    private boolean proofOfResidence;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
