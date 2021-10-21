package tbh.articlesix.market.vo;

import java.sql.Date;

public class Market {
//	IMG_N NUMBER PRIMARY KEY NOT NULL,
//    IMG_SCR VARCHAR2(80) NOT NULL
//    BM_N NUMBER NOT NULL,
//    M_ID VARCHAR2(30) NOT NULL,    
//    C_CONTENT VARCHAR2(1000) NOT NULL,
//    C_TIMESTAMP DATE NOT NULL
	int bmN;
	String mId;
	int caN;
	int imgN;
	int imgP;
	int cN;
	String bmTitle;
	String bmContent;
	Date bmTimeStamp;
	int bmView;
	int price;
	String imgScr;
	String cContent;
	Date cTimeStamp;
	int bref;
	int breLevel;
	int breStep;

	
	public Market() {

	}
	
	public Market(int bmN, int bmP) {
		super();
		this.imgN = bmN;
		this.imgP = bmP;
	}

	public Market(int bmN, String imgScr) {
		super();
		this.bmN = bmN;
		this.imgScr = imgScr;
	}

	public Market(String mId, int bmN, String bmTitle, String imgScr, int price, String cContent) {
		super();
		this.mId = mId;
		this.bmN = bmN;
		this.bmTitle = bmTitle;
		this.imgScr = imgScr;
		this.price = price;
		this.cContent = cContent;
	}
	

	@Override
	public String toString() {
		return "Market [bmN=" + bmN + ", mId=" + mId + ", caN=" + caN + ", imgN=" + imgN + ", imgP=" + imgP + ", cN="
				+ cN + ", bmTitle=" + bmTitle + ", bmContent=" + bmContent + ", bmTimeStamp=" + bmTimeStamp
				+ ", bmView=" + bmView + ", price=" + price + ", imgScr=" + imgScr + ", cContent=" + cContent
				+ ", cTimeStamp=" + cTimeStamp + ", bref=" + bref + ", breLevel=" + breLevel + ", breStep=" + breStep
				+ "]";
	}

	public int getImgP() {
		return imgP;
	}

	public void setImgP(int imgP) {
		this.imgP = imgP;
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

	public int getBmN() {
		return bmN;
	}

	public void setBmN(int bmN) {
		this.bmN = bmN;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getCaN() {
		return caN;
	}

	public void setCaN(int caN) {
		this.caN = caN;
	}

	public int getImgN() {
		return imgN;
	}

	public void setImgN(int imgN) {
		this.imgN = imgN;
	}

	public int getcN() {
		return cN;
	}

	public void setcN(int cN) {
		this.cN = cN;
	}

	public String getBmTitle() {
		return bmTitle;
	}

	public void setBmTitle(String bmTitle) {
		this.bmTitle = bmTitle;
	}

	public String getBmContent() {
		return bmContent;
	}

	public void setBmContent(String bmContent) {
		this.bmContent = bmContent;
	}

	public Date getBmTimeStamp() {
		return bmTimeStamp;
	}

	public void setBmTimeStamp(Date bmTimeStamp) {
		this.bmTimeStamp = bmTimeStamp;
	}

	public int getBmView() {
		return bmView;
	}

	public void setBmView(int bmView) {
		this.bmView = bmView;
	}

	public String getImgScr() {
		return imgScr;
	}

	public void setImgScr(String imgScr) {
		this.imgScr = imgScr;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public Date getcTimeStamp() {
		return cTimeStamp;
	}

	public void setcTimeStamp(Date cTimeStamp) {
		this.cTimeStamp = cTimeStamp;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
