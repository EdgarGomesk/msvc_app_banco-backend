package org.gomes.springcloud.msvc_clientes.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class ErrDto {
    private String message;
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;
}
