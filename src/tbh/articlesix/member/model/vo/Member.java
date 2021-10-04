package tbh.articlesix.member.model.vo;

import java.sql.Date;

//1 m_id : String
//2 m_pw : String
//3 m_auth : Char
//4 m_name : String
//5 m_nick : String
//6 m_birth : Date
//7 m_gender : Char
//8 m_phone : String
//9 m_email : String
//10 m_address : String
//11 m_address_detail : String
//12 m_createDate : Date
//13 m_deleteDate : Date

public class Member {
	private String m_id;
	private String m_pw;
	private char m_auth;
	private String m_name;
	private String m_nick;
	private Date m_birth;
	private char m_gender;
	private String m_phone;
	private String m_email;
	private String m_address;
	private String m_address_detail;
	private Date m_createDate;
	private Date m_deleteDate;
	
	public Member() {
		
	}

	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_pw=" + m_pw + ", m_auth=" + m_auth + ", m_name=" + m_name + ", m_nick="
				+ m_nick + ", m_birth=" + m_birth + ", m_gender=" + m_gender + ", m_phone=" + m_phone + ", m_email="
				+ m_email + ", m_address=" + m_address + ", m_address_detail=" + m_address_detail + ", m_createDate="
				+ m_createDate + ", m_deleteDate=" + m_deleteDate + "]";
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

	public Date getM_birth() {
		return m_birth;
	}

	public void setM_birth(Date m_birth) {
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

	public Date getM_createDate() {
		return m_createDate;
	}

	public void setM_createDate(Date m_createDate) {
		this.m_createDate = m_createDate;
	}

	public Date getM_deleteDate() {
		return m_deleteDate;
	}

	public void setM_deleteDate(Date m_deleteDate) {
		this.m_deleteDate = m_deleteDate;
	}
}
