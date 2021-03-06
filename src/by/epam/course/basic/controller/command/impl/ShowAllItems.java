package by.epam.course.basic.controller.command.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.factory.ServiceFactory;
import by.epam.course.basic.services.interfaces.AccountingService;

public class ShowAllItems implements Command {

	@Override
	public String execute(String request) {
		String response = "";
		//String[] requstItems=request.split(" ");
		List<SportProduct> list = new ArrayList<>();
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AccountingService service = serviceFactory.getAccountingService();
		try {
			list = service.returnAllProducts();
			for (int i = 0; i < list.size(); i++){
				response = response + list.get(i) + "\n"; 
			}
			
			
		} catch (ServiceException | IllegalArgumentException | NullPointerException e  ) {
			// TODO Auto-generated catch block
			response = "We have found an issue. Check the request.";
		} 
		return response;
	}
	

}
