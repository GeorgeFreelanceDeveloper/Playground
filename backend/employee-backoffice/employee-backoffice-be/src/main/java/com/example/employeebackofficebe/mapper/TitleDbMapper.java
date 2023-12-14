package com.example.employeebackofficebe.mapper;

import com.example.employeebackofficebe.model.db.TitleEntity;
import com.example.employeebackofficebe.model.dto.TitleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TitleDbMapper {

    TitleDbMapper MAPPER = Mappers.getMapper(TitleDbMapper.class);

    TitleEntity toTitleDb(TitleDto titleDto);

    TitleDto fromTitleDb(TitleEntity titleEntity);

}
