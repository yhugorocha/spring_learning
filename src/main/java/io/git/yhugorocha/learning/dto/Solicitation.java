package io.git.yhugorocha.learning.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;
import java.util.List;

public record Solicitation(Long id,
                           @NotBlank(message = "Campo obrigatório!")
                           String number,
                           String status,
                           String situation,
                           List<Product> products,
                           DeliveryDocument deliveryDocument,
                           @NotNull(message = "Campo obrigatório!")
                           @Past(message = "Não pode ser data futura!")
                           LocalDateTime publicationDate,
                           LocalDateTime createdAt){
}
