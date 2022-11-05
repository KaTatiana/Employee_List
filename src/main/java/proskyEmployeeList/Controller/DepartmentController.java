package proskyEmployeeList.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proskyEmployeeList.Service.DepartmentService;
import proskyEmployeeList.Employee;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/departments/max-salary")
    public Employee maxSalary(@RequestParam int department){
        return departmentService.employeesMaxSalary(department);
    }
    @GetMapping("/departments/min-salary")
    public Employee minSalary(@RequestParam int department){
        return departmentService.employeesMinSalary(department);
    }
    @GetMapping(path = "/departments/all", params = "department")
    public List<Employee> employeesPrint(@RequestParam int department){
        return departmentService.employeesPrint(department);
    }
    @GetMapping(path = "/departments/all")
    public Map<Integer,List<Employee>> allPrint(){
        return  departmentService.allPrint();
    }
}
