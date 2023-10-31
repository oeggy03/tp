package seedu.address.logic.commands.deletecommands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalCompanies.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON_OR_COMPANY;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON_OR_COMPANY;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandTestUtil;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.company.Company;
import seedu.address.model.company.internship.Internship;
import seedu.address.model.company.internship.InternshipName;
import seedu.address.testutil.CompanyBuilder;

public class DeleteInternshipCommandIntegrationTest {
    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_deleteInternshipCompanyNoMatchedInternships_failure() {
        InternshipName internshipName = new InternshipName("Project Manager");
        DeleteInternshipCommand deleteInternshipCommand = new DeleteInternshipCommand(
                INDEX_FIRST_PERSON_OR_COMPANY, internshipName
        );
        CommandTestUtil.assertInternshipCommandFailure(
                deleteInternshipCommand, model,
                DeleteInternshipCommand.MESSAGE_NO_INTERNSHIP_MATCHED);
    }

    @Test
    public void execute_deleteInternshipCompanyWithMatchedInternships_success() {
        InternshipName internshipName = new InternshipName("Software Engineering Intern 2024");
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        List<Company> lastShownList = expectedModel.getFilteredCompanyList();
        Company targetCompany = lastShownList.get(INDEX_FIRST_PERSON_OR_COMPANY.getZeroBased());
        Set<Internship> currInternships = targetCompany.getInternships();
        Set<Internship> internshipsToKeep = new HashSet<>();
        for (Internship internship : currInternships) {
            if (!internship.getInternshipName().equals(internshipName)) {
                internshipsToKeep.add(internship);
            }
        }
        Company updatedCompany = new CompanyBuilder(targetCompany).withInternships(internshipsToKeep).build();
        expectedModel.setCompany(targetCompany, updatedCompany);

        DeleteInternshipCommand deleteInternshipCommand = new DeleteInternshipCommand(
                INDEX_FIRST_PERSON_OR_COMPANY, internshipName
        );
        CommandTestUtil.assertRegularCommandSuccess(deleteInternshipCommand, model,
                String.format(DeleteInternshipCommand.MESSAGE_SUCCESS, internshipName), expectedModel
        );
    }

    @Test
    public void execute_deleteInternshipCompanyOutOfIndexScope_failure() {
        InternshipName internshipName = new InternshipName("Project Manager");
        DeleteInternshipCommand deleteInternshipCommand = new DeleteInternshipCommand(
                Index.fromZeroBased(100), internshipName
        );
        CommandTestUtil.assertInternshipCommandFailure(
                deleteInternshipCommand, model,
                Messages.MESSAGE_INVALID_COMPANY_DISPLAYED_INDEX);
    }

    @Test
    public void execute_deleteInternshipWithNullModel_throwsNullPointerException() {
        InternshipName internshipName = new InternshipName("Software Engineer");
        assertThrows(NullPointerException.class, () -> new DeleteInternshipCommand(
                        Index.fromOneBased(1),
                        internshipName).execute(null));
    }

    @Test
    public void execute_deleteInternshipWithNullIndex_throwsNullPointerException() {
        InternshipName internshipName = new InternshipName("Software Engineer");
        assertThrows(NullPointerException.class, () -> new DeleteInternshipCommand(
                        null,
                        internshipName).execute(model));
    }

    @Test
    public void execute_deleteInternshipWithNullInternshipName_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DeleteInternshipCommand(
                        Index.fromOneBased(1),
                        null).execute(model));
    }

    @Test
    public void equals() {
        DeleteInternshipCommand deleteFirstCommand = new DeleteInternshipCommand(
                INDEX_FIRST_PERSON_OR_COMPANY, new InternshipName("Software Engineer")
        );
        DeleteInternshipCommand deleteSecondCommand = new DeleteInternshipCommand(
                INDEX_SECOND_PERSON_OR_COMPANY, new InternshipName("Software Engineer")
        );
        DeleteInternshipCommand anotherDeleteFirstCommand = new DeleteInternshipCommand(
                INDEX_FIRST_PERSON_OR_COMPANY, new InternshipName("Project Manager")
        );

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));
        assertTrue(deleteSecondCommand.equals(deleteSecondCommand));

        // same values -> returns true
        DeleteInternshipCommand deleteFirstCommandCopy = new DeleteInternshipCommand(
                INDEX_FIRST_PERSON_OR_COMPANY, new InternshipName("Software Engineer")
        );
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different Company -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));

        // different internship name for same company -> returns False
        assertFalse(deleteFirstCommand.equals(anotherDeleteFirstCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        InternshipName internshipName = new InternshipName("Software Engineer");
        DeleteInternshipCommand deleteInternshipCommand = new DeleteInternshipCommand(
                targetIndex, internshipName
        );
        String expected = DeleteInternshipCommand.class.getCanonicalName()
                + "{targetCompanyIndex=" + targetIndex + ", "
                + "internshipName=" + internshipName + "}";
        assertEquals(expected, deleteInternshipCommand.toString());
    }
}
