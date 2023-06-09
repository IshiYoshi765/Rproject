package dto;

public class user {
	private int id;
	private String name;
	private String mail;
	private String tel; 
	private String salt;
	private String password;
	private String hashedPassword;
	
	public user(int id,String name,String mail,String tel,String salt,String password,String hashedPassword) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.tel = tel;
		this.salt = salt;
		this.password = password;
		this.hashedPassword = hashedPassword;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	
}