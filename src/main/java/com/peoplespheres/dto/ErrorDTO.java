package com.peoplespheres.dto;

// Swagger imports
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

// Lombok imports
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// Spring imports
import org.springframework.lang.Nullable;

// J2EE imports
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

// J2EE imports
import java.time.OffsetDateTime;

/** DTO to transport and expose data for an error message */
@Getter
@RequiredArgsConstructor
@Schema(description = "Contains business or technical exception body.")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    @Schema(description = "Date", nullable = true)
    @Nullable
    private final OffsetDateTime timestamp = OffsetDateTime.now();

    @Schema(description = "HTTP Status code", required = true)
    @Positive
    private final int statusCode;

    @Schema(description = "Error message", nullable = true)
    @Nullable
    private final String message;

    @Schema(description = "Request URL", required = true)
    @NotBlank(message = "{errorDTO.request.url.not-blank}")
    private final String request;
}
