package seedu.address.logic.commands.deletecommands;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Lists all persons or companies in the address book to the user.
 */
public abstract class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the person or company identified by the index number used in the displayed list.\n"
            + "Parameters: \n"
            + " TYPE - c (Delete a company's contact) OR " + "p (Delete a person's contact)\n"
            + " INDEX - Index number shown in the corresponding contact list\n"
            + "Format: delete TYPE INDEX\n"
            + "Example: " + COMMAND_WORD + " c 1 deletes the company at index 1 from the 'Companies' list";

    public static final String MESSAGE_SUCCESS = "Deleted: %1$s";

    @Override
    public abstract CommandResult execute(Model model) throws CommandException;
}
