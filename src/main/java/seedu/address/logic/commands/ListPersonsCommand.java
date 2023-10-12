package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;

public class ListPersonsCommand extends ListCommand{
    public ListPersonsCommand(String arg) {
        super(arg);
    }

    @Override
    public CommandResult execute(Model model) {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS_PERSONS);
    }
}
