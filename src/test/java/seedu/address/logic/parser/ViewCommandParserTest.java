package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.viewcommands.ViewCommand;
import seedu.address.logic.commands.viewcommands.ViewPersonCommand;

public class ViewCommandParserTest {

    private ViewCommandParser parser = new ViewCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsViewCommand() {
        ViewCommand expectedViewCommand =
                new ViewPersonCommand(Index.fromOneBased(1));
        assertParseSuccess(parser, "p 1", expectedViewCommand);
    }

}
