package by.epam.course.basic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.dao.exception.DAOException;
import by.epam.course.basic.dao.interfaces.ProductDAO;

public class SQLProductDAO implements ProductDAO {

	@Override
	public void addSportProduct(SportProduct item) throws DAOException {
		
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "INSERT INTO [dbo].[Products] ([Name],[Description],[OwnerID],[Status]) VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setString(2, item.getDesctiption());
			ps.setInt(3, item.getOwner_ID());
			ps.setString(4, item.getStatus().toString());
			ps.executeUpdate();

			
		} catch (ClassNotFoundException e) {
			throw new DAOException();
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
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
	public boolean deleteSportProduct(SportProduct item) throws DAOException {

		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "DELETE FROM [dbo].[Products] WHERE [NAME]= ? and [Description] = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setString(2, item.getDesctiption());		
			count = ps.executeUpdate();
			if (count > 0){
				return true;
			} else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			throw new DAOException();
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
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
