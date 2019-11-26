package in.bushsigur.springmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.bushsigur.springmybatis.dao.EmployeeMapper;
import in.bushsigur.springmybatis.entity.Employee;

@Controller 
public class EmployeeController {

	@Autowired
	EmployeeMapper mapper;
	
	@RequestMapping("/")
	public ModelAndView idnex() {
		ModelAndView mav = new ModelAndView("list-employees");
		mav.addObject("listemployees",mapper.getAllEmployees());
		return mav;
	}
	@RequestMapping("/showFormAddEmployee")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("add-employee");
		mav.addObject("employee",new Employee());
		return mav;
	}
	@RequestMapping("/saveProcess")
	public String saveProcess(@ModelAttribute("employee") Employee employee) {
		mapper.saveEmployee(employee);
		return "redirect:/";
	}
	@RequestMapping("/deleteemployee")
	public String deleteemployee(@RequestParam("employeeId") int employeeId) {
		mapper.deleteEmployee(employeeId);
		return "redirect:/";
	}
	@RequestMapping("/editemployee")
	public ModelAndView editEmployee(@RequestParam("employeeId") int employeeId) {
		ModelAndView mav = new ModelAndView("add-employee");
		Employee employee = mapper.findById(employeeId);
		mav.addObject("employee",employee);
		return mav;
	}
}
