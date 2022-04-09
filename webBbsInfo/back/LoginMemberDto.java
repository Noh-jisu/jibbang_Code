package health.back.a.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoginMemberDto {
	
	/*
	 CREATE TABLE LOGINMEMBERS(
	ID VARCHAR2(100) PRIMARY KEY,
	PWD VARCHAR2(100) NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	NICKNAME VARCHAR2(30) NOT NULL,
	GENDER VARCHAR2(10) NOT NULL,
	AGE NUMBER(10) NOT NULL,
	EMAIL VARCHAR2(70) UNIQUE,
	TEL VARCHAR2(70) NOT NULL,
	AUTH NUMBER(10) NOT NULL,
	REGIDATE DATE NOT NULL,
	TRAINER VARCHAR2
	);
	
	
	 */
	@NotBlank(message="아이디를 입력하세요.")
	private String id;
	
	@NotBlank(message="비밀번호를 입력하세요.")
	private String pwd;
	
	@NotBlank(message="이름을 입력하세요.")
	private String name;
	
	@NotBlank(message="닉네임을 입력하세요.")
	private String nickname;
	
	@NotNull(message="성별을 입력하세요.")
	private String gender;
	
	@NotNull(message="나이를 입력하세요.")
	private int age;
	
	@NotBlank(message="이메일을 입력하세요.")
	private String email;
	
	@NotNull(message="전화번호를 입력하세요.")
	private String tel;
	
	private int auth;
	private String regidate;
	private String trainer;
	private int del;
	
	public LoginMemberDto() {}

	public LoginMemberDto(String id, String pwd, String name, String nickname, String gender, int age, String email, String tel,
			int auth, String regidate, String trainer, int del) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.tel = tel;
		this.auth = auth;
		this.regidate = regidate;
		this.trainer = trainer;
		this.del = del;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "LoginMemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", nickname=" + nickname + ", gender="
				+ gender + ", age=" + age + ", email=" + email + ", tel=" + tel + ", auth=" + auth + ", regidate="
				+ regidate + ", trainer=" + trainer + ", del=" + del + "]";
	}
}