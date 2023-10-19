package seedu.address.logic.commands.deletecommands;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Deletes a person or a company identified using its displayed index from the address book.
 */
public abstract class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the person or company identified by the index number used in the displayed list.\n"
            + "Parameters: \n"
            + "c - View a company's contact\n"
            + "p - View a person's contact\n"
            + "INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " p 1";

    public static final String MESSAGE_SUCCESS = "Success message for the delete command!";

    @Override
    public abstract CommandResult execute(Model model) throws CommandException;
}
