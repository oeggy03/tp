package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.findcommands.FindCommand;
import seedu.address.logic.commands.findcommands.FindCompanyCommand;
import seedu.address.logic.commands.findcommands.FindPersonCommand;
import seedu.address.model.company.CompanyNameAndTagContainKeywordsPredicate;
import seedu.address.model.person.NameAndTagContainKeywordsPredicate;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        // Failure scenarios for persons
        assertParseFailure(parser, FindCommandParser.FIND_PERSONS_ARG_WORD + " ",
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));

        // Failure scenarios for companies
        assertParseFailure(parser, FindCommandParser.FIND_COMPANIES_ARG_WORD + " ",
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));

    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // For persons
        FindPersonCommand expectedFindPersonCommand = new FindPersonCommand(
            new NameAndTagContainKeywordsPredicate(Arrays.asList("Alice", "Bob"), Collections.emptyList()));
        assertParseSuccess(parser, " " + FindCommandParser.FIND_PERSONS_ARG_WORD + " "
            + CliSyntax.PREFIX_NAME + "Alice " + CliSyntax.PREFIX_NAME + "Bob", expectedFindPersonCommand);

        // For companies
        FindCompanyCommand expectedFindCompanyCommand = new FindCompanyCommand(
            new CompanyNameAndTagContainKeywordsPredicate(Arrays.asList("Apple", "Google"), Collections.emptyList()));
        assertParseSuccess(parser, " " + FindCommandParser.FIND_COMPANIES_ARG_WORD + " "
            + CliSyntax.PREFIX_NAME + "Apple " + CliSyntax.PREFIX_NAME + "Google", expectedFindCompanyCommand);
    }

}


