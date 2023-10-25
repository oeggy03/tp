package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.addcommands.AddCommand;
import seedu.address.logic.commands.addcommands.AddCompanyCommand;
import seedu.address.logic.commands.addcommands.AddPersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.company.Company;
import seedu.address.model.person.Person;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * The argument for listing companies.
     */
    public static final String ADD_COMPANIES_ARG_WORD = "c";

    /**
     * The argument for listing persons.
     */
    public static final String ADD_PERSONS_ARG_WORD = "p";

    /**
     * Regex used to confirm if the arguments are either c or p for list command.
     */
    private static final Pattern ARGUMENT_REGEX_PATTERN =
            Pattern.compile("^(" + ADD_COMPANIES_ARG_WORD + "|" + ADD_PERSONS_ARG_WORD + ")\\s+.*$");

    private final Logger logger = LogsCenter.getLogger(AddCommandParser.class);

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();

        // Used to check if argument is either c or p.
        Matcher matcher = ARGUMENT_REGEX_PATTERN.matcher(trimmedArgs);

        // Throw an error, if argument is invalid (i.e. not p or c).
        if (!matcher.matches()) {
            logger.info("Add command did not specify \"p\" or \"c\", was empty after \"p\" or \"c\"");
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        String type = trimmedArgs.substring(0, 1);
        if (type.equals(ADD_PERSONS_ARG_WORD)) {
            logger.info("Adding person...");
            Person person = ParserUtil.parsePerson(trimmedArgs.substring(1));
            return new AddPersonCommand(person);
        } else {
            logger.info("Adding company...");
            Company company = ParserUtil.parseCompany(trimmedArgs.substring(1));
            return new AddCompanyCommand(company);
        }
    }
}
