package com.peoplespheres.dto;

// Jackson imports
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

// Local imports
import com.peoplespheres.enums.ConnectorTypeEnum;

// Swagger imports
import io.swagger.v3.oas.annotations.media.Schema;

// Lombok imports
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Spring imports
import org.springframework.lang.Nullable;

// Javax imports
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

// J2EE imports
import java.util.ArrayList;
import java.util.List;

/** DTO data transport object for connector data */
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Connector DTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConnectorDTO {
    @Schema(description = "Connector ID", nullable = true)
    @Nullable
    private Long id;

    @Schema(description = "Connector name", required = true)
    @NotBlank(message="{connector.name.not-blank}")
    private String name;

    @Schema(description = "Connector type", required = true)
    @JsonProperty("type")
    @NotBlank(message="{connector.type.not-blank}")
    private ConnectorTypeEnum typeCode;

    @Schema(description = "List of flow ids", required = true)
    @NotNull(message="{connector.flows.id.not-null}")
    private List<Long> flowIds = new ArrayList<>();

    @Schema(description = "Unique identifier of the targeted module", required = true)
    @NotNull(message="{connector.module.id.not-null}")
    @PositiveOrZero(message="{connector.module.id.positive}")
    private Long moduleId;

    @Schema(description = "Unique identifier of the client", nullable = true) // Required, but not needed from the FE
    @NotBlank(message="{connector.client.id.not-blank}")
    @Size(min=36,max=36, message = "{connector.client.id.uuid-format}")
    String clientId;
}
