package by.epam.course.basic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.beans.User;
import by.epam.course.basic.dao.exception.DAOException;
import by.epam.course.basic.dao.interfaces.UserDAO;

public class SQLUserDAO implements UserDAO{

	@Override
	public boolean signin(User user) throws DAOException {

		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "SELECT  [ID],[Name],[Password] FROM [JavaCourse].[dbo].[Users] t  where t.Name = ? and t.Password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();

			while (rs.next()) {
				return true;
			}
			return false;
			
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
	public void registration(User user) throws DAOException {
		
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		//ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "INSERT INTO [JavaCourse].[dbo].[Users] ([Name],[Password]) VALUES ( ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
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
	public ArrayList<SportProduct> getListOfRentedProducts(User user) throws DAOException {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<SportProduct> list = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "Select [Name],[Description],[OwnerID],[Status] from [JavaCourse].[dbo].[Products] where OwnerID  in (SELECT [ID] from [JavaCourse].[dbo].[Users] where Name =?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new SportProduct(rs.getString("Name"), rs.getString("Description"),rs.getInt("OwnerID"), rs.getString("Status")));
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
	public void TakeSportProduct(User user, SportProduct item) throws DAOException {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<SportProduct> list = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "UPDATE [dbo].[Products] SET [OwnerID] = (SELECT ID FROM [dbo].[Users] where Name = ?) WHERE Name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, item.getName());
			
			ps.executeUpdate();

			
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
	public void TakeBackSportPruduct(SportProduct item) throws DAOException {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<SportProduct> list = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "UPDATE [dbo].[Products] SET [OwnerID] = -1 WHERE Name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, item.getName());
			
			ps.executeUpdate();

			
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
