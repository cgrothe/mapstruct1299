package org.mapstruct.example.notworking.mapper.util;

import org.mapstruct.Mapper;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Mapper
public abstract class MappingUtils {
	public static final String SEPERATOR = "-";

	@Part1
	public String extractPart1(final String generatedId) {
		return generatedId.split(SEPERATOR)[0];
	}

	@Part2
	public String extractPart2(final String generatedId) {
		return generatedId.split(SEPERATOR)[1];
	}

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.SOURCE)
	public @interface Part1 {
	}

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.SOURCE)
	public @interface Part2 {
	}

}
