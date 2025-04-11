package io.git.yhugorocha.learning.exception;

import java.util.List;

public record StandartError (Integer statusCode,
                             String message,
                             Long timestamp,
                             List<FieldError> errors){
}
