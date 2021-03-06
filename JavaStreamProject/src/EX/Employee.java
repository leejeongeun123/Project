package EX;

import java.time.LocalDate;

public class Employee {
		int employeeId;
		String firstName;
		String lastName;
		String email;
		LocalDate hireDate;
		String jobid;
		int salary;
		
		public Employee() {};
		
		public Employee(int employeeId, String firstName, String lastName, String email, LocalDate hireDate,
				String jobid, int salary) {
			super();
			this.employeeId = employeeId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.hireDate = hireDate;
			this.jobid = jobid;
			this.salary = salary;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public LocalDate getHireDate() {
			return hireDate;
		}

		public void setHireDate(LocalDate hireDate) {
			this.hireDate = hireDate;
		}

		public String getJobid() {
			return jobid;
		}

		public void setJobid(String jobid) {
			this.jobid = jobid;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}
		
}
