package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON_OR_COMPANY;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.deletecommands.DeletePersonCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();
   
    @Test
    public void parse_invalidArgs1_throwsParseException() {
        assertParseFailure(parser, "d 1",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeletePersonCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidArgs2_throwsParseException() {
        assertParseFailure(parser, "p a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeletePersonCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsDeletePersonCommand() {
        assertParseSuccess(parser, "p 1", new DeletePersonCommand(INDEX_FIRST_PERSON_OR_COMPANY));
    }

    @Test
    public void parse_notEnoughArgs_throwsParseException() {
        assertParseFailure(parser, "p",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeletePersonCommand.MESSAGE_USAGE));
    }
}
