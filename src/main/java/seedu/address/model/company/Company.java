package seedu.address.model.company;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.company.internship.Internship;
import seedu.address.model.company.internship.InternshipInterviewDateTime;
import seedu.address.model.tag.Tag;

/**
 * Represents a Company in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Company {

    // Identity fields
    private final CompanyName companyName;
    private final CompanyPhone phone;
    private final CompanyEmail email;

    // Data fields
    private final CompanyDescription companyDescription;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<Internship> internships = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Company(CompanyName companyName, CompanyPhone phone,
                   CompanyEmail email, CompanyDescription companyDescription,
                   Set<Tag> tags, Set<Internship> internships) {
        requireAllNonNull(companyName, phone, email, companyDescription, tags, internships);
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.companyDescription = companyDescription;
        this.tags.addAll(tags);
        this.internships.addAll(internships);
    }

    public CompanyName getCompanyName() {
        return companyName;
    }

    public CompanyPhone getCompanyPhone() {
        return phone;
    }

    public CompanyEmail getCompanyEmail() {
        return email;
    }

    public CompanyDescription getCompanyDescription() {
        return companyDescription;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns an immutable internship set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Internship> getInternships() {
        return Collections.unmodifiableSet(internships);
    }

    public ObservableList<Internship> getInternshipsAsSortedObservableList() {
        // Create a list from the set
        List<Internship> internshipsList = new ArrayList<>(internships);

        // Sort the list based on the internship date (if available)
        internshipsList.sort((internship1, internship2) -> {
            Optional<InternshipInterviewDateTime> dateTime1 = internship1.getInternshipDateTime();
            Optional<InternshipInterviewDateTime> dateTime2 = internship2.getInternshipDateTime();

            if (dateTime1.isPresent() && dateTime2.isPresent()) {
                return dateTime1.get().compareTo(dateTime2.get());
            } else if (dateTime1.isPresent()) {
                return -1; // internship1 has a date, so it comes before internship2
            } else if (dateTime2.isPresent()) {
                return 1; // internship2 has a date, so it comes before internship1
            } else {
                return 0; // both internships have no date, keep their order
            }
        });

        // Convert the sorted list back to an ObservableList
        return FXCollections.observableArrayList(internshipsList);
    }

    /**
     * Returns true if both companies have the same name.
     * This defines a weaker notion of equality between two companies.
     */
    public boolean isSameCompany(Company otherCompany) {
        if (otherCompany == this) {
            return true;
        }

        return otherCompany != null
            && otherCompany.getCompanyName().equals(getCompanyName());
    }

    /**
     * Returns true if both companys have the same identity and data fields.
     * This defines a stronger notion of equality between two companys.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Company)) {
            return false;
        }

        Company otherCompany = (Company) other;
        return companyName.equals(otherCompany.companyName)
            && phone.equals(otherCompany.phone)
            && email.equals(otherCompany.email)
            && companyDescription.equals(otherCompany.companyDescription)
            && tags.equals(otherCompany.tags)
            && internships.equals(otherCompany.internships);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(companyName, phone, email, companyDescription, tags, internships);
    }

    /**
     * Prints a list of internships for viewing.
     *
     * @return String of List of internships
     */
    public String toStringInternships() {
        StringBuilder result = new StringBuilder("[");
        for (Internship i : this.internships) {
            result.append(i.toString()).append(", ");
        }

        if (result.length() >= 2) {
            result.delete(result.length() - 2, result.length());
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("\nname", companyName)
            .add("\nphone", phone)
            .add("\nemail", email)
            .add("\ncompanyDescription", companyDescription)
            .add("\ntags", tags)
            .add("\ninternships", toStringInternships())
            .toString();
    }
}
