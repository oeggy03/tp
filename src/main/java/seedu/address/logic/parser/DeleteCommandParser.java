package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.deletecommands.DeleteCommand;
import seedu.address.logic.commands.deletecommands.DeleteCompanyCommand;
import seedu.address.logic.commands.deletecommands.DeletePersonCommand;
import seedu.address.logic.commands.viewcommands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {
    /**
     * The argument for deleting company.
     */
    public static final String DELETE_COMPANY_ARG_WORD = "c";

    /**
     * The argument for deleting persons.
     */
    public static final String DELETE_PERSON_ARG_WORD = "p";

    /**
     * Regex used to confirm if the arguments are either c or p for delete command.
     */
    private static final Pattern ARGUMENT_REGEX_PATTERN =
            Pattern.compile("^(" + DELETE_COMPANY_ARG_WORD + "|" + DELETE_PERSON_ARG_WORD + ")$");

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
        }

        String[] typeIndex = trimmedArgs.split("\\s+");
        String type = typeIndex[0];
        System.out.println("type: " + type);
        Index index = Index.fromOneBased(Integer.parseInt(typeIndex[1]));
        System.out.println("index: " + index.toString());

        // Used to check if type is either c or p.
        Matcher matcher = ARGUMENT_REGEX_PATTERN.matcher(type);
        if (!matcher.matches()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
        }

        // Returns the appropriate List Command, based on the argument (p or c).
        if (type.equals(DELETE_PERSON_ARG_WORD)) {
            return new DeletePersonCommand(index);
        } else {
            return new DeleteCompanyCommand(index);
        }
    }
}
