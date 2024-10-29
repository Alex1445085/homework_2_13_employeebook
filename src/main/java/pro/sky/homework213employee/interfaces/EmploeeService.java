package pro.sky.homework213employee.interfaces;

import pro.sky.homework213employee.Emploee;
import java.util.Set;
public interface EmploeeService {
    String addEmploee(String name, String secondName, int depId, int salary);
    String delEmploee(String name, String secondName);
    String findEmploee(String name, String secondName);
    Set<Emploee> getEmploees();
}