package pro.sky.homework213employee.interfaces;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pro.sky.homework213employee.Emploee;
import java.util.Set;
public interface EmploeeService {
    @PostMapping
    String addEmploee(String name, String secondName, int depId, int salary);
    @DeleteMapping
    String delEmploee(String name, String secondName);
    String findEmploee(String name, String secondName);
    @GetMapping
    Set<Emploee> getEmploees();
}