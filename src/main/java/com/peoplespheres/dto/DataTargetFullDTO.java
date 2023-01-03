package com.peoplespheres.dto;

// Swagger imports
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

// Lombok imports
import lombok.Getter;
import lombok.Setter;

// J2EE imports
import java.io.Serializable;

@Getter
@Setter
@Schema(description = "Data target DTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataTargetFullDTO extends ADataFullDTO implements Serializable {

}
