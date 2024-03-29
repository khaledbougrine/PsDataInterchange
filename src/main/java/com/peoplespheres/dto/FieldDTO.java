package com.peoplespheres.dto;

// Local imports
import com.fasterxml.jackson.annotation.JsonInclude;
import com.peoplespheres.enums.FieldTypeEnum;

// Swagger imports
import io.swagger.v3.oas.annotations.media.Schema;

// Lombok imports
import lombok.*;

// Javax imports
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

// J2EE imports
import java.io.Serializable;

/** A DTO for the {@link com.peoplespheres.out.mapping.infrastructure.persistence.models.FieldEntity} entity */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FieldDTO implements Serializable {
    @Schema(description = "Unique identifier of the field", required = true)
    @NotNull(message = "{field.id.not-null}")
    private Long id;

    @Schema(description = "Alias of the field (ex: usr_username)", example = "usr_username", required = true)
    @Size(max = 255, message = "{field.alias.max_size}")
    @NotNull(message = "{field.alias.not-null}")
    private String alias;

    @Schema(description = "Name of the displayed field (ex:Username)", example = "Username", required = true)
    @Size(max = 255, message = "{field.name.max_size}")
    @NotNull(message = "{field.name.not-null}")
    private String name;

    @Schema(description = "Type of the field (ex:text)", example = "text", required = true,
            allowableValues = {"alias", "text", "list", "hierarchy", "checkbox", "multi_checkbox", "radio_button",
            "composite", "calculated", "currency", "range", "named_file", "tag", "url", "number", "datetime", "date", "image",
            "user_relation", "group", "latitude", "longitude", "modules", "domain", "external_id", "string"})
    @NotNull(message = "{field.type.not-null}")
    private FieldTypeEnum type;

    @Schema(description = "Id of the parent PSO type of this field", required = true)
    @PositiveOrZero(message = "{field.pso_type_id.positive}")
    private Integer psoTypeId;

    @Schema(description = "Alias of the parent PSO type of this field (ex:usr)", example = "usr", required = true)
    @Size(max = 3, message = "{field.pso_type_alias.max_size}")
    @NotNull(message = "{field.pso_type_alias.not-null}")
    private String psoTypeAlias;

    @Schema(description = "Displayed name of the parent PSO type of this field (ex:User)", example = "User", required = true)
    @Size(max = 255, message = "{field.pso_type_name.max_size}")
    @NotNull(message = "{field.pso_type_name.not-null}")
    private String psoTypeName;

    @Schema(description = "Alias of the parent category for this field (ex:usr_identity)", example = "usr_identity", required = true)
    @Size(max = 255, message = "{field.category_alias.max_size}")
    @NotBlank(message = "{field.category_alias.not-null}")
    private String categoryAlias;

    @Schema(description = "Name of the parent category for this field (ex:Identity)", example = "Identity", required = true)
    @Size(max = 100, message = "{field.category_name.max_size}")
    @NotBlank(message = "{field.category_name.not-null}")
    private String categoryName;

    @Schema(description = "Boolean indicating if this property is an array", required = true)
    @NotNull(message = "{field.is_array.not-null}")
    private Boolean isArray = false;
}