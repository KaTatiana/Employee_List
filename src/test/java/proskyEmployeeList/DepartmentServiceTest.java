package proskyEmployeeList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import proskyEmployeeList.Service.DepartmentService;
import proskyEmployeeList.Service.EmployeeService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void beforeEach(){
        List <Employee> employees = List.of(
                new Employee("Иван","Иванович","Иванов", 2, 50000),
                new Employee("Петр","Иванович","Петров",3,45000),
                new Employee("Петр","Иванович","Иванов", 3,35000),
                new Employee("Петр","Иванович","Семенов",2,60000),
                new Employee("Петр","Иванович","Смирнов", 1, 34000)
        );
        when(employeeService.getAll()).thenReturn(employees);
    }
    @ParameterizedTest
    @MethodSource("employeesMaxSalaryParams")
    public void employeesMaxSalaryTest(int department, Employee expected){
        assertThat(departmentService.employeesMaxSalary(department)).isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("employeesMinSalaryParams")
    public void employeesMinSalaryTest(int department, Employee expected){
        assertThat(departmentService.employeesMinSalary(department)).isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("employeesPrintParams")
    public void employeesPrintTest(int department, List<Employee> expected){
        assertThat(departmentService.employeesPrint(department)).isEqualTo(expected);
    }
    public static Stream<Arguments>employeesMaxSalaryParams(){
        return Stream.of(
                Arguments.of(3, new Employee("Петр","Иванович","Петров",3,45000)),
                Arguments.of(2, new Employee("Петр","Иванович","Семенов",2,60000))
        );
    }
    public static Stream<Arguments>employeesMinSalaryParams(){
        return Stream.of(
                Arguments.of(3, new Employee("Петр","Иванович","Иванов", 3,35000)),
                Arguments.of(2, new Employee("Иван","Иванович","Иванов", 2, 50000))
        );
    }
    public static Stream<Arguments>employeesPrintParams(){
        return Stream.of(
                Arguments.of(1, List.of(new Employee("Петр","Иванович","Смирнов", 1, 34000))),
                Arguments.of(2, List.of(new Employee("Иван","Иванович","Иванов", 2, 50000), new Employee("Петр","Иванович","Семенов",2,60000))),
                Arguments.of(3, List.of(new Employee("Петр","Иванович","Петров",3,45000), new Employee("Петр","Иванович","Иванов", 3,35000))),
                Arguments.of(4, Collections.emptyList())
        );
    }
}
