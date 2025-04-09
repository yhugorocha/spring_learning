package io.git.yhugorocha.learning.dto;

import java.time.LocalDateTime;

public record DeliveryDocument(Long id,
                               Boolean rg,
                               Boolean cpf,
                               Boolean proofOfResidence,
                               LocalDateTime createdAt) {
}
