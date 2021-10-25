package tbh.articlesix.board.notice.vo;

import java.sql.Date;

public class Notice {
	private int bn_n;
	private String m_nick;
	private String bn_title;
	private String bn_content;
	private Date bn_timestamp;
	private int bn_view;
	
	public Notice() {
		
	}
	
	public Notice(String bn_title, String bn_content, int bn_n) {
		super();
		this.bn_title = bn_title;
		this.bn_content = bn_content;
		this.bn_n = bn_n;
	}
	
	public Notice(String bn_title, String m_nick, String bn_content) {
		super();
		this.bn_title = bn_title;
		this.m_nick = m_nick;
		this.bn_content = bn_content;
	}
	
	@Override
	public String toString() {
		return "Notice [bn_n=" + bn_n + ", m_nick=" + m_nick + ", bn_title=" + bn_title + ", bn_content=" + bn_content
				+ ", bn_timestamp=" + bn_timestamp + ", bn_view=" + bn_view + "]";
	}

	public int getBn_n() {
		return bn_n;
	}

	public void setBn_n(int bn_n) {
		this.bn_n = bn_n;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	public String getBn_title() {
		return bn_title;
	}

	public void setBn_title(String bn_title) {
		this.bn_title = bn_title;
	}

	public String getBn_content() {
		return bn_content;
	}

	public void setBn_content(String bn_content) {
		this.bn_content = bn_content;
	}

	public Date getBn_timestamp() {
		return bn_timestamp;
	}

	public void setBn_timestamp(Date bn_timestamp) {
		this.bn_timestamp = bn_timestamp;
	}

	public int getBn_view() {
		return bn_view;
	}

	public void setBn_view(int bn_view) {
		this.bn_view = bn_view;
	}

}