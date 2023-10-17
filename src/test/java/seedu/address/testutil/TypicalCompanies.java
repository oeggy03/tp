package seedu.address.testutil;

import seedu.address.model.company.Company;

/**
 * A utility class containing a list of {@code Company} objects to be used in tests.
 */
public class TypicalCompanies {
    public static final Company A_tech = new CompanyBuilder().withName("Alice Pauline")
        .withDescription("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
        .withPhone("94351253")
        .withTags("friends").build();
}
