package com.peoplespheres.dto;

// J2EE imports
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

// Lombok imports
import lombok.*;
import org.springframework.lang.Nullable;

// Javax imports
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// J2EE imports
import java.util.List;

/** DTO data transport object for client data */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Client DTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {
    @Schema(description = "Client technical unique identifier", required = true)
    @NotNull(message="{client.guid.not-null}")
    String id;

    @Schema(description = "Client name (ex:Orchestrate)", example = "Orchestrate", required = true)
    @NotBlank(message="{client.name.not-blank}")
    String name;

    @Schema(description = "Client alias (ex:orchestrate)", example = "orchestrate", required = true)
    @NotBlank(message="{client.alias.not-blank}")
    String alias;

    @Schema(description = "Client description", nullable = true)
    @Nullable
    String description;

    @Schema(description = "Client list of its active connector unique identifiers", nullable = true)
    @Nullable
    List<Long> connectorIds;

    @Schema(description = "Client list of its active population names", nullable = true)
    @Nullable
    List<String> populations;

    @Schema(description = "Client list of its active settings unique identifiers", nullable = true)
    @Nullable
    List<Long> settingIds;
}