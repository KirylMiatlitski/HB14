package by.epam.course.basic.dao.interfaces;


import java.util.ArrayList;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.beans.User;
import by.epam.course.basic.dao.exception.DAOException;

public interface UserDAO {
	
	boolean signin(User user) throws DAOException;
	void registration(User user) throws DAOException;
	ArrayList<SportProduct> getListOfRentedProducts(User user) throws DAOException;
	void TakeSportProduct(User user,SportProduct item) throws DAOException;
	void TakeBackSportPruduct(SportProduct item) throws DAOException;
}
