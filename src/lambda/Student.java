package lambda;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/26 14:40
 */
public class Student{
		String name = null ;
		int number = -1 ;
		String sex = null ;
		int age = -1 ;
		String school = null ;
		public Student(StudentBuilder builder){
			this.age = builder.age;
			this.name = builder.name;
			this.number = builder.number;
			this.school = builder.school ;
			this.sex = builder.sex ;
		}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", number=" + number +
				", sex='" + sex + '\'' +
				", age=" + age +
				", school='" + school + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}

