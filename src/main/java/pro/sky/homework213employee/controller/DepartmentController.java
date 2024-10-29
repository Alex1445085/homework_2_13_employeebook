package pro.sky.homework213employee.controller;

import pro.sky.homework213employee.exceptions.BadRequestException;
import pro.sky.homework213employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework213employee.exceptions.EmployeeNotExistException;
import pro.sky.homework213employee.exceptions.FirstNameOrLastNameIsEmptyException;
import pro.sky.homework213employee.interfaces.DepartmentService;
import pro.sky.homework213employee.interfaces.EmploeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.Set;
@RestController
@RequestMapping("/department")
public class DepartmentController {

    public final EmploeeService emploeeServ;
    public final DepartmentService serv;
    public DepartmentController(EmploeeService emploeeServ, DepartmentService serv) {
        this.emploeeServ = emploeeServ;
        this.serv = serv; }

    @GetMapping("/{depId}/employees")
    public String employeeInDepartment(@PathVariable Integer depId) {
        return "List of employees in dep# " + depId + " = " + serv.employeeInDepartment(depId).toString();
    }
    @GetMapping("/{depId}/salary/sum")
    public String salarySum(@PathVariable Integer depId) {
        return "Sum of salary in dep# " + depId + " = " + serv.salarySum(depId);
    }
    @GetMapping("/{depId}/salary/max")
    public String salaryMax(@PathVariable Integer depId) {
        return "Max salary in dep# " + depId + " = " + serv.salaryMax(depId).toString();
    }
    @GetMapping("/{depId}/salary/min")
    public String salaryMin(@PathVariable Integer depId) {
        return "Min salary in dep# " + depId + " = " + serv.salaryMin(depId).toString();
    }
    @GetMapping("/employees")
    public String allEmployees() {
        return "All employees = " + serv.allEmployees().toString();
    }

    @GetMapping("/add")
    public String addPerson(@RequestParam("firstName") String Name,
                            @RequestParam("lastName") String secondName,
                            @RequestParam("depId") int depId,
                            @RequestParam("salary") int salary) {
        try{
            return emploeeServ.addEmploee(Name, secondName, depId, salary);
        } catch (EmployeeAlreadyAddedException e) {
            return "Такой сотрудник уже существует.";
        } catch (FirstNameOrLastNameIsEmptyException e) {
            return "firstName or lastName is empty";
        } catch (BadRequestException e) {
            return "400BadRequestException";
        }
    }
    @GetMapping("/del")
    public String delPerson(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        try {
            return emploeeServ.delEmploee(firstName, lastName);
        } catch (EmployeeNotExistException e) {
            return "Такого сотрудника в штате нет.";
        }
    }
    @GetMapping("/find")
    public String findPerson(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName) {
        try {
            return emploeeServ.findEmploee(firstName, lastName);
        } catch (EmployeeNotExistException e) {
            return "Такого сотрудника в штате нет.";
        }
    }
    @GetMapping("/list")
    public Set listEmploee(){
        return emploeeServ.getEmploees();
    }
}
