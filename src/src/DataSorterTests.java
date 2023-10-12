import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataSorterTests {

	@Test
	void testSortDates() {
		List<LocalDate> unsortedDates = new ArrayList<>();
		unsortedDates.add(LocalDate.of(2004, 7, 1));
		unsortedDates.add(LocalDate.of(2005, 1, 2));
		unsortedDates.add(LocalDate.of(2007, 1, 1));
		unsortedDates.add(LocalDate.of(2032, 5, 3));

		Collection<LocalDate> sortedDates = DateSorter.sortDates(unsortedDates);

		List<LocalDate> expectedSortedDates = new ArrayList<>();
		expectedSortedDates.add(LocalDate.of(2005, 1, 2));
		expectedSortedDates.add(LocalDate.of(2007, 1, 1));
		expectedSortedDates.add(LocalDate.of(2004, 7, 1));
		expectedSortedDates.add(LocalDate.of(2032, 5, 3));

		assertEquals(expectedSortedDates, sortedDates);
	}
}
