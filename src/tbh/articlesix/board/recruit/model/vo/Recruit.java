package tbh.articlesix.board.recruit.model.vo;

import java.sql.Date;

//	    B_N NUMBER PRIMARY KEY NOT NULL,
//	    M_ID VARCHAR2(30) NOT NULL,
//		CA_N NUMBER NOT NULL,
//	    B_TYPE CHAR(4) NOT NULL,
//	    B_TITLE VARCHAR2(500) NOT NULL,
//	    B_CONTENT VARCHAR2(2000) NOT NULL,
//	    B_START DATE NOT NULL,
//	    B_END DATE NOT NULL,
//	    B_TOTAL NUMBER NOT NULL,
//	    B_ATTEND NUMBER,
//	    B_PLACE VARCHAR2(500) NOT NULL,
//	    B_FEE NUMBER,
//	    B_MATCH CHAR(5) NOT NULL,
//	    B_GENDER CHAR(3) NOT NULL,
//	    B_AGE CHAR NOT NULL ,
//	    B_EQUIP CHAR(3) NOT NULL,
//	    B_MINPEOPLE NUMBER NOT NULL,
//	    B_PROGRESS VARCHAR2(2000),
//	    B_SHOWER CHAR(3) NOT NULL,
//	    B_PARKING CHAR(3) NOT NULL,
//	    B_RENTAL CHAR(3) NOT NULL,
//	    B_CLOTH CHAR(3) NOT NULL,
//	    B_FACILITY VARCHAR2(2000),
//	    B_TIMESTAMP DATE NOT NULL,
//	    B_VIEW NUMBER    

public class Recruit {
	private int b_n;
	private String m_id;
	private int ca_n;
	private char b_type;
	private String b_title;
	private String b_content;
	private String b_start;
	private String b_end;
	private int b_total;
	private int b_attend;
	private String b_place;
	private int b_fee;
	private char b_match;
	private char b_gender;
	private char b_age;
	private char b_equip;
	private int b_minpeople;
	private String b_progress;
	private char b_shower;
	private char b_parking;
	private char b_rental;
	private char b_cloth;
	private String b_facility;
	private String b_timestamp;
	private int b_view;

	public Recruit() {
	}

	// 글 작성

	public Recruit(String m_id, int ca_n, char b_type, String b_title, String b_content, String b_start,
			String b_end, int b_total, int b_attend, String b_place, int b_fee, char b_match, char b_gender, char b_age,
			char b_equip, int b_minpeople, String b_progress, char b_shower, char b_parking, char b_rental,
			char b_cloth, String b_facility, String b_timestamp, int b_view) {
		super();
		this.m_id = m_id;
		this.ca_n = ca_n;
		this.b_type = b_type;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_start = b_start;
		this.b_end = b_end;
		this.b_total = b_total;
		this.b_attend = b_attend;
		this.b_place = b_place;
		this.b_fee = b_fee;
		this.b_match = b_match;
		this.b_gender = b_gender;
		this.b_age = b_age;
		this.b_equip = b_equip;
		this.b_minpeople = b_minpeople;
		this.b_progress = b_progress;
		this.b_shower = b_shower;
		this.b_parking = b_parking;
		this.b_rental = b_rental;
		this.b_cloth = b_cloth;
		this.b_facility = b_facility;
		this.b_timestamp = b_timestamp;
		this.b_view = b_view;
	}

	// 글 수정
	public Recruit(String m_id, int ca_n, char b_type, String b_title, String b_content, String b_start, String b_end,
			int b_total, String b_place, int b_fee, char b_match, char b_gender, char b_age, char b_equip,
			int b_minpeople, String b_progress, char b_shower, char b_parking, char b_rental, char b_cloth,
			String b_facility, String b_timestamp) {
		super();
		this.m_id = m_id;
		this.ca_n = ca_n;
		this.b_type = b_type;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_start = b_start;
		this.b_end = b_end;
		this.b_total = b_total;
		this.b_place = b_place;
		this.b_fee = b_fee;
		this.b_match = b_match;
		this.b_gender = b_gender;
		this.b_age = b_age;
		this.b_equip = b_equip;
		this.b_minpeople = b_minpeople;
		this.b_progress = b_progress;
		this.b_shower = b_shower;
		this.b_parking = b_parking;
		this.b_rental = b_rental;
		this.b_cloth = b_cloth;
		this.b_facility = b_facility;
		this.b_timestamp = b_timestamp;
	}

	@Override
	public String toString() {
		return "Recruit [b_n=" + b_n + ", m_id=" + m_id + ", ca_n=" + ca_n + ", b_type=" + b_type + ", b_title="
				+ b_title + ", b_content=" + b_content + ", b_start=" + b_start + ", b_end=" + b_end + ", b_total="
				+ b_total + ", b_attend=" + b_attend + ", b_place=" + b_place + ", b_fee=" + b_fee + ", b_match="
				+ b_match + ", b_gender=" + b_gender + ", b_age=" + b_age + ", b_equip=" + b_equip + ", b_minpeople="
				+ b_minpeople + ", b_progress=" + b_progress + ", b_shower=" + b_shower + ", b_parking=" + b_parking
				+ ", b_rental=" + b_rental + ", b_cloth=" + b_cloth + ", b_facility=" + b_facility + ", b_timestamp="
				+ b_timestamp + ", b_view=" + b_view + "]";
	}

	public int getB_n() {
		return b_n;
	}

	/**
	 * @param b_n the b_n to set
	 */
	public void setB_n(int b_n) {
		this.b_n = b_n;
	}

	/**
	 * @return the m_id
	 */
	public String getM_id() {
		return m_id;
	}

