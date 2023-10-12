package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;

/**
 * Lists all persons or companies in the address book to the user.
 */
public abstract class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public String argument;

    public static final String MESSAGE_SUCCESS = "Listed all companies";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all persons or companies. \n"
            + "Parameters: \n"
            + "c - Lists all companies\n"
            + "p - Lists all persons \n"
            + "Example: " + COMMAND_WORD + " p";

    public ListCommand(String arg) {
        this.argument = arg;
    }

    @Override
    public abstract CommandResult execute(Model model);
}
