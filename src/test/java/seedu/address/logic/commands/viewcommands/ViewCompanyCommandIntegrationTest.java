package seedu.address.logic.commands.viewcommands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalCompanies.getTypicalAddressBook;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.company.Company;
import seedu.address.model.company.ContactIsEqualsPredicate;

/**
 * Contains integration tests (interaction with the Model) and unit tests for {@code ViewPersonCommand}.
 */
public class ViewCompanyCommandIntegrationTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_viewCompanyAtIndex1_success() {
        List<Company> listToCheck = expectedModel.getFilteredCompanyList();
        Company companyToView = listToCheck.get(0);
        expectedModel.updateFilteredCompanyList(new ContactIsEqualsPredicate(companyToView));
        assertCommandSuccess(new ViewCompanyCommand(Index.fromOneBased(1)), model,
                String.format(ViewCompanyCommand.MESSAGE_SUCCESS, 1), expectedModel);
    }

    @Test
    public void execute_viewCompanyAtIndexExceedsListSize_exceptionThrown() {
        assertCommandFailure(new ViewCompanyCommand(Index.fromOneBased(99)), model,
                Messages.MESSAGE_INVALID_COMPANY_DISPLAYED_INDEX);
    }
}
