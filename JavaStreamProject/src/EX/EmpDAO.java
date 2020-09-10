package EX;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.Employee;

public class EmpDAO {
	Connection conn = ConnectDB.getDB();
	List<Employee> list = new ArrayList<>();
	public List<Employee> getEmpList() {
		String sql = "select employee_id, first_name, last_name, email, hire_date, job_id, salary"
					+"\n" + "from employees";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt("employee_id"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setEmail(rs.getString("email"));
				e.setHireDate(rs.getDate("hire_date").toLocalDate());
				e.setJobid(rs.getString("job_id"));
				e.setSalary(rs.getInt("salary"));
				list.add(e);
				
				
				
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
	
	}
	

}
