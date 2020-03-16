package com.istyle.pojo;

import com.istyle.pojo.ext.UserExt;

/**
 * @author 黄文伟
 */
public class TbUser extends UserExt {
    private long userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userSex;
    private int userAge;
    private String userWord;
    private String userPhoto;
    private Long count;
    private int usersState;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserWord() {
		return userWord;
	}
	public void setUserWord(String userWord) {
		this.userWord = userWord;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public int getUsersState() {
		return usersState;
	}
	public void setUsersState(int usersState) {
		this.usersState = usersState;
	}
	@Override
	public String toString() {
		return "TbUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userPhone="
				+ userPhone + ", userSex=" + userSex + ", userAge=" + userAge + ", userWord=" + userWord
				+ ", userPhoto=" + userPhoto + ", count=" + count + ", usersState=" + usersState + "]";
	}

}
