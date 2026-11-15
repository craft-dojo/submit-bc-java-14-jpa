package com.cybersoft.assign_14_jpa.services;

import com.cybersoft.assign_14_jpa.response.EmployeeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<EmployeeResponseDTO> getEmployeesWithPageAndSort(Pageable pageable);
}
