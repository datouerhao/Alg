
public class SortedList {
	private Link first;

	public SortedList() {
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insert(long key) {
		Link newLink = new Link(key);
		Link previous = null;
		Link current = first;
		// 如果插入的值大于当前值
		while (current != null && key > current.dData) {
			previous = current;
			current = current.next;
		}
		// 如果插入的值小于当前值
		// 如果为空链表
		if (previous == null) {
			first = newLink;
		} else {
			previous.next = newLink;
		}
		newLink.next = current;
	}

	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void dispalyList() {
		Link current = first;
		while (current != null) {
			current.dispalyLink();
			current = current.next;
		}
		System.out.println(" ");
	}
}