	/**
	 * @param m_id the m_id to set
	 */
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	/**
	 * @return the ca_n
	 */
	public int getCa_n() {
		return ca_n;
	}

	/**
	 * @param ca_n the ca_n to set
	 */
	public void setCa_n(int ca_n) {
		this.ca_n = ca_n;
	}

	/**
	 * @return the b_type
	 */
	public char getB_type() {
		return b_type;
	}

	/**
	 * @param b_type the b_type to set
	 */
	public void setB_type(char b_type) {
		this.b_type = b_type;
	}

	/**
	 * @return the b_title
	 */
	public String getB_title() {
		return b_title;
	}

	/**
	 * @param b_title the b_title to set
	 */
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	/**
	 * @return the b_content
	 */
	public String getB_content() {
		return b_content;
	}

	/**
	 * @param b_content the b_content to set
	 */
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	/**
	 * @return the b_start
	 */
	public String getB_start() {
		return b_start;
	}

	/**
	 * @param b_start the b_start to set
	 */
	public void setB_start(String b_start) {
		this.b_start = b_start;
	}

	/**
	 * @return the b_end
	 */
	public String getB_end() {
		return b_end;
	}

	/**
	 * @param b_end the b_end to set
	 */
	public void setB_end(String b_end) {
		this.b_end = b_end;
	}

	/**
	 * @return the b_total
	 */
	public int getB_total() {
		return b_total;
	}

	/**
	 * @param b_total the b_total to set
	 */
	public void setB_total(int b_total) {
		this.b_total = b_total;
	}

	/**
	 * @return the b_attend
	 */
	public int getB_attend() {
		return b_attend;
	}

	/**
	 * @param b_attend the b_attend to set
	 */
	public void setB_attend(int b_attend) {
		this.b_attend = b_attend;
	}

	/**
	 * @return the b_place
	 */
	public String getB_place() {
		return b_place;
	}

	/**
	 * @param b_place the b_place to set
	 */
	public void setB_place(String b_place) {
		this.b_place = b_place;
	}

	/**
	 * @return the b_fee
	 */
	public int getB_fee() {
		return b_fee;
	}

	/**
	 * @param b_fee the b_fee to set
	 */
	public void setB_fee(int b_fee) {
		this.b_fee = b_fee;
	}

	/**
	 * @return the b_match
	 */
	public char getB_match() {
		return b_match;
	}

	/**
	 * @param b_match the b_match to set
	 */
	public void setB_match(char b_match) {
		this.b_match = b_match;
	}

	/**
	 * @return the b_gender
	 */
	public char getB_gender() {
		return b_gender;
	}

	/**
	 * @param b_gender the b_gender to set
	 */
	public void setB_gender(char b_gender) {
		this.b_gender = b_gender;
	}

	/**
	 * @return the b_age
	 */
	public char getB_age() {
		return b_age;
	}

	/**
	 * @param b_age the b_age to set
	 */
	public void setB_age(char b_age) {
		this.b_age = b_age;
	}

	/**
	 * @return the b_equip
	 */
	public char getB_equip() {
		return b_equip;
	}

	/**
	 * @param b_equip the b_equip to set
	 */
	public void setB_equip(char b_equip) {
		this.b_equip = b_equip;
	}

	/**
	 * @return the b_minpeople
	 */
	public int getB_minpeople() {
		return b_minpeople;
	}

	/**
	 * @param b_minpeople the b_minpeople to set
	 */
	public void setB_minpeople(int b_minpeople) {
		this.b_minpeople = b_minpeople;
	}

	/**
	 * @return the b_progress
	 */
	public String getB_progress() {
		return b_progress;
	}

	/**
	 * @param b_progress the b_progress to set
	 */
	public void setB_progress(String b_progress) {
		this.b_progress = b_progress;
	}

	/**
	 * @return the b_shower
	 */
	public char getB_shower() {
		return b_shower;
	}

	/**
	 * @param b_shower the b_shower to set
	 */
	public void setB_shower(char b_shower) {
		this.b_shower = b_shower;
	}

	/**
	 * @return the b_parking
	 */
	public char getB_parking() {
		return b_parking;
	}

	/**
	 * @param b_parking the b_parking to set
	 */
	public void setB_parking(char b_parking) {
		this.b_parking = b_parking;
	}

	/**
	 * @return the b_rental
	 */
	public char getB_rental() {
		return b_rental;
	}

	/**
	 * @param b_rental the b_rental to set
	 */
	public void setB_rental(char b_rental) {
		this.b_rental = b_rental;
	}

	/**
	 * @return the b_cloth
	 */
	public char getB_cloth() {
		return b_cloth;
	}

	/**
	 * @param b_cloth the b_cloth to set
	 */
	public void setB_cloth(char b_cloth) {
		this.b_cloth = b_cloth;
	}

	/**
	 * @return the b_facility
	 */
	public String getB_facility() {
		return b_facility;
	}

	/**
	 * @param b_facility the b_facility to set
	 */
	public void setB_facility(String b_facility) {
		this.b_facility = b_facility;
	}

	/**
	 * @return the b_timestamp
	 */
	public String getB_timestamp() {
		return b_timestamp;
	}

	/**
	 * @param b_timestamp the b_timestamp to set
	 */
	public void setB_timestamp(String b_timestamp) {
		this.b_timestamp = b_timestamp;
	}

	/**
	 * @return the b_view
	 */
	public int getB_view() {
		return b_view;
	}

	/**
	 * @param b_view the b_view to set
	 */
	public void setB_view(int b_view) {
		this.b_view = b_view;
	}

}