package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public abstract class ViewCommand extends Command {
    private static Index targetIndex;

    public ViewCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": View a person or company. \n"
            + "Parameters: \n"
            + "c - View a company's contact\n"
            + "p - View a person's contact\n"
            + "index - Index number shown in the corresponding contact list\n"
            + "Example: " + COMMAND_WORD + " p 3";

    public static Index getTargetIndex() {
        return targetIndex;
    }

    @Override
    public abstract CommandResult execute(Model model) throws CommandException;
}