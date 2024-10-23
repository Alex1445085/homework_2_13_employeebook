package pro.sky.homework213employee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    Set<Emploee> emploees = new HashSet<>();

//    {
//        emploees.add(new Emploee("Ivanov", "Ivan", 1, 86811));
//        emploees.add(new Emploee("Petrov", "Petr", 2, 80000));
//        emploees.add(new Emploee("Ivanov", "Petr", 3, 99100));
//        emploees.add(new Emploee("Kumov", "Ivan", 4, 97600));
//        emploees.add(new Emploee("Gamov", "Egor", 5, 84667));
//        emploees.add(new Emploee("Sizov", "Oleg", 5, 73000));
//        emploees.add(new Emploee("Slikoff", "Mike", 4, 125400));
//        emploees.add(new Emploee("Krotov", "Andr", 3, 95410));
//        emploees.add(new Emploee("Vasin", "Nikolay", 1, 142000));
//        emploees.add(new Emploee("Gorin", "Nikk", 1, 82000));
//    }

    private final EmploeeService serv;
    public DepartmentServiceImpl(EmploeeService serv) { this.serv = serv; }

    {emploees.addAll(Emploee.getSetEmploees());}

    @Override
    public List<Emploee> employeeInDepartment(Integer depId) {
        List<Emploee> result = serv.getListOfEmploe(emploees, depId);
        return Collections.unmodifiableList(result);
    }

    @Override
    public int salarySum(Integer depId) {
        return serv.salarySum(emploees, depId);
    }

    @Override
    public Emploee salaryMax(Integer depId) {
        return serv.salaryMax(emploees, depId);
    }

    @Override
    public Emploee salaryMin(Integer depId) {
        return serv.salaryMin(emploees, depId);
    }

    @Override
    public Map<Integer, List<Emploee>> allEmployees() {
        return serv.allEmploees(emploees);
    }
}
