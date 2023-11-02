package seedu.address.testutil;

import static seedu.address.commons.util.DateTimeParserUtil.parseStringToDateTime;

import seedu.address.model.company.internship.Internship;

/**
 * A utility class containing a list of {@code Internship} objects to be used in tests.
 */
public class TypicalInternships {
    public static final Internship SOFTWARE_ENGINEER_WITH_DATETIME = new InternshipBuilder()
            .withInternshipName("Software Engineering Intern 2024")
            .withDescription("Produce high quality software following good architecture that are scalable")
            .withInterviewDateTime(parseStringToDateTime("20-12-2023 08:00")).build();

    public static final Internship SOFTWARE_ENGINEER_WITHOUT_DATETIME = new InternshipBuilder()
            .withInternshipName("Software Engineering Intern 2024")
            .withDescription("Develop new features/functionalities on existing software products")
            .withoutInterviewDateTime().build();

    public static final Internship DATA_ANALYST_WITH_DATETIME = new InternshipBuilder()
            .withInternshipName("Data Analyst Intern 2024")
            .withDescription("Learn data analysis tools and techniques")
            .withInterviewDateTime(parseStringToDateTime("15-01-2024 10:30"))
            .build();

    public static final Internship MARKETING_INTERN_WITHOUT_DATETIME = new InternshipBuilder()
            .withInternshipName("Marketing Intern 2024")
            .withDescription("Conduct market research and analysis")
            .withoutInterviewDateTime()
            .build();

    public static final Internship FINANCE_INTERN_WITH_DATETIME = new InternshipBuilder()
        .withInternshipName("Finance Intern 2024")
        .withDescription("Assist with financial models and forecasts")
        .withInterviewDateTime(parseStringToDateTime("25-01-2024 09:00")).build();

    public static final Internship HR_INTERN_WITHOUT_DATETIME = new InternshipBuilder()
        .withInternshipName("HR Intern 2024")
        .withDescription("Support HR tasks and operations")
        .withoutInterviewDateTime().build();

    public static final Internship UX_DESIGNER_WITH_DATETIME = new InternshipBuilder()
        .withInternshipName("UX Designer Intern 2024")
        .withDescription("Design user-centric digital interfaces")
        .withInterviewDateTime(parseStringToDateTime("24-01-2024 14:00")).build();
}
