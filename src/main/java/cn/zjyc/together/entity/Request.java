package cn.zjyc.together.entity;

import java.io.Serializable;
/**
 * 
 * 申请记录表
 * @author note
 * 
 */
public class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	//申请记录表id
	private Integer id;
	//队伍ID
	private Integer team_id;
	//用户ID
	private Integer user_id;
	//申请状态（枚举）  add("已加入"), resquest("申请中"),out("被踢出"),
	private String re_state;
	//身份信息（枚举）  member("队员"), captain("队长");
	private String position;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeam_id() {
		return team_id;
	}
	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getRe_state() {
		return re_state;
	}
	public void setRe_state(String re_state) {
		this.re_state = re_state;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", team_id=" + team_id + ", user_id=" + user_id + ", re_state=" + re_state
				+ ", position=" + position + "]";
	}


}
