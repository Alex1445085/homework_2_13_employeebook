package pro.sky.homework213employee;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmploeeService serv;
    public DepartmentServiceImpl(EmploeeService serv) { this.serv = serv; }

    @Override
    public int salarySum(Integer depId) {
        int result = 0;
        for(Emploee temp : serv.getEmploees()) {
            if (temp.getDepartmentNo() == depId) { result = result + temp.getSalary(); }
        }
        return result;
    }
    @Override
    public Emploee salaryMax(Integer depId) {
        Emploee emploeeInDepartment = serv.getEmploees()
                .stream()
                .filter(x -> x.getDepartmentNo().equals(depId))
                .max(comparing(x -> x.getSalary()))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return emploeeInDepartment;
    }

    @Override
    public Emploee salaryMin(Integer depId) {
//        Predicate<Emploee> predicate = new Predicate<Emploee>() {
//            @Override
//            public boolean test(Emploee x) {
//                return x.getDepartmentNo().equals(depId);
//            }
//        };
//        Predicate<Emploee> predicate1 = x -> x.getDepartmentNo().equals(depId);
//        Consumer<Emploee> consumer = y -> y.setSalary(y.getSalary() + 10000);
//              .peek(consumer)
        Emploee emploeeInDepartment = serv.getEmploees()
                .stream()
                .filter(x -> x.getDepartmentNo().equals(depId))
                .min(comparing(x -> x.getSalary()))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return emploeeInDepartment;
    }

    @Override
    public Set<Emploee> allEmployees() {
        return serv.getEmploees();
    }

    @Override
    public List<Emploee> employeeInDepartment(Integer depId) {
        List<Emploee> temp = new ArrayList<>();
        for (Emploee t : serv.getEmploees()) {
            if (Objects.equals(t.getDepartmentNo(), depId)) {
                temp.add(t);
            }
        }
        return Collections.unmodifiableList(temp);
    }
}