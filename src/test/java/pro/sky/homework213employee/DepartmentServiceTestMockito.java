package pro.sky.homework213employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTestMockito {
    Emploee emp1 = new Emploee("Aa", "Bb", 1, 1000);
    Emploee emp2 = new Emploee("Cc", "Dd", 1, 2000);
    Set<Emploee> emploee = new HashSet<>();

    @Mock
    private EmploeeServiceImpl emploeeServ;

    @InjectMocks
    private DepartmentServiceImpl serv;

    @BeforeEach
    void setup() {
        emploee.add(emp1);
        emploee.add(emp2);
    }

    @Test
    public void salaryMax() {
        when(emploeeServ.salaryMax(emploee, 1)).thenReturn(emp2);
        assertEquals(emploeeServ.salaryMax(emploee, 1), emp2);
        verify(emploeeServ, times(1)).salaryMax(emploee, 1);
    }

    @Test
    public void salaryMin() {
        when(emploeeServ.salaryMin(emploee, 1)).thenReturn(emp1);
        assertEquals(emploeeServ.salaryMin(emploee, 1), emp1);
        verify(emploeeServ, times(1)).salaryMin(emploee, 1);
    }

    @Test
    public void salarySum() {
        emploee = Set.of(emp1, emp2);
        when(emploeeServ.salarySum(emploee,1)).thenReturn(3000);
        assertEquals(emploeeServ.salarySum(emploee, 1), 3000);
        verify(emploeeServ, times(1)).salarySum(emploee, 1);
    }
}