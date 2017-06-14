//PersonTest2基于PersonTest1
public class PersonTest2 {
	public static void main(String[] args) {
		int maxSize = 100;
		PersonTest arr = new PersonTest(maxSize);
		arr.insert("三", "张", 11);
		arr.insert("四", "李", 22);
		arr.insert("五", "王", 4);
		arr.display();
		String searchKey = "三";
		Person person = arr.find(searchKey);
		if (person != null) {
			System.out.println("");
			System.out.println("Found");
			person.display();
		} else {
			System.out.println("can't find " + searchKey);
		}
		System.out.println("");
		System.out.println("delete张三");
		arr.delete("三");
		arr.display();
	}
}
