package pro.sky.homework213employee.services;

import pro.sky.homework213employee.interfaces.DepartmentService;
import pro.sky.homework213employee.interfaces.EmploeeService;
import org.springframework.stereotype.Service;
import pro.sky.homework213employee.exceptions.DepartmentNotFoundException;
import pro.sky.homework213employee.Emploee;

import java.util.*;

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