package by.epam.course.basic.services;

import java.util.List;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.dao.exception.DAOException;
import by.epam.course.basic.dao.factory.DAOFactory;
import by.epam.course.basic.dao.interfaces.AccountingDAO;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.interfaces.AccountingService;

public class AccountingServiceImpl implements AccountingService {

	@Override
	public List<String> returnAllUsers() throws ServiceException {
		
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			AccountingDAO accountingDAO = daoF.getAccountingDAO();
			return accountingDAO.returnAllUsers();
		} catch (DAOException e) {
			throw new ServiceException();
		}	
	}

	@Override
	public List<SportProduct> returnAllProducts() throws ServiceException {
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			AccountingDAO accountingDAO = daoF.getAccountingDAO();
			return accountingDAO.returnAllProducts();
		} catch (DAOException e) {
			throw new ServiceException();
		}	
	}

}
