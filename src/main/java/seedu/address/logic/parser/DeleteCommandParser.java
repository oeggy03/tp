package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.deletecommands.DeleteCommand;
import seedu.address.logic.commands.deletecommands.DeleteCompanyCommand;
import seedu.address.logic.commands.deletecommands.DeletePersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {
    /**
     * The argument for listing companies.
     */
    public static final String DELETE_COMPANIES_ARG_WORD = "c";

    /**
     * The argument for listing persons.
     */
    public static final String DELETE_PERSONS_ARG_WORD = "p";

    /**
     * Regex used to confirm if the arguments are either c or p for list command.
     */
    private static final Pattern ARGUMENT_REGEX_PATTERN =
            Pattern.compile("^(" + DELETE_COMPANIES_ARG_WORD + "|" + DELETE_PERSONS_ARG_WORD + ")$");

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        String[] argArray = trimmedArgs.split(" ");

        // If there are more or less than 2 arguments, we know that the arguments are wrong.
        if (argArray.length != 2) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        }

        // Used to check if argument is either c or p.
        Matcher matcher = ARGUMENT_REGEX_PATTERN.matcher(argArray[0]);

        // Throw an error, if argument is invalid (i.e. not p or c)
        if (!matcher.matches()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        }

        try {
            // Parse the index to get an Index object
            Index index = ParserUtil.parseIndex(argArray[1].strip());

            if (Objects.equals(argArray[0], DELETE_COMPANIES_ARG_WORD)) {
                return new DeleteCompanyCommand(index);
            } else {
                return new DeletePersonCommand(index);
            }

        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
        }
    }

}
