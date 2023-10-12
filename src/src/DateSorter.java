import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DateSorter {

	public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
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
}
