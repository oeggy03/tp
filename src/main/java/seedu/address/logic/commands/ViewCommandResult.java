package seedu.address.logic.commands;

import seedu.address.model.company.Company;
import seedu.address.model.person.Person;

/**
 * Represents the result of a view command execution.
 */
public class ViewCommandResult extends CommandResult {

    private final Person personToDisplay;
    private final Company companyToDisplay;

    private boolean isPersonCommand;

    public ViewCommandResult(String feedbackToUser, Person personToDisplay) {
        super(feedbackToUser, false, false, true);
        this.personToDisplay = personToDisplay;
        this.companyToDisplay = null;
        this.isPersonCommand = true;
    }

    public ViewCommandResult(String feedbackToUser, Company companyToDisplay) {
        super(feedbackToUser, false, false, true);
        this.companyToDisplay = companyToDisplay;
        this.personToDisplay = null;
        this.isPersonCommand = false;
    }

    public boolean isDisplayingPerson() {
        return isPersonCommand;
    }

    public Person getPersonToDisplay() {
        return this.personToDisplay;
    }

    public Company getCompanyToDisplay() {
        return this.companyToDisplay;
    }
}
