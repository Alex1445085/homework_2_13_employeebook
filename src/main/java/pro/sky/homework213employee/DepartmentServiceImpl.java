package pro.sky.homework213employee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

        Set<String> emploee = new HashSet<>();
        private final EmploeeService serv;
        public DepartmentServiceImpl(EmploeeService serv) { this.serv = serv; }

        @Override
        public List<Emploee> employeeInDepartment(Integer depId) {
            List<Emploee> result = serv.getListOfEmploe(depId);
            return Collections.unmodifiableList(result);
        }
        @Override
        public int salarySum(Integer depId) {
            return serv.salarySum(depId);
        }
        @Override
        public Emploee salaryMax(Integer depId) {
            return serv.salaryMax(depId);
        }
        @Override
        public Emploee salaryMin(Integer depId) {
            return serv.salaryMin(depId);
        }
        @Override
        public Map<Integer, List<Emploee>> allEmployees() {
            return serv.allEmploees();
        }
    }
