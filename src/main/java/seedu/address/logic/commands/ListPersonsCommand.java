package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListPersonsCommand extends ListCommand{

    public static final String MESSAGE_SUCCESS = "Listed all persons";

    public ListPersonsCommand(String arg) {
        super(arg);
    }

    @Override
    public CommandResult execute(Model model) {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
