package com.gigasys.customerrepo.dto;

import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.ERROR_CODE_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.ERROR_CODE_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.ERROR_MESSAGE_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.ERROR_MESSAGE_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.ERROR_TIMESTAMP_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.ERROR_TIMESTAMP_EXAMPLE;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * JsonError.java
 * DTO portant les informations d'erreur à restituer au client
 * @author Gilles
 */
@JsonTypeName(value = "error")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@Getter
@ToString
@EqualsAndHashCode
@Schema(name = "Error")
public class JsonError {

	@Schema(requiredMode = RequiredMode.NOT_REQUIRED, example = ERROR_CODE_EXAMPLE, description = ERROR_CODE_DESCRIPTION)
	private final String code;
	
	@Schema(requiredMode = RequiredMode.REQUIRED, example = ERROR_MESSAGE_EXAMPLE, description = ERROR_MESSAGE_DESCRIPTION)
	private final String message;
	
	@Schema(requiredMode = RequiredMode.REQUIRED, example = ERROR_TIMESTAMP_EXAMPLE, description = ERROR_TIMESTAMP_DESCRIPTION)
	private final LocalDateTime timestamp;
	
	
	public JsonError(String code, String message) {
		this.code = code;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
}
