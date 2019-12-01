package constant;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/29 15:21
 */
public class Constant {
	public static void main(String[] args) {
		System.out.println(Father.str);
	}
}

class Father{
	public static String str = "Hello,world";
	static {
		System.out.println("Father static block");
	}
}
