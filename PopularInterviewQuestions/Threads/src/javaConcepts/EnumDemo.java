package javaConcepts;

public class EnumDemo {
	public static void main(String[] args) {
		for (UserStatus stauts : UserStatus.values()) {
			// Can be converted to string too
			System.out.println(stauts.toString());
			//System.out.println(stauts);
		}

		System.out.println(InstanceEnum.accepted.getUrl());
		
		System.out.println(Operation.PLUS.operation(1,2));
		for(Operation op :Operation.values())
		{
			System.out.println(op);
		}
		
		System.out.println(UserStatus.valueOf("pending"));
		//Below statement does not work. InstanceEnum.valueOf("pending") gives InstanceEnum.pending not a string.
		//String p = InstanceEnum.valueOf("pending");
	}
}

enum UserStatus {
	pending, waiting, accepted;
}

enum InstanceEnum {
	pending("The status is pending with us..."), waiting("We are waiting for the package"), accepted(
			"It has been accepted");

	private String url;

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