package by.epam.course.basic.main;

import by.epam.course.basic.controller.Controller;

/**
 * @author Kiryl_Miatlitski
 * 
 * Date: 19 March 2017
 * 
 * Task: ѕредметна€ область: ћагазин проката спортивных товаров
 * Ќапишите приложение, позвол€ющее магазину, предоставл€ющему спортивные товары в прокат вести учет.
 */

public class Task1 {

	public static void main(String[] args) {
		
		
		//уровень view не делал
		// команды
		/*ADD_ITEM, 
		REGISTRATION,
		REMOVE_ITEM,
		RETURN_ITEM,
		SHOW_ALL_ITEM,
		SHOW_ALL_USERS,
		SHOW_CLIENT_PRODUCTS,
		SIGN_IN,
		TAKE_ITEM,
		WRONG_REQUEST
		*/
		Controller ctrl = new Controller();
		
		System.out.println(ctrl.executeTask("Add_item Item1 descr1"));
		System.out.println(ctrl.executeTask("Add_item Item2 descr2"));
		System.out.println(ctrl.executeTask("Add_item Item3 descr3"));
		System.out.println(ctrl.executeTask("Sign_in Kiryl 123"));
		System.out.println(ctrl.executeTask("Show_all_item_____-"));
		System.out.println(ctrl.executeTask("Show_all_item"));
		System.out.println(ctrl.executeTask("Show_All_USERS"));
		
		System.out.println(ctrl.executeTask("TAKE_ITEM Kiryl Item1"));
		System.out.println(ctrl.executeTask("SHOW_CLIENT_PRODUCTS Kiryl"));
		System.out.println(ctrl.executeTask("REMOVE_ITEM item3 descr3"));
		System.out.println(ctrl.executeTask("REGISTRATION User4 Pass4"));
		System.out.println(ctrl.executeTask("Show_All_USERS"));
	}

}
