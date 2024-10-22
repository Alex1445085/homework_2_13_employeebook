package pro.sky.homework213employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;

public class EmploeeServiceImplTest {
    private EmploeeServiceImpl serv = new EmploeeServiceImpl();
    Set<Emploee> emploees = new HashSet<>();
    Emploee emp1;
    Emploee emp2;

    @BeforeEach
    public void setUp() {
        emp1 = new Emploee("Aaa", "Bbb", 1, 1000);
        emp2 = new Emploee("Ccc", "Ddd", 1, 2000);
        emploees.add(emp1);
        emploees.add(emp2);
    }

    @Test
    @DisplayName("Correct sum")
    public void salarySum() {
        int expected = emp1.getSalary() + emp2.getSalary();
        int actual = serv.salarySum(emploees, emp1.getDepartmentNo());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Correct max")
    public void salaryMax() {
        int expected;
        if (emp1.getSalary() > emp2.getSalary()) {
            expected = emp1.getSalary();
        } else { expected = emp2.getSalary(); }
        int actual = serv.salaryMax(emploees, emp1.getDepartmentNo()).getSalary();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Correct max")
    public void salaryMin() {
        int expected;
        if (emp1.getSalary() > emp2.getSalary()) {
            expected = emp2.getSalary();
        } else { expected = emp1.getSalary(); }
        int actual = serv.salaryMin(emploees, emp1.getDepartmentNo()).getSalary();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Correct getListOfEmploe")
    public void getListOfEmploe() {
        List<Emploee> actual = new ArrayList<>(List.of(emp2, emp1));
        List<Emploee> expected = serv.getListOfEmploe(emploees, emp1.getDepartmentNo());
        assertTrue(expected.contains(emp1));
        assertTrue(expected.contains(emp2));
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Correct allEmploees")
    public void allEmploees() {
        Emploee emp3 = new Emploee("Eee", "Fff", 2, 3000);
        Map<Integer, List<Emploee>> actual = new HashMap<>();
        List<Emploee> listOfEmpl = new ArrayList<>();
        listOfEmpl.add(emp2);
        listOfEmpl.add(emp1);
        actual.put(1, listOfEmpl);
        listOfEmpl = new ArrayList<>();
        listOfEmpl.add(emp3);
        actual.put(2, listOfEmpl);
        emploees.add(emp3);
        Map<Integer, List<Emploee>> expected = serv.allEmploees(emploees);
        assertEquals(actual, expected);
    }
}
