package com.example.employeebackofficebe.mapper;

import com.example.employeebackofficebe.model.db.key.TitleKey;
import com.example.employeebackofficebe.model.dto.TitleDto;
import com.example.employeebackofficebe.model.dto.TitleId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TitleDbIdMapper {

    TitleDbIdMapper MAPPER = Mappers.getMapper(TitleDbIdMapper.class);

    TitleKey toTitleDbId(TitleId titleId);

    TitleDto fromTitleDbId(TitleKey titleKey);
}
