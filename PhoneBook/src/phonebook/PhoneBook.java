package phonebook;

class PhoneBook implements IPhoneBook {
	static int X = 4;
	static int Y = 4;
	int[][] data;

	PhoneBook() {
		// 640K Ought to be Enough for Anyone
		data = new int[X][Y];
	}

	private int hash(String name) {
		int h = 0;
		for (int i = 0; i < name.length(); i++) {
			h += name.charAt(i);
		}
		return h % X;
	}

	public int[] lookup(String name) {
		int x = hash(name);
		int[] entries = data[x];

		int count = 0;
		for (int y = 0; y < Y; y++) {
			if (entries[y] != 0)
				count++;
		}

		int[] result = new int[count];
		int index = 0;
		for (int y = 0; y < Y; y++) {
			if (entries[y] != 0) {
				result[index] = entries[y];
				index++;
			}
		}

		return result;
	}

	public void add(String name, int number) {
		int x = hash(name);
		int[] entries = data[x];

		for (int y = 0; y < Y; y++) {
			if (entries[y] == 0) {
				entries[y] = number;
				return; //false
			}
		}
	}

	public void remove(String name, int number) {
		int x = hash(name);
		int[] entries = data[x];

		for (int y = 0; y < Y; y++) {
			if (entries[y] == 0)
				return;
			if (entries[y] == number) {
				entries[y] = 0;
				return;
			}
		}
	}
}
