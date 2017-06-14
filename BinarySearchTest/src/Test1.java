
public class Test1 {
	public static int rank(int a[], int key) {
		int lo = 0, hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < mid) {
				hi = mid - 1;
			} else if (key > mid) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		int a[] = { 33, 22, 11, 88, 55 };
		System.out.println(rank(a, 88));
	}
}
