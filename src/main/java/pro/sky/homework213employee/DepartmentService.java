package pro.sky.homework213employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Emploee> employeeInDepartment(Integer depId);
    int salarySum(Integer depId);
    Emploee salaryMax(Integer depId);
    Emploee salaryMin(Integer depId);
    Map<Integer, List<Emploee>> allEmployees();
}
