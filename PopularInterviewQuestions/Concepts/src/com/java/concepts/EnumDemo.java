package com.java.concepts;

public class EnumDemo {
	public static void main(String[] args) {
//		for (UserStatus stauts : UserStatus.values()) {
//			// Can be converted to string too
//			System.out.println(stauts.toString());
//			//System.out.println(stauts);
//		}

		System.out.println(InstanceEnum.accepted.getUrl());
		
//		System.out.println(Operation.PLUS.operation(1,2));
//		for(Operation op :Operation.values())
//		{
//			System.out.println(op);
//		}
//		
//		System.out.println(UserStatus.valueOf("pending"));
		//Below statement does not work. InstanceEnum.valueOf("pending") gives InstanceEnum.pending not a string.
		//String p = InstanceEnum.valueOf("pending");
		
		System.out.println(Suit.Club.getNumber());
		System.out.println(Suit.Heart.getStr());
	}
}

enum UserStatus {
	pending, waiting, accepted;
}

enum InstanceEnum {
	pending("The status is pending with us..."), waiting("We are waiting for the package"), accepted(
			"It has been accepted");

	private String url;

	// Only private constructor is permitted. NO public constructor for enum.
	private InstanceEnum(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}

enum Operation {
	PLUS, MINUS, MULTIPLY, DIVIDE;

	int operation(int x, int y) {
		switch (this) {
		case PLUS:
			return x + y;
		case MINUS:
			return x - y;
		case MULTIPLY:
			return x * y;
		case DIVIDE:
			return x / y;
		default:
			return -1;
		}
	}
}


enum Suit{
	// supports different value types.
	Diamond(0), Spade(1), Club(2), Heart("3");
	
	int num;
	String s; 
	private Suit(int number){
		this.num = number;
	}
	
	private Suit(String str){
		this.s = str;
	}
	
	public int getNumber(){
		return this.num;
	}
	
	public String getStr(){
		return this.s;
	}
}