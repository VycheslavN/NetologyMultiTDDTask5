import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class PhoneBookTest {
    PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
    }

    @AfterEach
    void tearDown() {
        phoneBook = null;
    }

    public static Stream<Arguments> sourceAdd() {
        return Stream.of(
                Arguments.of(2, "Ivan", "89106001155", "Petr", "89106001155"),
                Arguments.of(1, "Ivan", "89106001155", "Ivan", "89106001155")
        );
    }

    @ParameterizedTest
    @MethodSource("sourceAdd")
    void add_test(int expected, String name1, String number1, String name2, String number2) {
        phoneBook.add(name1, name2);
        Assertions.assertEquals(expected, phoneBook.add(name2, number2));
    }

    public static Stream<Arguments> sourceFindByNumber() {
        return Stream.of(
                Arguments.of("Ivan", "Ivan", "89106001155", "Petr", "89106001155"),
                Arguments.of("Ivan", "Ivan", "89106001155", "Ivan", "89106001155")
        );
    }

    public static Stream<Arguments> sourceFindByName() {
        return Stream.of(
                Arguments.of("89106001155", "Ivan", "89106001155", "Petr", "89106001155"),
                Arguments.of("89106001155", "Ivan", "89106001155", "Ivan", "89106001155")
        );
    }

    @ParameterizedTest
    @MethodSource("sourceFindByNumber")
    void findByNumber_test(String expected, String name1, String number1, String name2, String number2) {
        phoneBook.add(name1, number1);
        phoneBook.add(name2, number2);
        Assertions.assertEquals(expected, phoneBook.findByNumber(number1));
    }

    @ParameterizedTest
    @MethodSource("sourceFindByName")
    void findByName_test(String expected, String name1, String number1, String name2, String number2) {
        phoneBook.add(name1, number1);
        phoneBook.add(name2, number2);
        Assertions.assertEquals(expected, phoneBook.findByName(name1));
    }

    public static Stream<Arguments> sourcePrintNames() {
        return Stream.of(
                Arguments.of(List.of("Ivan", "Petr"), "Ivan", "89106001155", "Petr", "89106001155"),
                Arguments.of(List.of("Ivan", "Petr"), "Petr", "89106001155", "Ivan", "89106001155"),
                Arguments.of(List.of("Ivan"), "Ivan", "89106001155", "Ivan", "89106001155")
        );
    }
}