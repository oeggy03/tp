package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.company.Company;
import seedu.address.model.company.CompanyName;
import seedu.address.model.company.Description;
import seedu.address.model.company.CompanyEmail;
import seedu.address.model.company.CompanyPhone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Company objects.
 */
public class CompanyBuilder {

    public static final String DEFAULT_NAME = "TechCorp Inc.";
    public static final String DEFAULT_PHONE = "12345678";
    public static final String DEFAULT_EMAIL = "contact@techcorp.com";
    public static final String DEFAULT_DESCRIPTION = "A leading tech company.";

    private CompanyName name;
    private CompanyPhone phone;
    private CompanyEmail email;
    private Description description;
    private Set<Tag> tags;

    /**
     * Creates a {@code CompanyBuilder} with the default details.
     */
    public CompanyBuilder() {
        name = new CompanyName(DEFAULT_NAME);
        phone = new CompanyPhone(DEFAULT_PHONE);
        email = new CompanyEmail(DEFAULT_EMAIL);
        description = new Description(DEFAULT_DESCRIPTION);
        tags = new HashSet<>();
    }

    /**
     * Initializes the CompanyBuilder with the data of {@code companyToCopy}.
     */
    public CompanyBuilder(Company companyToCopy) {
        name = companyToCopy.getCompanyName();
        phone = companyToCopy.getCompanyPhone();
        email = companyToCopy.getCompanyEmail();
        description = companyToCopy.getDescription();
        tags = new HashSet<>(companyToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Company} that we are building.
     */
    public CompanyBuilder withName(String name) {
        this.name = new CompanyName(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Company} that we are building.
     */
    public CompanyBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Company} that we are building.
     */
    public CompanyBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Company} that we are building.
     */
    public CompanyBuilder withPhone(String phone) {
        this.phone = new CompanyPhone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Company} that we are building.
     */
    public CompanyBuilder withEmail(String email) {
        this.email = new CompanyEmail(email);
        return this;
    }

    public Company build() {
        return new Company(name, phone, email, description, tags);
    }
}
