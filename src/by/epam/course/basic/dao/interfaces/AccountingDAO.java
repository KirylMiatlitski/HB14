package by.epam.course.basic.dao.interfaces;

import java.util.List;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.dao.exception.DAOException;

public interface AccountingDAO {
	List<String> returnAllUsers() throws DAOException;
	List<SportProduct> returnAllProducts() throws DAOException;
}
