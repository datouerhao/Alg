package WordReverse;
//主要是提供翻转字符串方法
public class WordReverseTest {
	private String input;
	private String output;

	public WordReverseTest(String in) {
		input = in;
	}

	public String doRev() {
		int stackSize = input.length();
		WordReverse wr = new WordReverse(stackSize);
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);// 从输入中得到一个字符串
			wr.push(ch);
		}
		output = "";
		while (!wr.isEmpty()) {
			char ch = wr.pop();
			output = output + ch;
		}
		return output;
	}
}
