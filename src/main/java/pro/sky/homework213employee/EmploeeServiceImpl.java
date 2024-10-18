package pro.sky.homework213employee;

import org.springframework.stereotype.Repository;
import java.util.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Repository
public class EmploeeServiceImpl implements EmploeeService {
    Set<Emploee> emploees = new HashSet<>();

    {
        emploees.add(new Emploee("Ivanov", "Ivan", 1, 86811));
        emploees.add(new Emploee("Petrov", "Petr", 2, 80000));
        emploees.add(new Emploee("Ivanov", "Petr", 3, 99100));
        emploees.add(new Emploee("Kumov", "Ivan", 4, 97600));
        emploees.add(new Emploee("Gamov", "Egor", 5, 84667));
        emploees.add(new Emploee("Sizov", "Oleg", 5, 73000));
        emploees.add(new Emploee("Slikoff", "Mike", 4, 125400));
        emploees.add(new Emploee("Krotov", "Andr", 3, 95410));
        emploees.add(new Emploee("Vasin", "Nikolay", 1, 142000));
        emploees.add(new Emploee("Gorin", "Nikk", 1, 82000));
    }

    @Override
    public List<Emploee> getListOfEmploe(Integer depId) {
        List<Emploee> emplo = emploees
                .stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .toList();
        return emplo;
    }

    @Override
    public int salarySum(Integer depId) {
        int sum = 0;
        for (Emploee temp : emploees) {
            if (temp.getDepartmentNo() == depId) {
                sum = sum + temp.getSalary();
            }
        }
        return sum;
    }

    @Override
    public Emploee salaryMax(Integer depId) {
        Emploee emploeeInDepartment = emploees
                .stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .max(comparing(Emploee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return emploeeInDepartment;
    }

    @Override
    public Emploee salaryMin(Integer depId) {
        Emploee emploeeInDepartment = emploees
                .stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .min(comparing(Emploee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return emploeeInDepartment;
    }

    @Override
    public Map<Integer, List<Emploee>> allEmploees() {
        Map<Integer, List<Emploee>> temp = emploees
                .stream()
                .collect(groupingBy(Emploee::getDepartmentNo));
        return Collections.unmodifiableMap(temp);
    }
}