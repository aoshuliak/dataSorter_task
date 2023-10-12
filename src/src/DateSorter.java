import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DateSorter {

	public static Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
		List<LocalDate> datesMonthR = unsortedDates.stream()
				.filter(date -> date.getMonth().toString().toLowerCase().contains("r"))
				.sorted((date1, date2) -> date1.getMonth().compareTo(date2.getMonth()))
				.collect(Collectors.toList());

		List<LocalDate> datesMonthNoR = unsortedDates.stream()
				.filter(date -> !date.getMonth().toString().toLowerCase().contains("r"))
				.sorted((date1, date2) -> date2.getMonth().compareTo(date1.getMonth()))
				.collect(Collectors.toList());

		datesMonthR.addAll(datesMonthNoR);

		return datesMonthR;
	}

	public static void main(String [] args) {
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(2022, 6, 1));
		dates.add(LocalDate.of(2022, 5, 1));
		dates.add(LocalDate.of(2025, 7, 1));
		dates.add(LocalDate.of(2022, 8, 1));

		System.out.println(sortDates(dates));
	}
}
