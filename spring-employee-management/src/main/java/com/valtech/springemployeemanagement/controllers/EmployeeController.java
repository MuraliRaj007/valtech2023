package com.valtech.springemployeemanagement.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.springemployeemanagement.entities.Department;
import com.valtech.springemployeemanagement.models.DepartmentModel;
import com.valtech.springemployeemanagement.models.EmployeeModel;
import com.valtech.springemployeemanagement.services.EmployeeService;

@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	private List<Department> departments;
	private DepartmentModel departmentModel;
	private int currentId;
	
	private List<DepartmentModel> departmentModels;

	@GetMapping("/new")
	public String newEmployee(Model model) {

		model.addAttribute("employee", new EmployeeModel());
		return "employees/new";
	}

	@GetMapping("/edit")
	public String editEmployee(@RequestParam("id") Integer id, Model model) {

		model.addAttribute("employee", new EmployeeModel(employeeService.getEmployeeById(id)));
		return "employees/edit";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") Integer id, Model model) {

		employeeService.deleteEmployee(id);
		return "redirect:list";
	}

	@PostMapping(path = "/save", params = "cancel")
	public String cancelEmployee(Model model) {

		departments = employeeService.getAllDepartments();
		if (!departments.isEmpty()) {
			Department department = departments.get(employeeService.getFirstId() - 1);
			departmentModel = new DepartmentModel(department);
			model.addAttribute("department", departmentModel);
		}

		model.addAttribute("employees", employeeService.getAllEmployees().stream()
				.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
		return "employees/list";
	}

	@PostMapping(path = "/save", params = "submit")
	public String saveEmployee(@ModelAttribute EmployeeModel employeeModel, @RequestParam("submit") String submit,
			Model model) {

		if (submit.equals("Create")) {
			employeeService.createEmployee(employeeModel.getEmployee());
		}
		departments = employeeService.getAllDepartments();
		if (!departments.isEmpty()) {
			Department department = departments.get(employeeService.getFirstId() - 1);
			departmentModel = new DepartmentModel(department);
			model.addAttribute("department", departmentModel);
		}
		model.addAttribute("employees", employeeService.getAllEmployees().stream()
				.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
		return "employees/list";
	}

	@GetMapping("/list")
	public String listEmployee(Model model) {

//		Department department = employeeService.getDepartmentById(employeeService.getFirstId());
//		departmentModel = new DepartmentModel(department);
		
		List<DepartmentModel> departmentModels = employeeService.getAllDepartments().stream()
				.map(department -> new DepartmentModel(department)).collect(Collectors.toList());

		model.addAttribute("departments", departmentModels);
		model.addAttribute("employees", employeeService.getAllEmployees().stream().map(emp -> new EmployeeModel(emp))
				.collect(Collectors.toList()));
		return "employees/list";
	}

	@PostMapping(path = "/list", params = "submit")
	public String listEmployee(@RequestParam("submit") String submit, Model model) {

		 int currentId = departmentModel.getId();

		if (submit.equals("Last")) {
			Department department = employeeService.getDepartmentById(employeeService.getLastId());
			departmentModel = new DepartmentModel(department);
			model.addAttribute("department", departmentModel);
			model.addAttribute("employees", employeeService.getAllEmployeesByDepartment(departmentModel.getId())
					.stream().map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));

		} else if (submit.equals("Previous")) {
			if (currentId != employeeService.getFirstId()) {
				Department department = employeeService.getDepartmentById(employeeService.getPreviousId(currentId));
				departmentModel = new DepartmentModel(department);
				model.addAttribute("department", departmentModel);
				model.addAttribute("employees", employeeService.getAllEmployeesByDepartment(departmentModel.getId())
						.stream().map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));

			} else {
				Department department = employeeService.getDepartmentById(employeeService.getLastId());
				departmentModel = new DepartmentModel(department);
				model.addAttribute("department", departmentModel);
				model.addAttribute("employees", employeeService.getAllEmployeesByDepartment(departmentModel.getId())
						.stream().map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
			}
		} else if (submit.equals("Next")) {
			if (currentId != employeeService.getLastId()) {
				Department department = employeeService.getDepartmentById(employeeService.getNextId(currentId));
				departmentModel = new DepartmentModel(department);
				model.addAttribute("department", departmentModel);
				model.addAttribute("employees", employeeService.getAllEmployeesByDepartment(departmentModel.getId())
						.stream().map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));

			} else {
				Department department = employeeService.getDepartmentById(employeeService.getFirstId());
				departmentModel = new DepartmentModel(department);
				model.addAttribute("department", departmentModel);
				model.addAttribute("employees", employeeService.getAllEmployeesByDepartment(departmentModel.getId())
						.stream().map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
			}
		} else if (submit.equals("First")) {
			
			Department department = employeeService.getDepartmentById(employeeService.getFirstId());
			DepartmentModel departmentModel = new DepartmentModel(department);
			List<DepartmentModel> departmentModels=new ArrayList<DepartmentModel>();
			departmentModels.add(departmentModel);
			model.addAttribute("departments", departmentModels);
			model.addAttribute("employees", employeeService.getAllEmployeesByDepartment(departmentModel.getId())
					.stream().map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
		}
		return "employees/list";
	}

}
