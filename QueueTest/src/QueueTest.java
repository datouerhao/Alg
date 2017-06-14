
public class QueueTest {
	public static void main(String[] args) {
		Queue queue = new Queue(4);
		queue.insert(33);
		queue.insert(13);
		queue.insert(23);
		queue.insert(43);
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		System.out.println(queue.peek());
		while (!queue.isEmpty()) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println("");
		// 判断是为空还是满
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		queue.insert(13);
		queue.insert(23);
		queue.insert(43);
		System.out.println(queue.peek());
	}
}
