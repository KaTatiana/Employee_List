package proskyEmployeeList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String wellcome(){
        return "Добро пожаловать!";
    }
    @GetMapping("/complete")
    public boolean completeCollection(){
        return employeeService.completeCollectionEmployeeBook();
    }
    @GetMapping("/printAll")
    public List<Employee> printAllEmployee(){
        return employeeService.printAll();
    }
    @GetMapping("/add")
    public boolean add(@RequestParam String name, @RequestParam String surname){
        return employeeService.employeesAdd(name, surname);
    }
    @GetMapping("/remove")
    public boolean remove(@RequestParam String name, @RequestParam String surname){
        return employeeService.employeesRemove(name, surname);
    }
    @GetMapping("/search")
    public Employee search(@RequestParam String name, @RequestParam String surname){
        return employeeService.employeeSearch(name, surname);
    }
}
