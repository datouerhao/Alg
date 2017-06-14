package WordReverse;
import java.io.IOException;
import java.util.Scanner;

public class WordReverseTest2 {

	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {

			Scanner sc = new Scanner(System.in);

			// 获取用户输入的字符串

			System.out.print("请输入任意字符:");
			input = sc.nextLine();
			if (input.equals("")) {
				break;
			}
			WordReverseTest wr = new WordReverseTest(input);
			output = wr.doRev();
			System.out.println("翻转之后：" + output);
		}

	}

}
