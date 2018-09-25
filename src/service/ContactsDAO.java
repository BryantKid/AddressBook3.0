package service;

import java.util.List;
//��ɾ�Ĳ�ӿ�

import entity.Contacts;

public interface ContactsDAO {

	public List<Contacts> queryAllContacts();
	
	public List<Contacts> searchByKey(String key) ;
	
	public void addContacts(Contacts contacts);
	
	public boolean deleteContacts(int id);
}
