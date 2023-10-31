package seedu.address.logic.commands.clearcommands;

import static seedu.address.testutil.TypicalCompanies.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.company.Company;
import seedu.address.testutil.CompanyBuilder;



public class ClearInternshipCommandTest {
    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Company validCompany = new CompanyBuilder().build();
        model.addCompany(validCompany);
    }

}
