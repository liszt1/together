package cn.zjyc.together.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 用户类
 * @author BOOKS
 *
 */
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户id
	private Integer id;
	//用户名
	private String user_name;
	//账号
	private String num;
	//密码
	private String user_pw;
	//头像
	private String icon;
	//性别（枚举） sex1("男") , sex2("女")
	private String sex;
	//年龄
	private Integer age;
	//生日
	private Date birthday;
	//点赞数
	private Integer user_like;
	//拉黑数
	private Integer blacklist;
	//身高
	private Integer height;
	//体重
	private Integer weight;
	//电话
	private String tel;
	//简介
	private String introduction;
	//货币
	private Integer money;
	//地址
	private String place;
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Integer getUser_like() {
		return user_like;
	}
	public void setUser_like(Integer user_like) {
		this.user_like = user_like;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	public Integer getBlacklist() {
		return blacklist;
	}
	public void setBlacklist(Integer blacklist) {
		this.blacklist = blacklist;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", num=" + num + ", user_pw=" + user_pw + ", icon="
				+ icon + ", sex=" + sex + ", age=" + age + ", birthday=" + birthday + ", user_like=" + user_like
				+ ", blacklist=" + blacklist + ", height=" + height + ", weight=" + weight + ", tel=" + tel
				+ ", introduction=" + introduction + ", money=" + money + ", place=" + place + "]";
	}
	
}