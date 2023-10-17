package seedu.address.logic.commands.listcommands;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_COMPANIES;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all companies in the address book to the user.
 */
public class ListCompaniesCommand extends ListCommand {

    public static final String MESSAGE_SUCCESS = "Listed all companies";

    @Override
    public CommandResult execute(Model model) {
        model.updateFilteredCompanyList(PREDICATE_SHOW_ALL_COMPANIES);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
