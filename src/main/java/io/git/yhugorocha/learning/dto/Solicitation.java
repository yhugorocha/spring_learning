package io.git.yhugorocha.learning.dto;

import java.time.LocalDateTime;
import java.util.List;

public record Solicitation(Long id,
                           String number,
                           String status,
                           List<Product> products,
                           DeliveryDocument deliveryDocument,
                           LocalDateTime createdAt){
}
