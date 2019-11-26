package in.bushsigur.springmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import in.bushsigur.springmybatis.entity.Employee;
import in.bushsigur.springmybatis.util.MyBatisUtil;

@Repository
public class EmployeeMapper {
	public void saveEmployee(Employee employee) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertEmployee",employee);
		session.commit();
		session.close();
	}
	public void updateEmployee(Employee employee) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("updateEmployee",employee);
		session.commit();
		session.close();
	}
	public void deleteEmployee(int employeeId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("deleteEmployee",employeeId);
		session.commit();
		session.close();
	}
	public List<Employee> getAllEmployees(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Employee> employeesList = session.selectList("getAllEmployees");
		session.commit();
		session.close();
		return employeesList;
	}
	public Employee findById(int employeeId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Employee employee = (Employee) session.selectOne("findById", employeeId);
		session.commit();
		session.close();
		return employee;
	}
}
