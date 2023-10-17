package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.company.Company;

/**
 * A utility class containing a list of {@code Company} objects to be used in tests.
 */
public class TypicalCompanies {
    public static final Company APPLE = new CompanyBuilder().withName("Apple Inc.")
        .withEmail("apple@example.com")
        .withPhone("12345678")
        .withDescription("A technology company.")
        .withTags("tech", "innovative").build();

    public static final Company MICROSOFT = new CompanyBuilder().withName("Microsoft Corporation")
        .withEmail("microsoft@example.com")
        .withPhone("23456789")
        .withDescription("A multinational technology company.")
        .withTags("tech", "windows").build();

    public static final Company GOOGLE = new CompanyBuilder().withName("Google LLC")
        .withEmail("google@example.com")
        .withPhone("34567890")
        .withDescription("An internet-related services and products company.")
        .withTags("tech", "search").build();

    // Manually added
    public static final Company AMAZON = new CompanyBuilder().withName("Amazon.com Inc.")
        .withEmail("amazon@example.com")
        .withPhone("45678901")
        .withDescription("An online retailer and cloud services company.")
        .build();

    public static final Company NETFLIX = new CompanyBuilder().withName("Netflix Inc.")
        .withEmail("netflix@example.com")
        .withPhone("56789012")
        .withDescription("A streaming service company.")
        .build();

    public static final String KEYWORD_MATCHING_TECH = "tech"; // A keyword that matches TECH

    private TypicalCompanies() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical companies.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Company company : getTypicalCompanies()) {
            ab.addCompany(company);
        }
        return ab;
    }

    public static List<Company> getTypicalCompanies() {
        return new ArrayList<>(Arrays.asList(APPLE, MICROSOFT, GOOGLE, AMAZON, NETFLIX));
    }
}
