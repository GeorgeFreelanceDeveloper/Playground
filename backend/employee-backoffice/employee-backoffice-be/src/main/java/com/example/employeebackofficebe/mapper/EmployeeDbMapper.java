package com.example.employeebackofficebe.mapper;

import com.example.employeebackofficebe.model.db.EmployeeEntity;
import com.example.employeebackofficebe.model.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeDbMapper {

    EmployeeDbMapper MAPPER = Mappers.getMapper(EmployeeDbMapper.class);

    EmployeeEntity toEmployeeDb(EmployeeDto employeeDto);

    EmployeeDto fromEmployeeDb(EmployeeEntity employeeDb);

    List<EmployeeDto> fromEmployeesDb(List<EmployeeEntity> employeeDbs);

    List<EmployeeEntity> toEmployeesDb(List<EmployeeDto> employeeDtos);

}
