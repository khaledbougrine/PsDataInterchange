package com.peoplespheres.dto;

// Local imports
import com.fasterxml.jackson.annotation.JsonInclude;
import com.peoplespheres.entites.FieldCategoryEntity;


// Swagger imports
import io.swagger.v3.oas.annotations.media.Schema;

// Lombok imports
import lombok.Data;
import lombok.NoArgsConstructor;

// Javax imports
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// J2EE imports
import java.io.Serializable;

/** A DTO for the {@link FieldCategoryEntity} entity */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FieldCategoryDTO implements Serializable {
    @Schema(description = "Alias of this field category (ex:usr_identity)", example = "usr_identity", required = true)
    @Size(max = 255, message = "{field_category.alias.max_size}")
    @NotBlank(message = "{field_category.alias.not-null}")
    private String alias;

    @Schema(description = "Displayed name of the field category (ex:Identity)", example = "Identity", required = true)
    @Size(max = 100, message = "{field_category.name.max_size}")
    @NotBlank(message = "{field_category.name.not-blank}")
    private String name;
}