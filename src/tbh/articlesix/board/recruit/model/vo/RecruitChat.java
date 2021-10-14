package tbh.articlesix.board.recruit.model.vo;

import java.sql.Date;

public class RecruitChat {

//	B_N	NUMBER		FK	O
//	M_ID	VARCHAR2	30	FK	O
//	CHAT_TIME	DATE			O
//	CHAT_MESSAGE	VARCHAR2	500		O

	private int b_n;
	private String m_id;
	private Date chat_time;
	private String chat_message;

	public RecruitChat() {

	}

	public RecruitChat(int b_n, String m_id, Date chat_time, String chat_message) {
		super();
		this.b_n = b_n;
		this.m_id = m_id;
		this.chat_time = chat_time;
		this.chat_message = chat_message;
	}

	@Override
	public String toString() {
		return "RecruitChat [b_n=" + b_n + ", m_id=" + m_id + ", chat_time=" + chat_time + ", chat_message="
				+ chat_message + "]";
	}

	public int getB_n() {
		return b_n;
	}

	public void setB_n(int b_n) {
		this.b_n = b_n;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public Date getChat_time() {
		return chat_time;
	}

	public void setChat_time(Date chat_time) {
		this.chat_time = chat_time;
	}

	public String getChat_message() {
		return chat_message;
	}

	public void setChat_message(String chat_message) {
		this.chat_message = chat_message;
	}

}
