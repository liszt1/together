package cn.zjyc.together.entity;

import java.io.Serializable;
/**
 * 
 * 运动类型表
 * @author note
 * 
 */
public class Type implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	//类型id
	private Integer id;
	//类型名称
	private String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + type + "]";
	}
	
}