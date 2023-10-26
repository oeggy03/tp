---
layout: page
title: User Guide
---
# User Guide of SOCareers
SOCareers is an **all-in-one app that helps CS majors to keep track of jobs/internship-related content**. The app allows students to keep track of company application timelines, their networks of people, and interview timelines.


- [Quick Start](#quick-start)
- [Features](#features)
  - [Adding a person to contacts](#adding-a-person-to-contacts-add-p)
  - [Adding a company to contacts](#adding-a-company-to-contacts-add-c)
  - [Deleting a person from contacts](#deleting-a-person-from-contacts-delete-p)
  - [Deleting a company from contacts](#deleting-a-company-from-contacts-delete-c)
  - [Viewing a list of all persons](#viewing-a-list-of-all-persons-list-p)
  - [Viewing a list of all companies](#viewing-a-list-of-all-companies-list-c)
  - [Viewing a person's contact](#viewing-a-persons-contact-view-p)
  - [Viewing a company's contact](#viewing-a-companys-contact-view-c)
  - [Finding a person by name or tag](#finding-a-person-by-name-or-tag-find-p)
  - [Finding a company by name or tag](#finding-a-company-by-name-or-tag-find-c)
- [FAQ](#faq)
- [Known Issues](#known-issues)
- [Command Summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## Quick start
Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add p n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`, all the parameters are compulsory to be supplied.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER e/EMAIL`, `e/EMAIL p/PHONE_NUMBER n/NAME` is also acceptable.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Adding a person to contacts: `add p`

Adds a person of your interest.

Format: `add p n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]`
* Person's `NAME`, `PHONE_NUMBER`, `EMAIL`, and `ADDRESS` are compulsory fields.
* `TAG` is optional and can be used multiple times.

Examples:
* `add p n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friend t/colleague`:
  ![add person with all information added](images/addPerson.png)

### Adding a company to contacts: `add c`

Adds a company of your interest.

Format: `add c n/COMPANY_NAME p/PHONE_NUMBER e/EMAIL d/DESCRIPTION [t/TAG]`
* Company's `COMPANY_NAME`, `PHONE_NUMBER`, `EMAIL`, and `DESCRIPTION` are compulsory fields.
* `TAG` is optional and can be used multiple times.

Examples:
* `add c n/Apple p/98765432 e/applehr@example.com d/Top tech company t/tech t/interested`:
  ![add company with all information added](images/addCompany.png)

### Adding an internship to a company contact: `add i`

Adds an internship of interest to the corresponding company.

Format: `add i INDEX n/ROLE_NAME d/DESCRIPTION [s/SCHEDULED_INTERVIEW_TIME]`
* Internship's `INDEX`, `ROLE_NAME` and `DESCRIPTION` are compulsory fields.
* `SCHEDULED_INTERVIEW_TIME` is optional and can only be used once.

Restrictions:
* `ROLE_NAME` and `DESCRIPTION` can be any non-empty string and should not be blank.
* `SCHEDULED_INTERVIEW_TIME` must be in the format `DD-MM-YYYY HH:mm`.

Examples:
* `add i 2 n/Software Engineering Intern 2024 d/Develop new features on existing software products`
* `add i 3 n/Marketing Intern 2024 d/Conduct market research and analysis s/20-02-2024 09:45`

### Deleting a person from contacts: `delete p`

Deletes the specified person from the contact book.

Format: `delete p INDEX`
* Deletes the person with the specified `INDEX` from the contact list.
* The index refers to the index number shown in the displayed persons list.
* The index must be a positive integer and not exceed the total number of persons.

### Deleting a company from contacts: `delete c`

Deletes the specified company from the contact book.

Format: `delete c INDEX`
* Deletes the company with the specified `INDEX` from the contact list.
* The index refers to the index number shown in the displayed company list.
* The index must be a positive integer and not exceed the total number of companies.

Examples:
* `list c` followed by `delete c 2` deletes the second company in the list:
  ![delete company at index 2](images/deleteCompany.png)

### Viewing a list of all persons: `list p`

Shows a list of all persons in the contact list.

Format: `list p`

### Viewing a list of all companies: `list c`

Shows a list of all companies in the contact list.

Format: `list c`

Examples:
* `list c` shows:
  ![list of all companies](images/listCompanies.png)

### Viewing a person's contact `view p`

View a single person's contact.

Format: `view p INDEX`
* Views the contact with the specified `INDEX` from the contact list.
* The index refers to the index number shown in the person contact list.
* The index must be a positive integer and not exceed the total number of contacts.

Examples:
* `list p` followed by `view p 1` views the first contact in the contact list:
  ![show the information of the first person](images/viewPerson.png)

### Viewing a company's contact: `view c`

View a single company's contact.

Format: `view c INDEX`
* Views the contact with the specified `INDEX` from the contact list.
* The index refers to the index number shown in the company contact list.
* The index must be a positive integer and not exceed the total number of contacts.

Examples:
* `list c` followed by `view c 1` views the first contact in the companies list:
  ![show the information of the first company](images/viewCompany.png)

### Finding a person by name or tag: 'find p'

Find a person by name or tag.

Format: `find p [n/KEYWORD] [t/TAG]`

Search Criteria:
* The search is case-insensitive. e.g. `john` will match `John`.
* Only the name and tags are searched.
* Persons matching at least one of the keywords and tags will be returned (i.e. OR search).

Parameters:
* `KEYWORD` is optional and can be used multiple times.
* `TAG` is optional and can be used multiple times.
* At least one of the parameters must be supplied.

Restrictions:
* `KEYWORD` and `TAG` must be alphanumeric.
* They cannot contain special characters nor spaces.
* Partial words are not supported. e.g. `Jo` will not match `John`.

Examples:
* `find p n/John Doe t/friend` returns `John Doe`:
  ![find person by name and tag](images/findPersonByNameAndTag.png)

### Finding a company by name or tag: 'find c'

Find a company by name or tag.

Format: `find c [n/KEYWORD] [t/TAG]`

Search Criteria:
* The search is case-insensitive. e.g. `apple` will match `Apple`.
* Only the name and tags are searched.
* Companies matching at least one of the keywords and tags will be returned (i.e. OR search).

Parameters:
* `KEYWORD` is optional and can be used multiple times.
* `TAG` is optional and can be used multiple times.
* At least one of the parameters must be supplied.

Restrictions:
* `KEYWORD` and `TAG` must be alphanumeric.
* They cannot contain special characters nor spaces.
* Partial words are not supported. e.g. `App` will not match `Apple`.

Examples:
* `find c n/Apple t/tech` returns `Apple`:
  ![find company by name and tag](images/findCompanyByNameAndTag.png)
### [stuff] `[coming in v1.2]`

_Details coming soon ..._
--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous SOConnect home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. There are no issues in Ba Sing Se.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action   | Format                 | Examples                                                                                                                                                                                               |
|----------|------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Add      | `add c`, `add p`       | e.g., `add p n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney`;<br/>`add c n/Apple p/98765432 e/johnd@example.com d/Top tech company t/tech t/interested` |
| Delete   | `delete c INDEX`, `delete p INDEX` | e.g., `delete p 3`                                                                                                                                                                                     |
| List     | `list c`, `list p`     |                                                                                                                                                                                                        |
| View     | `view c INDEX`, `view p INDEX`   | e.g., `view c 1`                                                                                                                                                                                       |
| Find     | `find c`, `find p`     | e.g., `find p n/John Doe t/friend`                                                                                                                                                                     |
