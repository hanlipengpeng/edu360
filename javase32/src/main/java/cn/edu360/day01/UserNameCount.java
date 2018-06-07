package cn.edu360.day01;

public class UserNameCount {
	private String userName;
	private Integer count;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "UserNameCount [userName=" + userName + ", count=" + count + "]";
	}
	

}
