package seedu.address.model.util;

import static seedu.address.model.util.SampleDataUtil.getTagSet;

import seedu.address.model.company.Company;
import seedu.address.model.company.CompanyName;
import seedu.address.model.company.Description;
import seedu.address.model.company.Email;
import seedu.address.model.company.Phone;

/**
 * Returns some sample data for companies.
 */
public class CompanySampleDataUtil {
    public static Company[] getSampleCompanies() {
        return new Company[] {
            new Company(new CompanyName("Apple Inc."), new Phone("12345678"), new Email("apple@example.com"),
                    new Description("A technology company."), getTagSet("tech", "innovative", "MANGA")),
            new Company(new CompanyName("Microsoft Corporation"), new Phone("23456789"),
                    new Email("microsoft@example.com"),
                    new Description("A multinational technology company."), getTagSet("tech", "windows")),
            new Company(new CompanyName("Google LLC"), new Phone("34567890"), new Email("google@example.com"),
                    new Description("An internet-related services and products company."),
                    getTagSet("tech", "search", "MANGA")),
            new Company(new CompanyName("Amazon.com Inc."), new Phone("45678901"), new Email("amazon@example.com"),
                    new Description("An online retailer and cloud services company."), getTagSet()),
            new Company(new CompanyName("Netflix Inc."), new Phone("56789012"), new Email("netflix@example.com"),
                    new Description("A streaming service company."), getTagSet()),
            new Company(new CompanyName("Facebook, Inc."), new Phone("67890123"), new Email("facebook@example.com"),
                    new Description("A social media and technology company."),
                    getTagSet("social", "advertising")),
            new Company(new CompanyName("Tesla, Inc."), new Phone("78901234"), new Email("tesla@example.com"),
                    new Description("An electric vehicle and clean energy company."),
                    getTagSet("automotive", "sustainability"))
        };

    }
}
