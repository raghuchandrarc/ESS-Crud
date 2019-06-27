package net.codejava.javaee.empdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * EmployeeDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * 
 *
 */
@SuppressFBWarnings("OBL_UNSATISFIED_OBLIGATION_EXCEPTION_EDGE")

public class EmployeeDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public EmployeeDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public boolean insertEmp(Employee emp) throws SQLException {
		String sql = "INSERT INTO emp (empname, empdesignation, location) VALUES (?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, emp.getEmpname());
		statement.setString(2, emp.getEmpdesignation());
		statement.setString(3, emp.getLocation());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	@SuppressFBWarnings("OBL_UNSATISFIED_OBLIGATION_EXCEPTION_EDGE")
	public List<Employee> listAllEmp() throws SQLException {
		List<Employee> listEmp = new ArrayList<>();
		
		String sql = "SELECT * FROM emp";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("emp_id");
			String empname = resultSet.getString("empname");
			String empdesignation = resultSet.getString("empdesignation");
			String location = resultSet.getString("location");
			
			Employee emp = new Employee(id, empname, empdesignation, location);
			listEmp.add(emp);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listEmp;
	}
	
	public boolean deleteEmp(Employee book) throws SQLException {
		String sql = "DELETE FROM emp where emp_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, book.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateEmp(Employee emp) throws SQLException {
		String sql = "UPDATE emp SET empname = ?, empdesignation = ?, location = ?";
		sql += " WHERE emp_id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, emp.getEmpname());
		statement.setString(2, emp.getEmpdesignation());
		statement.setString(3, emp.getLocation());
		statement.setInt(4, emp.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public Employee getEmp(int id) throws SQLException {
		Employee emp = null;
		String sql = "SELECT * FROM emp WHERE emp_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String empname = resultSet.getString("empname");
			String empdesignation = resultSet.getString("empdesignation");
			String location = resultSet.getString("location");
			
			emp = new Employee(id, empname, empdesignation, location);
		}
		
		resultSet.close();
		statement.close();
		
		return emp;
	}
}
