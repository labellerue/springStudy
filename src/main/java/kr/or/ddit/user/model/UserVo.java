package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserVo implements HttpSessionBindingListener{
	private String userId;
	private String name;
	private String pass;
	private String addr1;
	private String addr2;
	private String zip;
	private Date birth;
	private String email;
	private String tel;
	private String profile;
	private String alias;
	private int rnum;
	
	
	public UserVo(){
		//에러를 위한 대비
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getFormatBirth() {
		String formatBirth = new SimpleDateFormat("yyyy-MM-dd").format(birth);
		return formatBirth;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", name=" + name + ", pass=" + pass
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zip=" + zip
				+ ", birth=" + birth + ", email=" + email + ", tel=" + tel
				+ ", profile=" + profile + ", alias=" + alias + ", rnum="
				+ rnum + "]";
	}
	
	public boolean authPass(String encryptPass){
		return getPass().equals(encryptPass);
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("userVo : " + event.getName());
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}


	
}
