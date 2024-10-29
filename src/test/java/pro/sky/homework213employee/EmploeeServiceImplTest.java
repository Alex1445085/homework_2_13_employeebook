package pro.sky.homework213employee;

import pro.sky.homework213employee.exceptions.EmployeeNotExistException;
import pro.sky.homework213employee.exceptions.FirstNameOrLastNameIsEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.homework213employee.services.EmploeeServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

public class EmploeeServiceImplTest {
    private EmploeeServiceImpl emplServ = new EmploeeServiceImpl();

    Emploee empl = new Emploee("Ee", "Ff", 1, 3000);

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void addEmploee() {
        String expected = "Success, сотрудник " + empl.toString() + ", id = " + empl.getDepartmentNo() + " добавлен.";
        String actual = emplServ.addEmploee(empl.getName(), empl.getSecondName(), 1, 3000);
        assertEquals(expected, actual);
        assertThrows(FirstNameOrLastNameIsEmptyException.class,
                () -> emplServ.addEmploee("", "", 1, 0),
                "FirstNameOrLastNameException");
    }

    @Test
    public void delEmploee() {
        assertThrows(EmployeeNotExistException.class,
                () -> emplServ.delEmploee("Aa", "Bb"),
                "EmployeeNotExistException");
    }

    @Test
    public void findEmploee() {
        Emploee emp = new Emploee("Ivanov", "Ivan", 1, 1);
        String expected = "Сотрудник " + emp.getName() + " " + emp.getSecondName()
                + ", id = " + emp.getDepartmentNo() + " находится в штате.";
        String actual = emplServ.findEmploee(emp.getName(), emp.getSecondName());
        assertEquals(expected, actual);
        assertThrows(EmployeeNotExistException.class,
                () -> emplServ.findEmploee("Aa", "Bb"),
                "EmployeeNotExistException");
    }
}
