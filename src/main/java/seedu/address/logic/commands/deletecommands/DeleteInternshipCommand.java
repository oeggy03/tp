package seedu.address.logic.commands.deletecommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.commandresults.CommandResult;
import seedu.address.logic.commands.commandresults.RegularCommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.company.Company;
import seedu.address.model.company.internship.Internship;
import seedu.address.model.company.internship.InternshipName;


/**
 * Deletes internships identified using its name and the company it belongs to from the address book.
 */
public class DeleteInternshipCommand extends DeleteCommand {
    public static final String MESSAGE_SUCCESS = "Internship successfully deleted: %1$s";
    public static final String MESSAGE_NO_INTERNSHIP_MATCHED =
            "This internship with the given name doesn't exist in the company";
    private final Index targetCompanyIndex;
    private final InternshipName internshipName;
    /**
     * Creates an DeleteCommand to delete the specified {@code Internship} of a {@code Company}
     * @param targetCompanyIndex The index of the company as shown in the last shown list.
     * @param internshipName The name of the internship to be deleted from the company.
     */
    public DeleteInternshipCommand(Index targetCompanyIndex, InternshipName internshipName) {
        requireAllNonNull(targetCompanyIndex, internshipName);
        this.targetCompanyIndex = targetCompanyIndex;
        this.internshipName = internshipName;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Company> lastShownList = model.getFilteredCompanyList();

        if (targetCompanyIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_COMPANY_DISPLAYED_INDEX);
        }

        Company companyToDelete = lastShownList.get(targetCompanyIndex.getZeroBased());
        Set<Internship> currInternships = companyToDelete.getInternships();
        Set<Internship> internshipsToKeep = new HashSet<>();
        boolean isExist = false;
        for (Internship internship : currInternships) {
            if (!internship.getInternshipName().equals(internshipName)) {
                internshipsToKeep.add(internship);
            } else {
                isExist = true;
            }
        }
        if (!isExist) {
            throw new CommandException(MESSAGE_NO_INTERNSHIP_MATCHED);
        }

        Company updatedCompany = new Company(companyToDelete.getCompanyName(),
                companyToDelete.getCompanyPhone(), companyToDelete.getCompanyEmail(),
                companyToDelete.getCompanyDescription(), companyToDelete.getTags(),
                internshipsToKeep);

        model.setCompany(companyToDelete, updatedCompany);
        model.updateFilteredCompanyList(Model.PREDICATE_SHOW_ALL_COMPANIES);
        return new RegularCommandResult(String.format(MESSAGE_SUCCESS, this.internshipName));
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteInternshipCommand)) {
            return false;
        }

        DeleteInternshipCommand otherDeleteInternshipCommand = (DeleteInternshipCommand) other;
        return targetCompanyIndex.equals(otherDeleteInternshipCommand.targetCompanyIndex)
                && internshipName.equals(otherDeleteInternshipCommand.internshipName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetCompanyIndex", targetCompanyIndex)
                .add("internshipName", internshipName)
                .toString();
    }

}
