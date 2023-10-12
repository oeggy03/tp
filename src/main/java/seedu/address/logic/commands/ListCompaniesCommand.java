package seedu.address.logic.commands;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;

/**
 * Lists all companies in the address book to the user.
 */
public class ListCompaniesCommand extends ListCommand {

    public static final String MESSAGE_SUCCESS = "Listed all companies";

    @Override
    public CommandResult execute(Model model) {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
