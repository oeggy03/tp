package seedu.address.logic.commands.editcommands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalCompanies.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON_INTERNSHIP_OR_COMPANY;
import static seedu.address.testutil.TypicalInternships.FINANCE_INTERN_WITH_DATETIME;
import static seedu.address.testutil.TypicalInternships.SOFTWARE_ENGINEER_WITH_DATETIME;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandTestUtil;
import seedu.address.logic.commands.clearcommands.ClearAllCommand;
import seedu.address.logic.commands.editcommands.editdescriptors.EditInternshipDescriptor;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.company.Company;
import seedu.address.model.company.internship.Internship;
import seedu.address.testutil.CompanyBuilder;
import seedu.address.testutil.EditInternshipDescriptorBuilder;
import seedu.address.testutil.InternshipBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for EditInternshipCommand.
 */
public class EditInternshipCommandIntegrationTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        Company companyToEdit = model.getFilteredCompanyList().get(0);
        Company expectedCompany = new CompanyBuilder(companyToEdit).build();
        Internship internshipToEdit = companyToEdit.getInternshipAtIndex(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY);

        Internship editedInternship = new InternshipBuilder(FINANCE_INTERN_WITH_DATETIME).build();

        EditInternshipDescriptor descriptor = new EditInternshipDescriptorBuilder(editedInternship).build();
        EditInternshipCommand editInternshipCommand =
                new EditInternshipCommand(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                        INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                        descriptor);

        String expectedMessage = String.format(
                EditInternshipCommand.MESSAGE_SUCCESS, Messages.formatInternship(editedInternship));

        expectedCompany.setInternship(internshipToEdit, editedInternship);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setCompany(model.getFilteredCompanyList().get(0), expectedCompany);

        CommandTestUtil.assertDisplayableCommandSuccess(editInternshipCommand, model, expectedMessage,
                expectedModel, expectedCompany);
    }

    @Test
    public void execute_someFieldsSpecifiedUnfilteredList_success() {
        Company companyToEdit = model.getFilteredCompanyList().get(0);
        Company expectedCompany = new CompanyBuilder(companyToEdit).build();
        Internship internshipToEdit = companyToEdit.getInternshipAtIndex(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY);

        Internship editedInternship = new InternshipBuilder(internshipToEdit)
                .withInternshipName("Finance Intern 2024")
                .build();

        EditInternshipDescriptor descriptor = new EditInternshipDescriptorBuilder()
                .withInternshipName("Finance Intern 2024")
                .build();
        EditInternshipCommand editInternshipCommand =
                new EditInternshipCommand(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                        INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                        descriptor);

        String expectedMessage = String.format(
                EditInternshipCommand.MESSAGE_SUCCESS, Messages.formatInternship(editedInternship));

        expectedCompany.setInternship(internshipToEdit, editedInternship);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setCompany(model.getFilteredCompanyList().get(0), expectedCompany);

        CommandTestUtil.assertDisplayableCommandSuccess(editInternshipCommand, model, expectedMessage,
                expectedModel, expectedCompany);
    }

    @Test
    public void execute_noFieldSpecifiedUnfilteredList_failure() {
        EditInternshipCommand editInternshipCommand = new EditInternshipCommand(
                INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY, INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                new EditInternshipDescriptor());
        Company companyToEdit = model.getFilteredCompanyList()
                .get(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY.getZeroBased());
        Internship internshipToEdit = companyToEdit.getInternshipAtIndex(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY);
        Internship editedInternship = new InternshipBuilder(internshipToEdit).build();

        String expectedMessage = String.format(EditInternshipCommand.MESSAGE_NOT_EDITED);

        CommandTestUtil.assertCompanyCommandFailure(editInternshipCommand, model, expectedMessage);
    }

    @Test
    public void equals() {
        final EditInternshipCommand standardCommand =
                new EditInternshipCommand(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                new EditInternshipDescriptorBuilder(SOFTWARE_ENGINEER_WITH_DATETIME).build());

        // same values -> returns true
        EditInternshipDescriptor copyDescriptor = new EditInternshipDescriptorBuilder(SOFTWARE_ENGINEER_WITH_DATETIME)
                .build();
        EditInternshipCommand commandWithSameValues =
                new EditInternshipCommand(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                        INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearAllCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditInternshipCommand(INDEX_SECOND_PERSON_INTERNSHIP_OR_COMPANY,
                INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                new EditInternshipDescriptorBuilder(SOFTWARE_ENGINEER_WITH_DATETIME).build())));
        assertFalse(standardCommand.equals(new EditInternshipCommand(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                INDEX_SECOND_PERSON_INTERNSHIP_OR_COMPANY,
                new EditInternshipDescriptorBuilder(SOFTWARE_ENGINEER_WITH_DATETIME).build())));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditInternshipCommand(INDEX_FIRST_PERSON_INTERNSHIP_OR_COMPANY,
                INDEX_SECOND_PERSON_INTERNSHIP_OR_COMPANY,
                new EditInternshipDescriptorBuilder(FINANCE_INTERN_WITH_DATETIME).build())));
    }

    @Test
    public void toStringMethod() {
        Index index = Index.fromOneBased(1);
        EditInternshipDescriptor editInternshipDescriptor =
                new EditInternshipDescriptorBuilder(SOFTWARE_ENGINEER_WITH_DATETIME).build();
        EditInternshipCommand editInternshipCommand = new EditInternshipCommand(index, index, editInternshipDescriptor);
        String expected = EditInternshipCommand.class.getCanonicalName() + "{companyIndex=" + index + ", "
                + "internshipIndex=" + index + ", "
                + "editInternshipDescriptor="
                + editInternshipDescriptor + "}";
        assertEquals(expected, editInternshipCommand.toString());
    }
}
