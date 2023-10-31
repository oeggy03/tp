package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.LogicManager;
import seedu.address.logic.commands.deletecommands.DeleteCommand;
import seedu.address.logic.commands.deletecommands.DeleteCompanyCommand;
import seedu.address.logic.commands.deletecommands.DeleteInternshipCommand;
import seedu.address.logic.commands.deletecommands.DeletePersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.company.internship.InternshipName;

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
     * The argument for deleting internship.
     */
    public static final String DELETE_INTERNSHIP_ARG_WORD = "i";

    /**
     * Regex used to confirm if the arguments are either c or p for delete command.
     */
    private static final Pattern ARGUMENT_REGEX_PATTERN =
            Pattern.compile("^(" + DELETE_COMPANY_ARG_WORD + "|"
                    + DELETE_PERSON_ARG_WORD + ")$");

    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        String[] typeIndex = trimmedArgs.split("\\s+");
        // Get index to delete from
        Index index = Index.fromOneBased(1);
        if (typeIndex.length >= 3 && typeIndex[0].equals(DELETE_INTERNSHIP_ARG_WORD)) {
            try {
                index = ParserUtil.parseIndex(typeIndex[1]);
                logger.info("index: " + index.toString());
                if (typeIndex[2].startsWith("n/")) {
                    typeIndex[2] = typeIndex[2].substring(2);
                    StringBuilder builder = new StringBuilder();
                    for (int i = 2; i < typeIndex.length; i++) {
                        builder.append(typeIndex[i]);
                        if (i < typeIndex.length - 1) {
                            builder.append(" ");
                        }
                    }
                    String temp = builder.toString();
                    return new DeleteInternshipCommand(index, new InternshipName(temp));
                } else {
                    throw new ParseException(
                            String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteInternshipCommand.MESSAGE_USAGE));
                }
            } catch (ParseException e) {
                // If index provided is not an integer
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteInternshipCommand.MESSAGE_USAGE));
            }

        }
        if (typeIndex.length != 2) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        }

        String type = typeIndex[0];
        logger.info("type: " + type);

        // Used to check if type is either c or p.
        Matcher matcher = ARGUMENT_REGEX_PATTERN.matcher(type);
        if (!matcher.matches()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        }


        try {
            index = ParserUtil.parseIndex(typeIndex[1]);
            logger.info("index: " + index.toString());
        } catch (ParseException e) {
            // If index provided is not an integer
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        }

        // Returns the appropriate Delete Command, based on the argument (p or c).
        if (type.equals(DELETE_PERSON_ARG_WORD)) {
            return new DeletePersonCommand(index);
        } else {
            return new DeleteCompanyCommand(index);
        }

    }
}
