package by.epam.course.basic.services;

import java.util.ArrayList;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.beans.User;
import by.epam.course.basic.dao.exception.DAOException;
import by.epam.course.basic.dao.factory.DAOFactory;
import by.epam.course.basic.dao.interfaces.UserDAO;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.interfaces.ClientService;

public class ClientServiceImp implements ClientService{
	

	@Override
	public String signIn(String name, String pass) throws ServiceException {
		
		if ((name == null) || (pass == null)){
			throw new ServiceException();			
		}
		
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			UserDAO userDAO = daoF.getUserDAO();
			if (userDAO.signin(new User(name, pass))){
				return "The user entered the application";
			} else {
				return "Log on was failed";
			}
		} catch (DAOException e) {
			throw new ServiceException();
		}		
	}

	@Override
	public void registration(String name, String pass) throws ServiceException {
		
		if ((name == null) || (pass == null)){
			throw new ServiceException();			
		}
		
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			UserDAO userDAO = daoF.getUserDAO();
			userDAO.registration(new User(name,pass));
		} catch (DAOException e) {
			throw new ServiceException();
		}	
		
	}

	@Override
	public ArrayList<String> getAllClientProducts(String userName) throws ServiceException {
		
		ArrayList<SportProduct> tempList = null;
		ArrayList<String> result = new ArrayList<>();
		if (userName == null) {
			throw new ServiceException();			
		}
		
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			UserDAO userDAO = daoF.getUserDAO();
			tempList = userDAO.getListOfRentedProducts(new User(userName, null));
			for (SportProduct i : tempList){
				result.add(i.getName());
			}
		} catch (DAOException e) {
			throw new ServiceException();
		}
		
		return result;
	}

	@Override
	public void takeProduct(String userName, String itemName) throws ServiceException {
		
		if (userName == null) {
			throw new ServiceException();			
		}
		if (itemName == null) {
			throw new ServiceException();			
		}
		
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			UserDAO userDAO = daoF.getUserDAO();
			userDAO.TakeSportProduct(new User(userName,null), new SportProduct(itemName,null));
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void takeBackProduct(String itemName) throws ServiceException {
		
		if (itemName == null) {
			throw new ServiceException();			
		}
		
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			UserDAO userDAO = daoF.getUserDAO();
			userDAO.TakeBackSportPruduct(new SportProduct(itemName, null));
		} catch (DAOException e) {
			throw new ServiceException();
		}
		
	}
	

}
