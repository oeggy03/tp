package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.company.Company;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Company} objects to be used in tests.
 */
public class TypicalCompanies {
    // temporary for test
    public static final Company A_tech = new CompanyBuilder().withName("Alice Pauline")
        .withDescription("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
        .withPhone("94351253")
        .withTags("friends").build();
    public static final Company B_tech = new CompanyBuilder().withName("Benson Meier")
        .withDescription("311, Clementi Ave 2, #02-25")
        .withEmail("johnd@example.com").withPhone("98765432")
        .withTags("owesMoney", "friends").build();
    public static final Company C_tech = new CompanyBuilder().withName("Carl Kurz").withPhone("95352563")
        .withEmail("heinz@example.com").withDescription("wall street").build();
    public static final Company D_tech = new CompanyBuilder().withName("Daniel Meier").withPhone("87652533")
        .withEmail("cornelia@example.com").withDescription("10th street").withTags("friends").build();
    public static final Company E_tech = new CompanyBuilder().withName("Elle Meyer").withPhone("9482224")
        .withEmail("werner@example.com").withDescription("michegan ave").build();
    public static final Company F_tech = new CompanyBuilder().withName("Fiona Kunz").withPhone("9482427")
        .withEmail("lydia@example.com").withDescription("little tokyo").build();
    public static final Company G_tech = new CompanyBuilder().withName("George Best").withPhone("9482442")
        .withEmail("anna@example.com").withDescription("4th street").build();


        /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Company company : getTypicalCompanies()) {
            ab.addCompany(company);
        }
        return ab;
    }

    public static List<Company> getTypicalCompanies() {
        return new ArrayList<>(Arrays.asList(A_tech, B_tech, C_tech, D_tech, E_tech, F_tech, G_tech));
    }
}
