
public class PersonTest {
	private Person[] a;
	private int Elems;

	public PersonTest(int max) {
		a = new Person[max];
		Elems = 0;
	}

	public Person find(String searchName) {
		int j;
		for (j = 0; j < Elems; j++) {
			if (a[j].getLast().equals(searchName))
				break;
		}
		if (j == Elems) {
			return null;
		} else {
			return a[j];
		}
	}

	public void insert(String last, String first, int age) {
		a[Elems] = new Person(last, first, age);
		Elems++;
	}

	public boolean delete(String searchName) {
		int j;
		for (j = 0; j < Elems; j++) {
			if (a[j].getLast().equals(searchName))
				break;
		}
		if (j == Elems) {
			return false;
		} else {
			for (int k = j; k < Elems; k++)
				a[k] = a[k + 1];
		}
		Elems--;
		return true;
	}

	public void display() {
		for (int j = 0; j < Elems; j++) {
			a[j].display();
		}
	}
}
