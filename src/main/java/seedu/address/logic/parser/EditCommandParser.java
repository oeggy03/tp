package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.editcommand.EditCommand;
import seedu.address.logic.commands.editcommand.EditCompanyCommand;
import seedu.address.logic.commands.editcommand.EditCompanyCommand.EditCompanyDescriptor;
import seedu.address.logic.commands.editcommand.EditPersonCommand;
import seedu.address.logic.commands.editcommand.EditPersonCommand.EditPersonDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * The argument for editing companies.
     */
    public static final String EDIT_COMPANIES_ARG_WORD = "c";

    /**
     * The argument for editing persons.
     */
    public static final String EDIT_PERSONS_ARG_WORD = "p";

    /**
     * Regex used to confirm if the arguments are either c or p for edit command.
     */
    private static final Pattern ARGUMENT_REGEX_PATTERN =
            Pattern.compile("^(" + EDIT_COMPANIES_ARG_WORD + "|" + EDIT_PERSONS_ARG_WORD + ")$");


    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.substring(0, 3).trim();
        // Used to check if argument is either c or p.
        Matcher matcher = ARGUMENT_REGEX_PATTERN.matcher(trimmedArgs);
        // Throw an error, if argument is invalid (i.e. not p or c) or empty.
        if (trimmedArgs.isEmpty() || !matcher.matches()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
        }
        if (trimmedArgs.equals(EDIT_PERSONS_ARG_WORD)) {
            ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(args.substring(2),
                            PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG);

            Index index;

            try {
                index = ParserUtil.parseIndex(argMultimap.getPreamble());
            } catch (ParseException pe) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditPersonCommand.MESSAGE_USAGE), pe);
            }

            argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS);

            EditPersonDescriptor editPersonDescriptor = new EditPersonDescriptor();

            if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
                editPersonDescriptor.setName(ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
            }
            if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
                editPersonDescriptor.setPhone(ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()));
            }
            if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
                editPersonDescriptor.setEmail(ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
            }
            if (argMultimap.getValue(PREFIX_ADDRESS).isPresent()) {
                editPersonDescriptor.setAddress(ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get()));
            }
            parseTagsForEdit(argMultimap.getAllValues(PREFIX_TAG)).ifPresent(editPersonDescriptor::setTags);

            if (!editPersonDescriptor.isAnyFieldEdited()) {
                throw new ParseException(EditPersonCommand.MESSAGE_NOT_EDITED);
            }

            return new EditPersonCommand(index, editPersonDescriptor);
        } else {
            ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(args.substring(2),
                            PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_DESCRIPTION, PREFIX_TAG);
            Index index;
            try {
                index = ParserUtil.parseIndex(argMultimap.getPreamble());
            } catch (ParseException pe) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCompanyCommand.MESSAGE_USAGE), pe);
            }

            argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_DESCRIPTION);

            EditCompanyDescriptor editCompanyDescriptor = new EditCompanyDescriptor();

            if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
                editCompanyDescriptor.setCompanyName(
                        ParserUtil.parseCompanyName(argMultimap.getValue(PREFIX_NAME).get()));
            }
            if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
                editCompanyDescriptor.setCompanyPhone(
                        ParserUtil.parseCompanyPhone(argMultimap.getValue(PREFIX_PHONE).get()));
            }
            if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
                editCompanyDescriptor.setCompanyEmail(
                        ParserUtil.parseCompanyEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
            }
            if (argMultimap.getValue(PREFIX_DESCRIPTION).isPresent()) {
                editCompanyDescriptor.setDescription(
                        ParserUtil.parseCompanyDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get()));
            }
            parseTagsForEdit(
                    argMultimap.getAllValues(PREFIX_TAG)).ifPresent(editCompanyDescriptor::setTags);

            if (!editCompanyDescriptor.isAnyFieldEdited()) {
                throw new ParseException(EditCompanyCommand.MESSAGE_NOT_EDITED);
            }

            return new EditCompanyCommand(index, editCompanyDescriptor);
        }
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Tag>} containing zero tags.
     */
    private Optional<Set<Tag>> parseTagsForEdit(Collection<String> tags) throws ParseException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTags(tagSet));
    }

}
