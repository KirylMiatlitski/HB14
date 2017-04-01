package by.epam.course.basic.services;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.dao.exception.DAOException;
import by.epam.course.basic.dao.factory.DAOFactory;
import by.epam.course.basic.dao.interfaces.ProductDAO;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.interfaces.StockService;

public class StockServiceImpl implements StockService {

	@Override
	public void addSportProduct(String itemName, String itemDescription) throws ServiceException {
		if ((itemName == null) || (itemDescription == null)){
			throw new ServiceException();			
		}
		
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			ProductDAO productDAO = daoF.getProductDAO();
			productDAO.addSportProduct(new SportProduct(itemName, itemDescription));			
		} catch (DAOException e) {
			throw new ServiceException();
		}				
	}

	@Override
	public boolean deleteSportProduct(String itemName, String itemDescription) throws ServiceException {
		if ((itemName == null) || (itemDescription == null)){
			throw new ServiceException();			
		}
		
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			ProductDAO productDAO = daoF.getProductDAO();
			return productDAO.deleteSportProduct(new SportProduct(itemName, itemDescription));		
			
		} catch (DAOException e) {
			throw new ServiceException();
		}		
		
	}

}
