package tbh.articlesix.board.question.vo;

import java.sql.Date;

public class Question {
	private int bq_n;
	private String m_id;
	private String bq_title;
	private String bq_content;
	private Date bq_timestamp;
	
	// 질문
	public Question() {
		
	}
	
	public Question(String bq_title, String bq_content, int bq_n) {
		super();
		this.bq_title = bq_title;
		this.bq_content = bq_content;
		this.bq_n = bq_n;
	}
	
	public Question(String bq_title, String m_id, String bq_content) {
		super();
		this.bq_title = bq_title;
		this.m_id = m_id;
		this.bq_content = bq_content;
	}
	
	@Override
	public String toString() {
		return "Question [bq_n=" + bq_n + ", m_id=" + m_id + ", bq_title=" + bq_title + ", bq_content=" + bq_content
				+ ", bq_timestamp=" + bq_timestamp + "]";
	}

	public int getBq_n() {
		return bq_n;
	}

	public void setBq_n(int bq_n) {
		this.bq_n = bq_n;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getBq_title() {
		return bq_title;
	}

	public void setBq_title(String bq_title) {
		this.bq_title = bq_title;
	}

	public String getBq_content() {
		return bq_content;
	}

	public void setBq_content(String bq_content) {
		this.bq_content = bq_content;
	}

	public Date getBq_timestamp() {
		return bq_timestamp;
	}

	public void setBq_timestamp(Date bq_timestamp) {
		this.bq_timestamp = bq_timestamp;
	}
	
}
