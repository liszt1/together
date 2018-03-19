package cn.zjyc.together.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 队伍表
 * @author note
 *
 */
public class Team implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	//队伍ID
	private Integer id;
	//队伍名称
	private String team_name;
	//类型ID
	private Integer type_id;
	//地点id
	private String city;
	//队伍创建时间
	private Timestamp createTime;
	//队伍开始时间
	private Timestamp startTime ;
	//队伍结束时间
	private Timestamp endTime;
	//队伍简介
	private String introduction;
	//队伍状态(枚举)  队伍状态，正在进行中、已结束、可加入，满员
	//run("正在进行中"), end("已结束"),full("满员"),mayjoin("可加入")
	private String team_state;
	//队伍当前人数
	private Integer current_num;
	//队伍人数上限
	private Integer limit_num;


	public Integer getCurrent_num() {
		return current_num;
	}
	public void setCurrent_num(Integer current_num) {
		this.current_num = current_num;
	}
	public Integer getLimit_num() {
		return limit_num;
	}
	public void setLimit_num(Integer limit_num) {
		this.limit_num = limit_num;
	}
	public String getTeam_state() {
		return team_state;
	}
	public void setTeam_state(String team_state) {
		this.team_state = team_state;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}



	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp starTime) {
		this.startTime = starTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", team_name=" + team_name + ", type_id=" + type_id + ", city=" + city
				+ ", createTime=" + createTime + ", startTime=" + startTime + ", endTime=" + endTime + ", introduction="
				+ introduction + ", team_state=" + team_state + ", current_num=" + current_num + ", limit_num="
				+ limit_num + "]";
	}

	
}