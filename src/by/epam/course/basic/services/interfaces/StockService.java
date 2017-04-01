package by.epam.course.basic.services.interfaces;

import by.epam.course.basic.services.exception.ServiceException;

public interface StockService {
	void addSportProduct(String itemName, String itemDescription) throws ServiceException;
	boolean deleteSportProduct(String itemName, String itemDescription) throws ServiceException;
}
