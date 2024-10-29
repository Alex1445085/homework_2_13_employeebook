package pro.sky.homework213employee.services;

import pro.sky.homework213employee.interfaces.EmploeeService;
import org.springframework.stereotype.Repository;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import pro.sky.homework213employee.Emploee;
import pro.sky.homework213employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework213employee.exceptions.EmployeeNotExistException;
import pro.sky.homework213employee.exceptions.FirstNameOrLastNameIsEmptyException;

@Repository
public class EmploeeServiceImpl implements EmploeeService {

    private final Set<Emploee> empl = new HashSet<>();
    {
        empl.add(new Emploee("Ivanov", "Ivan", 1, 86811));
        empl.add(new Emploee("Petrov", "Petr", 2, 80000));
        empl.add(new Emploee("Ivanov", "Petr", 3, 99100));
        empl.add(new Emploee("Kumov", "Ivan", 4, 97600));
        empl.add(new Emploee("Gamov", "Egor", 5, 84667));
        empl.add(new Emploee("Sizov", "Oleg", 5, 73000));
        empl.add(new Emploee("Slikoff", "Mike", 4, 125400));
        empl.add(new Emploee("Krotov", "Andr", 3, 95410));
        empl.add(new Emploee("Vasin", "Nikolay", 1, 142000));
        empl.add(new Emploee("Gorin", "Nikk", 1, 82000));
    }

    public Map<String, Emploee> emploees = new HashMap<>();
    {for (Emploee temp : empl) {
        emploees.put(temp.makeKey(temp), temp);
    }}
    @Override
    public Set<Emploee> getEmploees() {
        return Collections.unmodifiableSet(empl);
    }

    @Override
    public String addEmploee(String name, String secondName, int depId, int salary) {
        if (name.isEmpty() || secondName.isEmpty()) {
            throw new FirstNameOrLastNameIsEmptyException("e");
        }
        name = StringUtils.capitalize(name);
        secondName = StringUtils.capitalize(secondName);
        Emploee temp = new Emploee(name, secondName, depId, salary);
        String word = "";
        if (emploees.containsKey(temp.makeKey(temp))) {
            throw new EmployeeAlreadyAddedException("e");
        } else {
            empl.add(temp);
            emploees.put(temp.makeKey(temp), temp);
            word = "Success, сотрудник " + temp.toString() + ", id = " + temp.getDepartmentNo() + " добавлен.";
        }
        return word;
    }

    @Override
    public String findEmploee(String name, String secondName) {
        Emploee e = new Emploee(name, secondName, 1, 1);
        String temp = e.makeKey(e);
        if (!emploees.containsKey(temp)) {
            throw new EmployeeNotExistException("ex");
        } else { return "Сотрудник " + name + " " + secondName + ", id = "
                + emploees.get(temp).getDepartmentNo() + " находится в штате."; }
    }

    @Override
    public String delEmploee(String name, String secondName) {
        Emploee e = new Emploee(name, secondName, 0, 0);
        String temp = e.makeKey(e);
        if (!emploees.containsKey(temp)) {
            throw new EmployeeNotExistException("e");
        } else {
            emploees.remove(temp);
            return "Сотрудник " + temp + " удален из списка.";
        }
    }
}