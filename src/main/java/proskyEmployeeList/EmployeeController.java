package proskyEmployeeList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String wellcome(){
        return "Добро пожаловать!";
    }
//    @GetMapping("/complete")
//    public boolean completeCollection(){
//        return employeeService.completeCollectionEmployeeBook();
//    }
//    @GetMapping("/printAll")
//    public List<Employee> printAllEmployee(){
//        return employeeService.printAll();
//    }
    @GetMapping("/add")
    public boolean add(@RequestParam String name, @RequestParam String surname, @RequestParam String patronymic, @RequestParam int department, @RequestParam double salary){
        return employeeService.employeeAdd(name, patronymic, surname, department, salary);
    }
    @GetMapping("/remove")
    public boolean remove(@RequestParam String name, @RequestParam String patronymic, @RequestParam String surname){
        return employeeService.employeeRemove(name, patronymic, surname);
    }
    @GetMapping("/search")
    public Employee search(@RequestParam String name, @RequestParam String patronymic, @RequestParam String surname){
        return employeeService.searchEmployee(name, patronymic, surname);
    }
    @GetMapping("/departments/max-salary")
    public void maxSalary(@RequestParam int department){
        employeeService.employeesMaxSalary(department);
    }
    @GetMapping("/departments/min-salary")
    public void minSalary(@RequestParam int department){
        employeeService.employeesMinSalary(department);
    }
    @GetMapping("/departments/all")
    public void employeesPrint(@RequestParam int department){
        employeeService.employeesPrint(department);
    }
//    @GetMapping("/departments/all")
//    public void employeesFullPrint(){
//        employeeService.employeesFullPrint();
//    }
}
