package lambda;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/26 15:01
 */
public class TestStudentBuilder {
	public static void main(String[] args){
		Student a = new StudentBuilder().setAge(13).setName("LiHua").build();
		System.out.println(a.toString());
	}
}
