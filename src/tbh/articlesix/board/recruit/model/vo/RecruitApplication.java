package tbh.articlesix.board.recruit.model.vo;

import java.sql.Date;

public class RecruitApplication {
	private int ap_n;
	private String m_id;
	private int b_n;
	private char ap_agree;
	private Date ap_timestamp;

	public RecruitApplication() {
	}

	
	
	public RecruitApplication(int ap_n, String m_id, int b_n, char ap_agree, Date ap_timestamp) {
		super();
		this.ap_n = ap_n;
		this.m_id = m_id;
		this.b_n = b_n;
		this.ap_agree = ap_agree;
		this.ap_timestamp = ap_timestamp;
	}

	@Override
	public String toString() {
		return "recruitApplication [ap_n=" + ap_n + ", m_id=" + m_id + ", b_n=" + b_n + ", ap_agree=" + ap_agree
				+ ", ap_timestamp=" + ap_timestamp + "]";
	}

	public int getAp_n() {
		return ap_n;
	}

	public void setAp_n(int ap_n) {
		this.ap_n = ap_n;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getB_n() {
		return b_n;
	}

	public void setB_n(int b_n) {
		this.b_n = b_n;
	}

	public char getAp_agree() {
		return ap_agree;
	}

	public void setAp_agree(char ap_agree) {
		this.ap_agree = ap_agree;
	}

	public Date getAp_timestamp() {
		return ap_timestamp;
	}

	public void setAp_timestamp(Date ap_timestamp) {
		this.ap_timestamp = ap_timestamp;
	}

	
}
