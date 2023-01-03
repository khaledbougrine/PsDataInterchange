package com.peoplespheres.dto;

// Swagger imports
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

// Lombok imports
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Spring imports
import org.springframework.lang.Nullable;

// Javax imports
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

// J2EE imports
import java.io.Serializable;

/** Projection of flow module */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Represent a module row for a flow.")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleDTO implements Serializable {
    @Schema(description = "The unique technical identifier of the module", required = true)
    @NotNull(message = "{module.id.not-null}")
    @PositiveOrZero(message = "{module.id.positive}")
    Long id;

    @Schema(description = "The name of the module", required = true)
    @NotBlank(message = "{module.name.not-blank}")
    String name;

    @Schema(description = "The alias of the module", nullable = true)
    @Nullable
    String alias;

    @Schema(description = "The name of the partner owning the module", nullable = true)
    @Nullable
    String partnerName;

    @Schema(description = "Boolean flag indicating if the module is active", required = true)
    @NotNull(message = "{module.active.not-null}")
    Boolean isActive = true;
}
