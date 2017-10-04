package org.mapstruct.example.notworking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.example.model.Source;
import org.mapstruct.example.model.TargetDto;
import org.mapstruct.example.notworking.mapper.util.MappingUtils;
import org.mapstruct.example.notworking.mapper.util.MappingUtils.Part1;
import org.mapstruct.example.notworking.mapper.util.MappingUtils.Part2;


@Mapper(uses = MappingUtils.class)
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

}
