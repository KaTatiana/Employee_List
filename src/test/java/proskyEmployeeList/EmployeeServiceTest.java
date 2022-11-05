package proskyEmployeeList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import proskyEmployeeList.Service.*;
import proskyEmployeeList.Exception.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();

    @ParameterizedTest
    @MethodSource("paramsadd")
    public void addNegativeTest(String name, String patronymic, String surname, int department, double salary){
        assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(()->employeeService.employeeAdd(name, patronymic, surname, department, salary));
    }

    @ParameterizedTest
    @MethodSource("params")
    public void searchEmployeePositiveTest(String name, String patronymic, String surname){
        Employee expected = new Employee(name, patronymic, surname);

        assertThat(employeeService.searchEmployee(name, patronymic, surname)).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("params")
    public void employeeRemovePositiveTest(String name, String patronymic, String surname){
        Employee exspected =new Employee(name, patronymic, surname);

        assertThat(employeeService.employeeRemove(name, patronymic, surname)).isEqualTo(true);
    }
    
    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("Иван","Иванович","Иванов")
//                Arguments.of("Петров","Петр","Петрович"),
//                Arguments.of("Сергеев","Сергей","Сергеевич")
//                Arguments.of("Иван","Иванович","Иванов"),
//                Arguments.of("Петров","Петр","Петрович"),
//                Arguments.of("Сергеев","Сергей","Сергеевич")
        );
    }
    public static Stream<Arguments> paramsadd() {
        return Stream.of(
//                Arguments.of("Ivan","Ihchdvk","Hchjdvjh",2,50000)
                Arguments.of("Иван","Иванович","Иванов",1,52000.0)
//                Arguments.of("Сергеев","Сергей","Сергеевич")
//                Arguments.of("Иван","Иванович","Иванов"),
//                Arguments.of("Петров","Петр","Петрович"),
//                Arguments.of("Сергеев","Сергей","Сергеевич")
        );
    }
}
