package proskyEmployeeList.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proskyEmployeeList.Employee;
import proskyEmployeeList.Service.EmployeeService;

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

}
