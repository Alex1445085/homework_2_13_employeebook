package pro.sky.homework213employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EmploeeService {
    List<Emploee> getListOfEmploe(Set<Emploee> emploees, Integer depId);
    int salarySum(Set<Emploee> emploees, Integer depId);
    Emploee salaryMax(Set<Emploee> emploees, Integer depId);
    Emploee salaryMin(Set<Emploee> emploees, Integer depId);
    Map<Integer, List<Emploee>> allEmploees(Set<Emploee> emploees);

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
