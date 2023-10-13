package seedu.address.logic.viewcommands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.viewcommands.ViewPersonCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for {@code ViewPersonCommand}.
 */
public class ViewPersonCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_viewPersonAtIndex1_success() {
        assertCommandSuccess(new ViewPersonCommand(Index.fromOneBased(1)), model,
                String.format(ViewPersonCommand.MESSAGE_VIEW_PERSON_SUCCESS, 1), expectedModel);
    }

    @Test
    public void execute_viewPersonAtIndexExceedsListSize_exceptionThrown() {
        assertCommandFailure(new ViewPersonCommand(Index.fromOneBased(99)), model,
                Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }
}
