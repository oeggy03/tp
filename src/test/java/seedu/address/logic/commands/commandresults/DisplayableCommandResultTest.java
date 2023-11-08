package seedu.address.logic.commands.commandresults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalCompanies.APPLE;
import static seedu.address.testutil.TypicalCompanies.GOOGLE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.CARL;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.company.Company;
import seedu.address.model.person.Person;

public class DisplayableCommandResultTest {
    private final Person testPerson1 = BENSON;
    private final Person testPerson2 = CARL;
    private final Company testCompany1 = APPLE;
    private final Company testCompany2 = GOOGLE;
    private final String testDisplayMessage1 = "Test 1: Entity displayed!";
    private final String testDisplayMessage2 = "Test 2: Entity displayed!";

    private DisplayableCommandResult personCommandResult;
    private DisplayableCommandResult companyCommandResult;

    @BeforeEach
    public void setUp() {
        this.personCommandResult =
                new DisplayableCommandResult("feedback", testPerson1, testDisplayMessage1);
        this.companyCommandResult =
                new DisplayableCommandResult("feedback", testCompany1, testDisplayMessage1);
    }

    @Test
    public void displayableCommandResultTest() {
        assertTrue(personCommandResult.isDisplayableCommandResult());
        assertTrue(companyCommandResult.isDisplayableCommandResult());
    }

    @Test
    public void getPersonToDisplayTest() {
        assertEquals(personCommandResult.getPersonToDisplay(), Optional.of(testPerson1));
        assertEquals(companyCommandResult.getPersonToDisplay(), Optional.empty());
    }

    @Test
    public void getCompanyToDisplayTest() {
        assertEquals(personCommandResult.getCompanyToDisplay(), Optional.empty());
        assertEquals(companyCommandResult.getCompanyToDisplay(), Optional.of(testCompany1));
    }

    @Test
    public void equals() {
        //--------------------------Tests for Person being displayed----------------------------------------------------
        // same values -> returns true
        assertTrue(personCommandResult.equals(
                new DisplayableCommandResult("feedback", testPerson1, testDisplayMessage1)));

        // same object -> returns true
        assertTrue(personCommandResult.equals(personCommandResult));

        // null -> returns false
        assertFalse(personCommandResult.equals(null));

        // different types -> returns false
        assertFalse(personCommandResult.equals(0.5f));

        // different entity to display-> returns false
        assertFalse(personCommandResult.equals(companyCommandResult));

        // different feedbackToUser value -> returns false
        assertFalse(personCommandResult.equals(
                new DisplayableCommandResult("different", testPerson1, testDisplayMessage1)));

        // different personToDisplay value -> returns false
        assertFalse(personCommandResult.equals(
                new DisplayableCommandResult("feedback", testPerson2, testDisplayMessage1)));

        // different textToDisplay value -> returns false
        assertFalse(personCommandResult.equals(
                new DisplayableCommandResult("feedback", testPerson1, testDisplayMessage2)));

        //--------------------------Tests for Company being displayed---------------------------------------------------
        // same values -> returns true
        assertTrue(companyCommandResult.equals(
                new DisplayableCommandResult("feedback", testCompany1, testDisplayMessage1)));

        // same object -> returns true
        assertTrue(companyCommandResult.equals(companyCommandResult));

        // null -> returns false
        assertFalse(companyCommandResult.equals(null));

        // different types -> returns false
        assertFalse(companyCommandResult.equals(0.5f));

        // different entity to display-> returns false
        assertFalse(companyCommandResult.equals(personCommandResult));

        // different feedbackToUser value -> returns false
        assertFalse(companyCommandResult.equals(
                new DisplayableCommandResult("different", testCompany1, testDisplayMessage1)));

        // different companyToDisplay value -> returns false
        assertFalse(companyCommandResult.equals(
                new DisplayableCommandResult("feedback", testCompany2, testDisplayMessage1)));

        // different textToDisplay value -> returns false
        assertFalse(companyCommandResult.equals(
                new DisplayableCommandResult("feedback", testCompany1, testDisplayMessage2)));
    }

    @Test
    public void hashcode() {

        //--------------------------Tests for Person being displayed----------------------------------------------------
        // same values -> returns same hashcode
        assertEquals(personCommandResult.hashCode(),
                new DisplayableCommandResult("feedback", testPerson1, testDisplayMessage1).hashCode());

        // different feedbackToUser value -> returns different hashcode
        assertNotEquals(personCommandResult.hashCode(),
                new DisplayableCommandResult("different", testPerson1, testDisplayMessage1).hashCode());

        // different personToDisplay value -> returns different hashcode
        assertNotEquals(personCommandResult.hashCode(),
                new DisplayableCommandResult("feedback", testPerson2, testDisplayMessage1).hashCode());

        // different textToDisplay value -> returns different hashcode
        assertNotEquals(personCommandResult.hashCode(),
                new DisplayableCommandResult("feedback", testPerson1, testDisplayMessage2).hashCode());

        //--------------------------Tests for Company being displayed---------------------------------------------------
        // same values -> returns same hashcode
        assertEquals(companyCommandResult.hashCode(),
                new DisplayableCommandResult("feedback", testCompany1, testDisplayMessage1).hashCode());

        // different feedbackToUser value -> returns different hashcode
        assertNotEquals(companyCommandResult.hashCode(),
                new DisplayableCommandResult("different", testCompany1, testDisplayMessage1).hashCode());

        // different companyToDisplay value -> returns different hashcode
        assertNotEquals(companyCommandResult.hashCode(),
                new DisplayableCommandResult("feedback", testCompany2, testDisplayMessage1).hashCode());

        // different textToDisplay value -> returns different hashcode
        assertNotEquals(companyCommandResult.hashCode(),
                new DisplayableCommandResult("feedback", testCompany1, testDisplayMessage2).hashCode());

    }

    @Test
    public void toStringMethod() {
        String expectedPerson = DisplayableCommandResult.class.getCanonicalName() + "{feedbackToUser="
                + personCommandResult.getFeedbackToUser() + ", showHelp=" + personCommandResult.isShowHelp()
                + ", exit=" + personCommandResult.isExit()
                + ", personToDisplay=" + personCommandResult.getPersonToDisplay().get() + "}";

        assertEquals(expectedPerson, personCommandResult.toString());

        String expectedCompany = DisplayableCommandResult.class.getCanonicalName() + "{feedbackToUser="
                + companyCommandResult.getFeedbackToUser() + ", showHelp=" + companyCommandResult.isShowHelp()
                + ", exit=" + companyCommandResult.isExit()
                + ", companyToDisplay=" + companyCommandResult.getCompanyToDisplay().get() + "}";

        assertEquals(expectedCompany, companyCommandResult.toString());
    }
}
