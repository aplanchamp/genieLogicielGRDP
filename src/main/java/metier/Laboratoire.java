package metier;

public class Laboratoire {
	
	int telephone;
	String name, mail, password;

	public Laboratoire(int telephone, String name, String mail, String password) {
		super();
		this.telephone = telephone;
		this.name = name;
		this.mail = mail;
		this.password = password;
	}

	
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
