package seedu.address.model.company;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.model.company.internship.InternshipInterviewDateTime;

/**
 * Compares two companies based on the earliest interview date.
 */
public class CompanyDateComparator implements Comparator<Company> {
    private final Predicate<InternshipInterviewDateTime> datePredicate;

    public CompanyDateComparator(Predicate<InternshipInterviewDateTime> datePredicate) {
        this.datePredicate = datePredicate;
    }

    @Override
    public int compare(Company company1, Company company2) {
        Stream<InternshipInterviewDateTime> company1Dates = company1
            .getInternshipsAsSortedObservableList()
            .stream()
            .flatMap(internship -> Stream
                .ofNullable(internship
                    .getInternshipDateTime()
                    .orElse(null)))
            .filter(datePredicate);

        Stream<InternshipInterviewDateTime> company2Dates = company2
            .getInternshipsAsSortedObservableList()
            .stream()
            .flatMap(internship -> Stream
                .ofNullable(internship
                    .getInternshipDateTime()
                    .orElse(null)))
            .filter(datePredicate);

        Optional<InternshipInterviewDateTime> company1Earliest =
            company1Dates.min(InternshipInterviewDateTime::compareTo);
        Optional<InternshipInterviewDateTime> company2Earliest =
            company2Dates.min(InternshipInterviewDateTime::compareTo);

        return company1Earliest.get().compareTo(company2Earliest.get());
    }
}
