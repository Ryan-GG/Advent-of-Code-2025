import com.advent.code.Id;
import com.advent.code.IdParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DayTwoTest {

    @Test
    void basicTest() {
        IdParser idParser = new IdParser();
        List<Id> ids = idParser.parse("11-22,23-24");
        assertEquals(14, ids.size());
    }


    @Test
    void isValidTest() {

        Id one = new Id(12345);
        Id two = new Id(55);
        Id three = new Id(6464);
        Id four = new Id(123123);
        Id five = new Id(1231234);
        Id six = new Id(142312);
        Id seven = new Id(12312);
        assertAll(
                () -> assertTrue(one::isValid),
                () -> assertFalse(two::isValid),
                () -> assertFalse(three::isValid),
                () -> assertFalse(four::isValid),
                () -> assertFalse(five::isValid),
                () -> assertTrue(six::isValid),
                () -> assertTrue(seven::isValid)
        );
    }

    @Test
    void partTwo() {
        IdParser idParser = new IdParser();
        List<Long> firstRange = idParser.parse("11-22").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> twoRange = idParser.parse("95-115").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> threeRange = idParser.parse("998-1012").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> fourRange = idParser.parse("1188511880-1188511890").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> fiveRange = idParser.parse("222220-222224").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> sixRange = idParser.parse("1698522-1698528").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> sevenRange = idParser.parse("446443-446449").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> eightRange = idParser.parse("38593856-38593862").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> nineRange = idParser.parse("565653-565659").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> tenRange = idParser.parse("824824821-824824827").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();
        List<Long> elevenRange = idParser.parse("2121212118-2121212124").stream().filter(id -> !id.isValidPartTwo()).map(Id::value).sorted().toList();

        assertIterableEquals(List.of(11L, 22L), firstRange);
        assertIterableEquals(List.of(99L, 111L), twoRange);
        assertIterableEquals(List.of(999L, 1010L), threeRange);
        assertIterableEquals(List.of(1188511885L), fourRange);
        assertIterableEquals(List.of(222222L), fiveRange);
        assertIterableEquals(List.of(), sixRange);
        assertIterableEquals(List.of(446446L), sevenRange);
        assertIterableEquals(List.of(38593859L), eightRange);
        assertIterableEquals(List.of(565656L), nineRange);
        assertIterableEquals(List.of(824824824L), tenRange);
        assertIterableEquals(List.of(2121212121L), elevenRange);

    }

    @Test
    void sampleTest() {

        IdParser idParser = new IdParser();
        Long invalidIdSum = idParser
                .parse("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")
                .stream()
                .filter(id -> !id.isValid())
                .mapToLong(Id::value)
                .sum();


        System.out.println(invalidIdSum);

        assertEquals(1227775554, invalidIdSum);

    }

    @Test
    void myTest() {

        IdParser idParser = new IdParser();
        Long invalidIdSum = idParser
                .parse("61-71,12004923-12218173,907895-1086340,61083-74975,7676687127-7676868552,3328-4003,48-59,3826934-3859467,178-235,75491066-75643554,92-115,1487-1860,483139-586979,553489051-553589200,645895-722188,47720238-47818286,152157-192571,9797877401-9798014942,9326-11828,879837-904029,4347588-4499393,17-30,1-16,109218-145341,45794-60133,491-643,2155-2882,7576546102-7576769724,4104-5014,34-46,67594702-67751934,8541532888-8541668837,72-87,346340-480731,3358258808-3358456067,78265-98021,7969-9161,19293-27371,5143721-5316417,5641-7190,28793-36935,3232255123-3232366239,706-847,204915-242531,851-1135,790317-858666")
                .stream()
                .filter(id -> !id.isValid())
                .mapToLong(Id::value)
                .sum();

        assertEquals(64215794229L, invalidIdSum);

    }

    @Test
    void isValidPartTwoTest() {

        IdParser idParser = new IdParser();
        Long invalidIdSum = idParser
                .parse("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")
                .stream()
                .filter(id -> !id.isValidPartTwo())
                .mapToLong(Id::value)
                .sum();

        assertEquals(4174379265L, invalidIdSum);

    }

}
