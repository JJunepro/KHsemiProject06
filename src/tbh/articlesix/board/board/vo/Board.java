package tbh.articlesix.board.board.vo;
import java.sql.Date;

public class Board {
	private int bf_n;
	private String m_nick;
	private String bf_title;
	private String bf_content;
	private Date bf_timestamp;
	private int bf_view;
	private int bf_category;  

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String bf_title, String bf_content, int bf_n) {
		super();
		this.bf_title = bf_title;
		this.bf_content = bf_content;
		this.bf_n = bf_n;
	}
	
	public Board(String bf_title, String m_nick, String bf_content, int bf_category) {
		super();
		this.bf_title = bf_title;
		this.m_nick = m_nick;
		this.bf_content = bf_content;
		this.bf_category = bf_category;
	}
	
	@Override
	public String toString() {
		return "Board [bf_n=" + bf_n + ", m_nick=" + m_nick + ", bf_title=" + bf_title + ", bf_content=" + bf_content
				+ ", bf_timestamp=" + bf_timestamp + ", bf_view=" + bf_view + ", bf_category=" + bf_category + "]";
	}

	public int getBf_n() {
		return bf_n;
	}

	public void setBf_n(int bf_n) {
		this.bf_n = bf_n;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	public String getBf_title() {
		return bf_title;
	}

	public void setBf_title(String bf_title) {
		this.bf_title = bf_title;
	}

	public String getBf_content() {
		return bf_content;
	}

	public void setBf_content(String bf_content) {
		this.bf_content = bf_content;
	}

	public Date getBf_timestamp() {
		return bf_timestamp;
	}

	public void setBf_timestamp(Date bf_timestamp) {
		this.bf_timestamp = bf_timestamp;
	}

	public int getBf_view() {
		return bf_view;
	}

	public void setBf_view(int bf_view) {
		this.bf_view = bf_view;
	}

	public int getBf_category() {
		return bf_category;
	}

	public void setBf_category(int bf_category) {
		this.bf_category = bf_category;
	}

	

}