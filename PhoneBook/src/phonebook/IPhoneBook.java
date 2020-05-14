package phonebook;

public interface IPhoneBook {
	int[] lookup(String name);

	void add(String name, int number);

	void remove(String name, int number);
}
