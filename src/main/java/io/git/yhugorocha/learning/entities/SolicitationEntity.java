package io.git.yhugorocha.learning.entities;

import io.git.yhugorocha.learning.entities.enums.SolicitationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "tb_solicitations")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "number", nullable = false, length = 100)
    private String number;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 100)
    private SolicitationStatus status;
    @OneToMany(mappedBy = "solicitation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_document_id", referencedColumnName = "id")
    private DeliveryDocumentEntity deliveryDocument;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
