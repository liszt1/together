package cn.zjyc.together.entity;

import java.io.Serializable;
/**
 * 
 * 点赞记录表
 * @author note
 * 
 */
public class Thumb implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	//id
	private Integer id;
	//用户id
	private Integer user_id;
	//队伍id
	private Integer team_id;
	//点赞状态(枚举) thumbyes（已点赞），thumbno（未点赞）
	private String th_state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getTeam_id() {
		return team_id;
	}
	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}
	public String getTh_state() {
		return th_state;
	}
	public void setTh_state(String th_state) {
		this.th_state = th_state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Thumb [id=" + id + ", user_id=" + user_id + ", team_id=" + team_id + ", th_state=" + th_state + "]";
	}
	
}