package by.epam.course.basic.services.interfaces;

import java.util.List;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.services.exception.ServiceException;

public interface AccountingService {
	List<String> returnAllUsers() throws ServiceException;
	List<SportProduct> returnAllProducts() throws ServiceException;
}
