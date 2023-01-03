package com.peoplespheres.dto;

// Swagger imports
import com.fasterxml.jackson.annotation.JsonInclude;
import com.peoplespheres.enums.ConnectorTypeEnum;

// Swagger imports
import io.swagger.v3.oas.annotations.media.Schema;

// Lombok imports
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// J2EE imports
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

// J2EE imports
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Import connector template file")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConnectorFullDTO implements Serializable {
    @Schema(description = "Connector ID", nullable = true)
    @Nullable
    @PositiveOrZero(message="{connector.id.positive}")
    private Long id;

    @Schema(description = "Connector name", required = true)
    @NotBlank(message="{connector.name.not-blank}")
    private String name;

    @Schema(description = "Connector type", allowableValues = {"IN", "OUT", "IN-OUT"}, required = true)
    @NotBlank(message="{connector.type.not-blank}")
    private ConnectorTypeEnum type;

    @Schema(description = "Provider ID", required = true)
    @NotBlank(message="{connector.provider.not-blank}")
    private String providerId;

    @Schema(description = "Is this connector currently active ?", required = true)
    @NotBlank(message="{connector.provider.not-blank}")
    private Boolean isActive;

    @Schema(description = "List of flows", nullable = true)
    @Nullable
    private Set<FlowFullDTO> flows;
}
