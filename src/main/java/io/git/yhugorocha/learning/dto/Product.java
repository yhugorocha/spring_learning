package io.git.yhugorocha.learning.dto;

import java.time.LocalDateTime;

public record Product (Long id,
                       String description,
                       LocalDateTime createdAt){
}
