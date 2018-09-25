package service;

import java.util.List;
//增删改查接口

import entity.Contacts;

public interface ContactsDAO {

	public List<Contacts> queryAllContacts();
	
	public List<Contacts> searchByKey(String key) ;
	
	public void addContacts(Contacts contacts);
	
	public boolean deleteContacts(int id);
}
