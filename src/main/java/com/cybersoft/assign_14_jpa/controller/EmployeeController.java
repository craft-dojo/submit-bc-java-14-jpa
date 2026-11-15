package com.cybersoft.assign_14_jpa.controller;

import com.cybersoft.assign_14_jpa.response.BaseResponse;
import com.cybersoft.assign_14_jpa.response.EmployeeResponseDTO;
import com.cybersoft.assign_14_jpa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getEmployeesWithPaginationAndSort(
            @PageableDefault(page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC)
            Pageable pageable) {

        Page<EmployeeResponseDTO> employeeResponseDTOPage = employeeService.getEmployeesWithPageAndSort(pageable);
        BaseResponse res = BaseResponse.success(employeeResponseDTOPage, null, null);

        return ResponseEntity.ok(res);
    }
}
