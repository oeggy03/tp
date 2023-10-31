package seedu.address.model.company;

import org.junit.jupiter.api.Test;
import seedu.address.model.company.internship.Internship;
import seedu.address.testutil.CompanyBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalCompanies.APPLE;
import static seedu.address.testutil.TypicalCompanies.MICROSOFT;
import static seedu.address.testutil.TypicalInternships.MARKETING_INTERN_WITHOUT_DATETIME;

public class CompanyTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Company company = new CompanyBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> company.getTags().remove(0));
    }

    @Test
    public void isSameCompany() {
        // same object -> returns true
        assertTrue(APPLE.isSameCompany(APPLE));

        // null -> returns false
        assertFalse(APPLE.isSameCompany(null));

        // same name, all other attributes different -> returns true
        Company editedApple = new CompanyBuilder(APPLE)
                .withCompanyPhone(VALID_PHONE_BOB).withCompanyEmail(VALID_EMAIL_BOB)
                .withDescription("Another description").withTags(VALID_TAG_HUSBAND).build();
        assertTrue(APPLE.isSameCompany(editedApple));

        // different name, all other attributes same -> returns false
        editedApple = new CompanyBuilder(APPLE).withCompanyName(VALID_NAME_BOB).build();
        assertFalse(APPLE.isSameCompany(editedApple));

        // name differs in case, all other attributes same -> returns false
        Company editedMicrosoft = new CompanyBuilder(MICROSOFT).withCompanyName(VALID_NAME_BOB.toLowerCase()).build();
        assertFalse(MICROSOFT.isSameCompany(editedMicrosoft));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
        editedMicrosoft = new CompanyBuilder(MICROSOFT).withCompanyName(nameWithTrailingSpaces).build();
        assertFalse(MICROSOFT.isSameCompany(editedMicrosoft));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Company appleCopy = new CompanyBuilder(APPLE).build();
        assertEquals(APPLE, appleCopy);

        // same object -> returns true
        assertEquals(APPLE, APPLE);

        // null -> returns false
        assertNotEquals(null, APPLE);

        // different type -> returns false
        assertNotEquals(5, APPLE);

        // different company -> returns false
        assertNotEquals(APPLE, MICROSOFT);

        // different name -> returns false
        Company editedApple = new CompanyBuilder(APPLE).withCompanyName(VALID_NAME_BOB).build();
        assertNotEquals(APPLE, editedApple);

        // different phone -> returns false
        editedApple = new CompanyBuilder(APPLE).withCompanyPhone(VALID_PHONE_BOB).build();
        assertNotEquals(APPLE, editedApple);

        // different email -> returns false
        editedApple = new CompanyBuilder(APPLE).withCompanyEmail(VALID_EMAIL_BOB).build();
        assertNotEquals(APPLE, editedApple);

        // different description -> returns false
        editedApple = new CompanyBuilder(APPLE).withDescription("Another description").build();
        assertNotEquals(APPLE, editedApple);

        // different tags -> returns false
        editedApple = new CompanyBuilder(APPLE).withTags(VALID_TAG_HUSBAND).build();
        assertNotEquals(APPLE, editedApple);

        // different internships -> returns false
        System.out.println("hello hello");
        List<Internship> listy = APPLE.getInternshipList();
        editedApple = new CompanyBuilder(APPLE).withInternships(MARKETING_INTERN_WITHOUT_DATETIME).build();
        assertNotEquals(APPLE, editedApple);
    }

    @Test
    public void toStringMethod() {
        String expected = Company.class.getCanonicalName()
            + "{\nname=" + APPLE.getCompanyName() + ", \nphone=" + APPLE.getCompanyPhone()
            + ", \nemail=" + APPLE.getCompanyEmail() + ", \ncompanyDescription="
            + APPLE.getCompanyDescription() + ", \ntags=" + APPLE.getTags() + ", \ninternships="
            + APPLE.getInternshipList() + "}";
        assertEquals(expected, APPLE.toString());
    }
}
