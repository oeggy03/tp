package seedu.address.model.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalCompanies.APPLE;
import static seedu.address.testutil.TypicalCompanies.MICROSOFT;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.CompanyBuilder;

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
        Company editedApple = new CompanyBuilder(APPLE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
            .withDescription("Another description").withTags(VALID_TAG_HUSBAND).build();
        assertTrue(APPLE.isSameCompany(editedApple));

        // different name, all other attributes same -> returns false
        editedApple = new CompanyBuilder(APPLE).withName(VALID_NAME_BOB).build();
        assertFalse(APPLE.isSameCompany(editedApple));

        // name differs in case, all other attributes same -> returns false
        Company editedMicrosoft = new CompanyBuilder(MICROSOFT).withName(VALID_NAME_BOB.toLowerCase()).build();
        assertFalse(MICROSOFT.isSameCompany(editedMicrosoft));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
        editedMicrosoft = new CompanyBuilder(MICROSOFT).withName(nameWithTrailingSpaces).build();
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
        Company editedApple = new CompanyBuilder(APPLE).withName(VALID_NAME_BOB).build();
        assertNotEquals(APPLE, editedApple);

        // different phone -> returns false
        editedApple = new CompanyBuilder(APPLE).withPhone(VALID_PHONE_BOB).build();
        assertNotEquals(APPLE, editedApple);

        // different email -> returns false
        editedApple = new CompanyBuilder(APPLE).withEmail(VALID_EMAIL_BOB).build();
        assertNotEquals(APPLE, editedApple);

        // different description -> returns false
        editedApple = new CompanyBuilder(APPLE).withDescription("Another description").build();
        assertNotEquals(APPLE, editedApple);

        // different tags -> returns false
        editedApple = new CompanyBuilder(APPLE).withTags(VALID_TAG_HUSBAND).build();
        assertNotEquals(APPLE, editedApple);
    }

    @Test
    public void toStringMethod() {
        String expected = Company.class.getCanonicalName()
            + "{name=" + APPLE.getCompanyName() + ", phone=" + APPLE.getCompanyPhone()
            + ", email=" + APPLE.getCompanyEmail() + ", description="
            + APPLE.getDescription() + ", tags=" + APPLE.getTags() + "}";
        assertEquals(expected, APPLE.toString());
    }
}