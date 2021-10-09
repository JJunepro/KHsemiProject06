package tbh.articlesix.member.model.vo;


//1 m_id : String
//2 m_pw : String
//3 m_auth : Char
//4 m_name : String
//5 m_nick : String
//6 m_birth : String
//7 m_gender : Char
//8 m_phone : String
//9 m_email : String
//10 m_address : String
//11 m_address_detail : String
//12 m_createDate : String
//13 m_deleteDate : String

public class Member {
	private String m_id;
	private String m_pw;
	private char m_auth;
	private String m_name;
	private String m_nick;
	private String m_birth;
	private char m_gender;
	private String m_phone;
	private String m_email;
	private String m_address;
	private String m_address_detail;
	private double m_degree;
	private String m_createDate;
	private String m_deleteDate;
	
	public Member() {	
	}
	
	public Member(String m_id, String m_pw, char m_auth, String m_name, String m_nick, String m_birth, char m_gender,
			String m_phone, String m_email, String m_address, String m_address_detail, double m_degree,
			String m_createDate, String m_deleteDate) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_auth = m_auth;
		this.m_name = m_name;
		this.m_nick = m_nick;
		this.m_birth = m_birth;
		this.m_gender = m_gender;
		this.m_phone = m_phone;
		this.m_email = m_email;
		this.m_address = m_address;
		this.m_address_detail = m_address_detail;
		this.m_degree = m_degree;
		this.m_createDate = m_createDate;
		this.m_deleteDate = m_deleteDate;
	}
	
	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_pw=" + m_pw + ", m_auth=" + m_auth + ", m_name=" + m_name + ", m_nick="
				+ m_nick + ", m_birth=" + m_birth + ", m_gender=" + m_gender + ", m_phone=" + m_phone + ", m_email="
				+ m_email + ", m_address=" + m_address + ", m_address_detail=" + m_address_detail + ", m_degree="
				+ m_degree + ", m_createDate=" + m_createDate + ", m_deleteDate=" + m_deleteDate + "]";
	}


	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public char getM_auth() {
		return m_auth;
	}

	public void setM_auth(char m_auth) {
		this.m_auth = m_auth;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	public String getM_birth() {
		return m_birth;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public char getM_gender() {
		return m_gender;
	}

	public void setM_gender(char m_gender) {
		this.m_gender = m_gender;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public String getM_address_detail() {
		return m_address_detail;
	}

	public void setM_address_detail(String m_address_detail) {
		this.m_address_detail = m_address_detail;
	}

	public double getM_degree() {
		return m_degree;
	}


	public void setM_degree(double m_degree) {
		this.m_degree = m_degree;
	}


	public String getM_createDate() {
		return m_createDate;
	}

	public void setM_createDate(String m_createDate) {
		this.m_createDate = m_createDate;
	}

	public String getM_deleteDate() {
		return m_deleteDate;
	}

	public void setM_deleteDate(String m_deleteDate) {
		this.m_deleteDate = m_deleteDate;
	}
}
