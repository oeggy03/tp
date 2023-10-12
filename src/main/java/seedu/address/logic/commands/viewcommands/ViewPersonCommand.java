package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.ContactIsEqualsPredicate;
import seedu.address.model.person.Person;

public class ViewPersonCommand extends ViewCommand {
    public ViewPersonCommand(Index targetIndex) {
        super(targetIndex);
    }

    public static final String MESSAGE_VIEW_PERSON_SUCCESS = "Person with index "
            + String.valueOf(getTargetIndex().getOneBased()) + " listed!";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (getTargetIndex().getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToView = lastShownList.get(getTargetIndex().getZeroBased());
        model.updateFilteredPersonList(new ContactIsEqualsPredicate(personToView));
        return new CommandResult(MESSAGE_VIEW_PERSON_SUCCESS);
    }
}