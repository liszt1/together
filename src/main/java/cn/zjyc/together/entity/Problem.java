package cn.zjyc.together.entity;

import java.io.Serializable;
/**
 * 
 * 密保表
 * @author note
 * 
 */
public class Problem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	//密保表id
	private Integer id;
	//密保表用户id
	private Integer user_id;
	//密保表密保问题
	private String problem;
	//密保表密保答案
	private String answer;
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
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Problem [id=" + id + ", user_id=" + user_id + ", problem=" + problem + ", answer=" + answer + "]";
	}
	
	


}