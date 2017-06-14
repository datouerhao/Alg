//有序数组查找快，插入慢，无序数组查找慢，插入快
public class OrderArray2 {
	public static void main(String[] args) {
		int maxSize = 100;
		OrderArray1 arr = new OrderArray1(maxSize);
		arr.insert(77);
		arr.insert(22);
		arr.insert(55);
		arr.insert(66);
		arr.insert(33);
		int searchKey = 66;
		if (arr.find(searchKey) != arr.size()) {
			System.out.println("found" + searchKey);
		} else {
			System.out.println("can't find" + searchKey);

		}
		arr.display();
		arr.delete(33);
		arr.display();
	}
}
