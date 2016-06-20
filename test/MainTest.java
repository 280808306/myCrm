import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.Department;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.query.EmployeeQuery;
import cn.wudi.crm.service.IDepartmentService;
import cn.wudi.crm.service.IEmployeeService;
import cn.wudi.crm.test.BaseSpringTest;

public class MainTest extends BaseSpringTest{
	@Autowired
	IEmployeeService employeeService;
	@Autowired
	IDepartmentService departmentService;
	@Test
	public void test() {
		Employee employee = new Employee();
		Department department = new Department();
		department.setName("--------------");
		employee.setDept(department);
		employee.setUsername("1111111");
		employee.setRealName("王霸胆");
		employee.setPassword("123");
		employee.setTel("123");
		//employeeService.save(employee);
		employee.setDept(department);
		employee.setId(2L);
		employee.setUsername("1111111");
		employee.setRealName("蛋霸王");
		employee.setPassword("123");
		employee.setTel("123");
		for (int i = 0; i < 30; i++) {
			
			employeeService.save(employee);
		}

	}
	@Test
	public void test1() {
		Employee employee = employeeService.getEmployeeByUsername("王尼玛");
		System.out.println(employee);
	}

}
