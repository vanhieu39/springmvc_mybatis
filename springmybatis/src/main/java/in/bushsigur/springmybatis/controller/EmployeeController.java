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
}
