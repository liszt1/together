package cn.zjyc.together.constant;

public enum EnumStateAll {
		//性别男，性别女
	     man("男"), woman("女"),
	     //队伍状态，正在进行中、已结束、可加入，满员。
	     run("正在进行中"),end("已结束"),mayjoin("可加入"),full("满员"),
	     
	     add("已加入"), request("申请中"),reject("已拒绝"),out("被踢出"),
	     
	     member("队员"), captain("队长"),
	     
	     thumbyes("已点赞"),thumbno("未点赞");
			
		
	      
	    private String name ;
	     
	    private EnumStateAll( String name ){
	        this.name = name ;
	    }
	     
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }     	 
	}
