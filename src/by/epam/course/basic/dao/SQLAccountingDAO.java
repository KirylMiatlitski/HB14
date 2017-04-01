package by.epam.course.basic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.dao.exception.DAOException;
import by.epam.course.basic.dao.interfaces.AccountingDAO;

public class SQLAccountingDAO implements AccountingDAO{

	@Override
	public List<String> returnAllUsers() throws DAOException {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "SELECT [Name] FROM [JavaCourse].[dbo].[Users]";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString("Name"));
			}
			return list;
			
		} catch (ClassNotFoundException e) {
			throw new DAOException();
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException();
			}
		}
	}

	@Override
	public List<SportProduct> returnAllProducts() throws DAOException {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<SportProduct> list = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "SELECT [Name],[Description],[OwnerID],[Status] FROM [JavaCourse].[dbo].[Products]";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				list.add(new SportProduct(rs.getString("Name"), rs.getString("Description") , rs.getInt("OwnerID"), rs.getString("Status")));
			}
			return list;
			
		} catch (ClassNotFoundException e) {
			throw new DAOException();
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException();
			}
		}
	}
	
}
