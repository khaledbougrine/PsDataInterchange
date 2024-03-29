package com.peoplespheres.dto;

// Jackson imports
import com.fasterxml.jackson.annotation.JsonInclude;

// Swagger imports
import io.swagger.v3.oas.annotations.media.Schema;

// Lombok imports
import lombok.Getter;
import lombok.Setter;

// Javax imports
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

// J2EE imports
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Schema(description = "Mapping full DTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MappingFullDTO extends AMappingDTO implements Serializable {
    @Schema(description = "Main source data associated to this mapping", nullable = true)
    @Nullable
    DataSourceFullDTO dataSource;

    @Schema(description = "Transformations needed on this mapping, no transformation means raw-data transformation", nullable = true)
    @Nullable
    private Collection<TransformationFullDTO> transformations = new ArrayList<>();

    @Schema(description = "Target data associated to this mapping", required = true)
    @NotNull(message="{mapping.target.not-null}")
    DataTargetFullDTO dataTarget;
}
