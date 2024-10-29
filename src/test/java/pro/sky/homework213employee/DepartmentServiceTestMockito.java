package pro.sky.homework213employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework213employee.services.DepartmentServiceImpl;
import pro.sky.homework213employee.services.EmploeeServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTestMockito {
    Set<Emploee> emploee = Set.of(new Emploee("Aa", "Bb", 1, 1000),
                                  new Emploee("Cc", "Dd", 1, 2000),
                                  new Emploee("Ee", "Ff", 2, 3000));

    @Mock
    private EmploeeServiceImpl emploeeServ;

    @InjectMocks
    private DepartmentServiceImpl depServ;

    @Test
    public void salaryMax() {
        when(emploeeServ.getEmploees()).thenReturn(emploee);
        Emploee expected = emploee
                .stream()
                .filter(x -> x.getDepartmentNo().equals(1))
                .max(Comparator.comparingInt(y -> y.getSalary()))
                .get();
        Emploee actual = depServ.salaryMax(1);
        assertEquals(actual, expected);
        verify(emploeeServ, times(1)).getEmploees();
    }

    @Test
    public void salaryMin() {
        when(emploeeServ.getEmploees()).thenReturn(emploee);
        Emploee expected = emploee
                .stream()
                .filter(x -> x.getDepartmentNo().equals(1))
                .min(Comparator.comparingInt(y -> y.getSalary()))
                .get();
        Emploee actual = depServ.salaryMin(1);

        assertEquals(actual, expected);
        verify(emploeeServ, times(1)).getEmploees();
    }

    @Test
    public void salarySum() {
        when(emploeeServ.getEmploees()).thenReturn(emploee);
        int expected = Math.toIntExact(emploee
                .stream()
                .filter(x -> x.getDepartmentNo().equals(1))
                .mapToInt(y -> y.getSalary()).sum());
        int actual = depServ.salarySum(1);
        assertEquals(expected, actual);
        verify(emploeeServ, times(1)).getEmploees();
    }

    @Test
    public void emploeeInDepartment() {
        when(emploeeServ.getEmploees()).thenReturn(emploee);
        List<Emploee> expected = emploee
                .stream()
                .filter(x -> x.getDepartmentNo().equals(1))
                .collect(Collectors.toList());
                //.toList();
        List<Emploee> actual = depServ.employeeInDepartment(1);
        assertEquals(expected, actual);
        verify(emploeeServ, times(1)).getEmploees();
    }

    @Test
    public void allEmploees() {
        when(emploeeServ.getEmploees()).thenReturn(emploee);
        Set<Emploee> expected = emploee;
        Set<Emploee> actual = depServ.allEmployees();
        assertEquals(expected, actual);
        verify(emploeeServ, times(1)).getEmploees();
    }
}