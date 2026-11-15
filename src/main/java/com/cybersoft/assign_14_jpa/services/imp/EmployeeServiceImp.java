package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.repository.EmployeeRepository;
import com.cybersoft.assign_14_jpa.response.EmployeeResponseDTO;
import com.cybersoft.assign_14_jpa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<EmployeeResponseDTO> getEmployeesWithPageAndSort(Pageable pageable) {
        return employeeRepository.findAll(pageable)
                .map(EmployeeResponseDTO::mapToDTO);
    }
}
