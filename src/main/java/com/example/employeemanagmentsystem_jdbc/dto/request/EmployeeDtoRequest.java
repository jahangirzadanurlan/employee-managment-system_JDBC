package com.example.employeemanagmentsystem_jdbc.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDtoRequest {
    Long id;
    String name;
    String country;
}
