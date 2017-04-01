package by.epam.course.basic.beans;

import java.util.ArrayList;

public class User {
	private String name;
	private String password;
	
	ArrayList<SportProduct> goods;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
		this.goods = new ArrayList<>();
	}


	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean addProduct(SportProduct item){
		return goods.add(item);
	}
	
	public boolean deleteProduct(SportProduct item){
		return goods.remove(item);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		for (int i = 0; i < goods.size(); i++){
			result = result + goods.get(i).hashCode();
		}
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		
		return true;
	}


	@Override
	public String toString() {
		return "User: " + name;
	}

	
	

	
}
