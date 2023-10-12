package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String LIST_COMPANIES_ARG_WORD = "c";

    public static final String LIST_PERSONS_ARG_WORD = "p";

    public String argument;

    public static final String MESSAGE_SUCCESS_PERSONS = "Listed all persons";

    public static final String MESSAGE_SUCCESS_COMPANIES = "Listed all companies";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all persons or companies. \n"
            + "Parameters: \n"
            + "c - Lists all companies\n"
            + "p - Lists all persons \n"
            + "Example: " + COMMAND_WORD + " p";

    public ListCommand(String arg) {
        this.argument = arg;
    }

    public CommandResult executeListPersons(Model model) {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS_PERSONS);
    }
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        return executeListPersons(model);
    }
}
