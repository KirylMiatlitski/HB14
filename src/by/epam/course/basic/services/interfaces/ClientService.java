package by.epam.course.basic.services.interfaces;

import java.util.ArrayList;

import by.epam.course.basic.services.exception.ServiceException;

public interface ClientService {
	String signIn(String name, String pass) throws ServiceException;
	void registration(String name, String pass) throws ServiceException;
	ArrayList<String> getAllClientProducts(String userName) throws ServiceException;
	void takeProduct(String userName, String itemName) throws ServiceException;
	void takeBackProduct(String itemName) throws ServiceException;
}
