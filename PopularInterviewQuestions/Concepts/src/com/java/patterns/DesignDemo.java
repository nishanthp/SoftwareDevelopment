package com.java.patterns;

public class DesignDemo {

	public static void main(String[] args) {
		// Design. 
	}

}


abstract class Member {
	private Account account;
	public Member(String userId, String password) {
		account = new Account(userId, password);
	}
	
	public Account getAccountDetails() {
		return this.account;
	}
	
	public boolean resetPassword() {
		// Make it null. 
		return true;
	}
	
	public boolean updatePassword(String newPassword) {
		// validate first.
		this.account.setPassword(newPassword);
		return true;
	}

	public boolean markUserActive() {
		this.account.setAccountStatus(AccountStatus.ACTIVE);
		return true;
	}

	public boolean markUserInActive() {
		this.account.setAccountStatus(AccountStatus.INACTIVE);
		return true;
	}
}


class User extends Member {
	MemberType type;
	User(String id, String password, MemberType mType){
		super(id, password);
		this.type = mType;
	}
	
}

class Admin extends Member {
	MemberType type;
	Admin(String id, String password, MemberType mType){
		super(id, password);
		this.type = mType;
	}
	
	public String getUserId(){
		return this.getAccountDetails().getUserName();
	}
}

class Account {
	private String accountId;
	private String password;
	private AccountStatus status;
	Account(String id, String password){
		this.accountId = id;
		this.password = password;
		this.status = AccountStatus.ACTIVE;
	}
	public String getUserName() {
		return this.accountId;
	}
	public String getPassword() {
		return this.password;
	}
	
	public void setUserName(String newId) {
		 this.accountId = newId;
	}
	public void setPassword(String newPassword) {
		 this.password = newPassword;
	}
	
	public void setAccountStatus(AccountStatus newStatus) {
		 this.status = newStatus;
	}
	public AccountStatus getAccountStatus(String newPassword) {
		 return this.status;
	}
	
}

enum AccountStatus {
	ACTIVE, INACTIVE
}
enum MemberType {
	ADMIN, USER
}