package Test;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/11/24 10:40
 */
public class Test {
	public static void main(String args[]){
		String string = "张三,李四,王五,马六,小气";
		String substring = string.substring(0, string.length() - 1);
		System.out.println(substring);
		String[] split = string.split(",");//以逗号分割
		for (String string2 : split) {
			System.out.println("数据-->>>" + string2);
		}
	}
}
