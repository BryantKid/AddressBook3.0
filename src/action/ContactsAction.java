package action;

import java.util.List;

import entity.Contacts;
import service.ContactsDAO;
import service.impl.ContactsDAOimpl;

public class ContactsAction extends superAction {

	private String key;
	private List<Contacts> list;
	private int id=0;
	private String name;
	private String phone;
	
	private static final long serialVersionUID = 1L;
	public String queryAll()
	{
		ContactsDAO sDao=new ContactsDAOimpl();
		list=sDao.queryAllContacts();
		return SUCCESS;
	}

	public String queryKey() {
		ContactsDAO sDao=new ContactsDAOimpl();
		list = sDao.searchByKey(this.key);
		return SUCCESS;
	}
	//删除操作
	public String delete()
	{
		ContactsDAO sDao=new ContactsDAOimpl();
		sDao.deleteContacts(this.id);  //调用删除方法
		return SUCCESS;
		
		
	}
	//添加学生动作
	public String add()
	{
		System.out.println("add");
		Contacts contacts = new Contacts();
		System.out.println("name"+name);
		System.out.println("phone"+phone);
		contacts.setName(this.name);
		contacts.setPhone(this.phone);
		
		
		contacts.toString();
		ContactsDAO contactsDAO = new ContactsDAOimpl();
		contactsDAO.addContacts(contacts);//使用模型驱动获取从表单提交过来的信息
		return SUCCESS;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Contacts> getList() {
		return list;
	}

	public void setList(List<Contacts> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
