
public class StackTest11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackTest1 stack1 = new StackTest1(10);
		stack1.push(10);
		stack1.push(30);
		stack1.push(20);
		stack1.push(40);

		while (!stack1.isEmpty()) {
			long value = stack1.pop();
			System.out.print(value);
			System.out.print(" ");
		}
	}

}
