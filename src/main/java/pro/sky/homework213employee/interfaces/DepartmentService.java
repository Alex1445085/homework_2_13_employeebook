package pro.sky.homework213employee.interfaces;

import pro.sky.homework213employee.Emploee;

import java.util.List;
import java.util.Set;
public interface DepartmentService {
    List<Emploee> employeeInDepartment(Integer depId);
    int salarySum(Integer depId);
    Emploee salaryMax(Integer depId);
    Emploee salaryMin(Integer depId);
    Set<Emploee> allEmployees();
}
