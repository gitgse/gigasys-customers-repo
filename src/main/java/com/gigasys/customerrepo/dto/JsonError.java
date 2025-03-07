package com.gigasys.customerrepo.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

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
public class JsonError {

	private final String code;
	private final String message;
	private final LocalDateTime timestamp;
	
	public JsonError(String code, String message) {
		this.code = code;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
}
