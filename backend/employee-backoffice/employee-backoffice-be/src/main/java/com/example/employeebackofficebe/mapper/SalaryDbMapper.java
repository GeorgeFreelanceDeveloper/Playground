package com.example.employeebackofficebe.mapper;

import com.example.employeebackofficebe.model.db.SalaryEntity;
import com.example.employeebackofficebe.model.dto.SalaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalaryDbMapper {

    SalaryDbMapper MAPPER = Mappers.getMapper(SalaryDbMapper.class);

    SalaryEntity toSalaryDb(SalaryDto salaryDto);

    SalaryDto fromSalaryDb(SalaryEntity salaryEntity);

}
