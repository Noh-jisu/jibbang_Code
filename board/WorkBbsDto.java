package health.back.a.dto;

/*
CREATE TABLE WORKBBS(
	WORKBBSSEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(100) NOT NULL,
	NICKNAME VARCHAR2(30) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	REF NUMBER(8) NOT NULL,
	STEP NUMBER(8) NOT NULL,
	DEPTH NUMBER(8) NOT NULL,
	DEL NUMBER(1) NOT NULL,
	WDATE DATE NOT NULL,
	READCOUNT NUMBER(8) NOT NULL,
	BBSLIKE NUMBER(8) NOT NULL,
	BBSIMAGE VARCHAR2(300) UNIQUE
);

CREATE SEQUENCE WORKBBSSEQ_WORKBBS
START WITH 1 INCREMENT BY 1;

ALTER TABLE WORKBBS
ADD CONSTRAINT FK_WORKBBS_ID FOREIGN KEY(ID)
REFERENCES LOGINMEMBERS(ID);
*/

public class WorkBbsDto {
	private int seq;
	private String id;	
	private String nickname;
	
	private String title;
	private String content;
	private String wdate;
	
	private int ref;
	private int step;
	private int depth;
	
	private int del;
	private int readcount;
	private int bbsLike;
	private String bbsImage;
	
	public WorkBbsDto() {
		super();
	}

	public WorkBbsDto(int seq, String id, String nickname, String title, String content, String wdate, int ref,
			int step, int depth, int del, int readcount, int bbsLike, String bbsImage) {
		super();
		this.seq = seq;
		this.id = id;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.del = del;
		this.readcount = readcount;
		this.bbsLike = bbsLike;
		this.bbsImage = bbsImage;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getBbsLike() {
		return bbsLike;
	}

	public void setBbsLike(int bbsLike) {
		this.bbsLike = bbsLike;
	}

	public String getBbsImage() {
		return bbsImage;
	}

	public void setBbsImage(String bbsImage) {
		this.bbsImage = bbsImage;
	}

	@Override
	public String toString() {
		return "WorkBbsDto [seq=" + seq + ", id=" + id + ", nickname=" + nickname + ", title=" + title + ", content="
				+ content + ", wdate=" + wdate + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", del=" + del
				+ ", readcount=" + readcount + ", bbsLike=" + bbsLike + ", bbsImage=" + bbsImage + "]";
	}
	
}



