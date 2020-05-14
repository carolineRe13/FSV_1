package phonebook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPhoneBook {
	
	private IPhoneBook book;
	
	@BeforeEach
	void setup() {
		// Initialisierung
		book = new PhoneBook();
	}
	
	@Test
	@DisplayName("add_twoNumbersToSameKey_keyContainsThoseNumbers")
	void test1() {
		// Testausführung
		book.add("Hilbert", 1234);
		book.add("Hilbert", 7777);

		// Ergebnis überprüfen
		int[] numbers = book.lookup("Hilbert");
		assertElements(numbers, 1234, 7777);
	}

	void assertElements(int[] array, int... elements) {
		Assertions.assertArrayEquals(array, elements);
	}
	@Test
	@DisplayName("remove an existing contact")
	void test2() {
		book.add("Hilbert", 123);
		book.add("Hilbert", 7777);
		book.remove("Hilbert", 123);
		int[] numbers = book.lookup("Hilbert");
		assertElements(numbers,7777);	
	}

	@Test
	@DisplayName("remove a non existing contact")
	void test3() {
		book.add("Hilbert", 123);
		book.add("Hilbert", 7777);
		book.remove("Hilbert", 000);
		int[] numbers = book.lookup("Hilbert");
		assertElements(numbers,123,7777);
	}
	
	@Test
	@DisplayName("Adding_more_than_4_contacts_with_the_same_name")
	void test4() {
		book.add("Hilbert", 123);
		book.add("Hilbert", 7777);
		book.add("Hilbert", 7777);
		book.add("Hilbert", 7777);
		book.add("Hilbert", 7777);
		int[] numbers = book.lookup("Hilbert");
		assertElements(numbers,123,7777,7777,7777);
	}
	
	@Test
	@DisplayName("4_contacts_with_the_same_name_and_deleting_one_with_a_non_existent_number")
	void test5() {
		book.add("Hilbert", 123);
		book.add("Hilbert", 7777);
		book.add("Hilbert", 7777);
		book.add("Hilbert", 7777);
		book.remove("Hilbert", 7771);
		int[] numbers = book.lookup("Hilbert");
		assertElements(numbers,123,7777,7777,7777);
	}
	@Test
	@DisplayName("adding_more_than_4_contacts")
	void test6() {
		book.add("Hilbert", 123);
		book.add("Marco", 7777);
		book.add("Anna", 7777);
		book.add("Jos�", 7777);
		book.add("Henna", 7777);
		int[] numbers = book.lookup("Henna");
		assertElements(numbers,7777);
	}
}
