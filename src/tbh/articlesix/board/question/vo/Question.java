package tbh.articlesix.board.question.vo;

import java.sql.Date;

public class Question {
	private int bq_n;
	private String m_nick;
	private String bq_title;
	private String bq_content;
	private Date bq_timestamp;
	private int bref;
	private int breLevel;
	private int breStep;
	
	public Question() {
		
	}
	
	public Question(String bq_title, String bq_content, int bq_n) {
		super();
		this.bq_title = bq_title;
		this.bq_content = bq_content;
		this.bq_n = bq_n;
	}
	
	public Question(String bq_title, String m_nick, String bq_content) {
		super();
		this.bq_title = bq_title;
		this.m_nick = m_nick;
		this.bq_content = bq_content;
	}
	
	public Question(int bq_n, String bq_title, String bq_content, String m_nick, int bref, int breLevel, int breStep) {
		super();
		this.bq_n = bq_n;
		this.bq_title = bq_title;
		this.bq_content = bq_content;
		this.m_nick = m_nick;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}
	
	@Override
	public String toString() {
		return "Question [bq_n=" + bq_n + ", m_nick=" + m_nick + ", bq_title=" + bq_title + ", bq_content=" + bq_content
				+ ", bq_timestamp=" + bq_timestamp + ", bref=" + bref + ", breLevel=" + breLevel + ", breStep="
				+ breStep + "]";
	}

	public int getBq_n() {
		return bq_n;
	}

	public void setBq_n(int bq_n) {
		this.bq_n = bq_n;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
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

	public int getBref() {
		return bref;
	}

	public void setBref(int bref) {
		this.bref = bref;
	}

	public int getBreLevel() {
		return breLevel;
	}

	public void setBreLevel(int breLevel) {
		this.breLevel = breLevel;
	}

	public int getBreStep() {
		return breStep;
	}

	public void setBreStep(int breStep) {
		this.breStep = breStep;
	}
	
	
}
