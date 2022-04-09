package health.back.a.dto;

/*
CREATE TABLE READCOUNTBBS(
	BBS_SEQ NUMBER(8) REFERENCES WORKBBS(WORKBBSSEQ),
	USER_ID VARCHAR2(100) REFERENCES LOGINMEMBERS(ID)
);
*/

public class ReadCountBbsDto {
	private int bbs_seq;
	private String user_id;

	public ReadCountBbsDto() {
		super();
	}

	public ReadCountBbsDto(int bbs_seq, String user_id) {
		super();
		this.bbs_seq = bbs_seq;
		this.user_id = user_id;
	}

	public int getBbs_seq() {
		return bbs_seq;
	}

	public void setBbs_seq(int bbs_seq) {
		this.bbs_seq = bbs_seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "ReadCountBbsDto [bbs_seq=" + bbs_seq + ", user_id=" + user_id + "]";
	}
	
	
}
