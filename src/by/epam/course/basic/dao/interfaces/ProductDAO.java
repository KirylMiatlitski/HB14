package by.epam.course.basic.dao.interfaces;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.dao.exception.DAOException;

public interface ProductDAO {

		void addSportProduct(SportProduct item) throws DAOException;
		boolean deleteSportProduct(SportProduct item) throws DAOException;
		
}
