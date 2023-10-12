package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class ContactIsEqualsPredicate implements Predicate<Person> {
    private final Person person;

    public ContactIsEqualsPredicate(Person person) {
        this.person = person;
    }

    @Override
    public boolean test(Person otherPerson) {
        return this.person.equals(otherPerson);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ContactIsEqualsPredicate)) {
            return false;
        }

        ContactIsEqualsPredicate otherContactIsEqualsPredicate = (ContactIsEqualsPredicate) other;
        return this.person.equals(otherContactIsEqualsPredicate.person);
    }

    @Override
    public String toString() {
        return this.person.toString();
    }
}
