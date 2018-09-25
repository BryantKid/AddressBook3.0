package entity;




public class Contacts {

	private int id;
	private String name;	
	private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
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
	public Contacts(int id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public Contacts() {
	}
	@Override
	public String toString() {
		return "Contacts [id=" + id + ", name=" + name +"phone=" + phone + "]";
	}
	
}
