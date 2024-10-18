package pro.sky.homework213employee;

import java.util.List;
import java.util.Map;

public interface EmploeeService {
    List<Emploee> getListOfEmploe(Integer depId);
    int salarySum(Integer depId);
    Emploee salaryMax(Integer depId);
    Emploee salaryMin(Integer depId);
    Map<Integer, List<Emploee>> allEmploees();

//    Emploee salaryMax(Integer salary);
//    Emploee salaryMin(Integer salary);
//    Map<Integer, List<Emploee>> findEmploees(Integer depId);
//    Map<Integer, List<Emploee>> eploeesInDepartment(Integer depId);
//    Map<Integer, List<Emploee>> allEmploees();
//    Map<Integer, List<Emploee>> collectio();

//    Map<String, Emploee> emploee(Integer depId);
//    Emploee maxSalary(Integer salary);
//    Emploee minSalary(Integer salary);
//    Map<Integer, List<Emploee>> findEmploees(Integer depId);
//    Map<Integer, List<Emploee>> eploeesInDepartment(Integer depId);
//    Map<Integer, List<Emploee>> allEmploees();
//    Map<String, Emploee> collectio();
}
