package seedu.address.model.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.ContactIsEqualsPredicate;
import seedu.address.model.person.Person;
import seedu.address.testutil.TypicalPersons;

public class ContactIsEqualsPredicateTest {

    @Test
    public void equals() {
        Person firstPredicatePerson = TypicalPersons.ALICE;
        Person secondPredicatePerson = TypicalPersons.BENSON;

        ContactIsEqualsPredicate firstPredicate = new ContactIsEqualsPredicate(firstPredicatePerson);
        ContactIsEqualsPredicate secondPredicate = new ContactIsEqualsPredicate(secondPredicatePerson);

        // same object -> returns true
        assertEquals(firstPredicate, firstPredicate);

        // same values -> returns true
        ContactIsEqualsPredicate firstPredicateCopy = new ContactIsEqualsPredicate(firstPredicatePerson);
        assertEquals(firstPredicate, firstPredicateCopy);

        // different types -> returns false
        assertNotEquals(1, firstPredicate);

        // null -> returns false
        assertNotEquals(null, firstPredicate);

        // different person -> returns false
        assertNotEquals(firstPredicate, secondPredicate);
    }
}
