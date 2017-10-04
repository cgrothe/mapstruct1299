package org.mapstruct.example.working.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Qualifier;
import org.mapstruct.example.model.Source;
import org.mapstruct.example.model.TargetDto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Mapper
public abstract class AbstractGenerateMapper {

	public static final String DTO_VERSION = "1.0.0";
	public static final String SEPERATOR = "-";

	@Mappings(
		{
			@Mapping(target = "dtoVersion", constant = DTO_VERSION),
			@Mapping(target = "generatedId", source = "source"),
			@Mapping(target = "generatedByCode", expression = "java(new java.lang.String(\"test\"))")
		}
	)
	public abstract TargetDto map(Source source);


	// =======================================
	@Mappings(
		{
			@Mapping(target = "part1", source = "generatedId", qualifiedBy = Part1.class),
			@Mapping(target = "part2", source = "generatedId", qualifiedBy = Part2.class)
		}
	)
	public abstract Source map(TargetDto t);

	public String generateId(final Source source) {

		return source.getPart1() + SEPERATOR + source.getPart2();
	}

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
