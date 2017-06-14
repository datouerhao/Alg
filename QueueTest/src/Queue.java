
public class Queue {
	private int maxSize;
	private long[] arr;
	private int front;
	private int end;
	private int elements;// 队列中数字的个数

	public Queue(int s) {
		maxSize = s;
		arr = new long[maxSize];
		front = 0;
		end = -1;
		elements = 0;
	}

	public void insert(long j) {
		if (end == arr.length - 1) {
			end = -1;
		}
		arr[++end] = j;
		elements++;
	}

	public long remove() {
		long value = arr[front++];
		if (front == arr.length) {
			front = 0;
		}

		elements--;
		return value;
	}

	public long peek() {
		return arr[front];
	}

	public boolean isEmpty() {
		return elements == 0;
	}

	public boolean isFull() {
		return elements == maxSize;
	}
}
