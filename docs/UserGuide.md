---
layout: page
title: User Guide
---
# SOCareers User Guide
Welcome to the SOCareers User Guide! SOCareers is an **all-in-one app** that helps you keep track of all your
internship-related content. It is optimised for use via a Command Line Interface (CLI), allowing you to organise and 
store information more quickly than traditional Graphical User Interface (GUI) apps.

This user guide provides an in-depth documentation of the features available in SOCareers as well as a quick start
guide to get you started. 

- [Quick Start](#quick-start)
- [Features](#features)
  - [Adding a person to contacts](#adding-a-person-to-contacts-add-p)
  - [Adding a company to contacts](#adding-a-company-to-contacts-add-c)
  - [Adding an internship to a company contact](#adding-an-internship-to-a-company-contact-add-i)
  - [Deleting a person from contacts](#deleting-a-person-from-contacts-delete-p)
  - [Deleting a company from contacts](#deleting-a-company-from-contacts-delete-c)
  - [Viewing a list of all persons](#viewing-a-list-of-all-persons-list-p)
  - [Viewing a list of all companies](#viewing-a-list-of-all-companies-list-c)
  - [Viewing a person's contact](#viewing-a-persons-contact-view-p)
  - [Viewing a company's contact](#viewing-a-companys-contact-view-c)
  - [Editing a person's contact](#editing-a-persons-contact-edit-p)
  - [Editing a company's contact](#editing-a-companys-contact-edit-c)
  - [Finding a person by name or tag](#finding-a-person-by-name-or-tag-find-p)
  - [Finding a company by name or tag](#finding-a-company-by-name-or-tag-find-c)
- [FAQ](#faq)
- [Known Issues](#known-issues)
- [Command Summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `SOCareers.jar` [here]([https://github.com/AY2324S1-CS2103T-T10-4/tp/releases).

1. Move `SOCareers.jar` to the folder you want to use as the _home folder_ for SOCareers.

   * The _home folder_ is the location where SOCareers' internal data will be stored.

   * Bear in mind that the _home folder_'s contents may be changed by SOCareers.

   * It is recommended to create a new empty folder to act as a _home folder_.

1. Open a command terminal, navigate into the folder you put the jar file in using `cd` , and run the command
`java -jar SOCareers.jar` to start the application.<br>
   * A GUI similar to the one shown below should appear in a few seconds.
   * Note that the app contains some sample data.<br>
![Ui](images/Ui.png)

   (Placeholder here to remind us to have another UI image where each section of the UI is boxed up and described/explained to the user in detail. -- For CS2101)

1. Type the command in the command box and press Enter to run it.
   Here are some examples of commands you can run:

   * `list` : Lists all contacts.

   * `add p n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a person contact named `John Doe` to SOCareers.

   * `delete c 3` : Deletes the 3rd company contact shown in the current list.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.
--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add p n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`, all the parameters must be supplied.

* Items in square brackets are optional.<br>
  e.g. `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER e/EMAIL`, `e/EMAIL p/PHONE_NUMBER n/NAME` is also acceptable.

* If you are using a PDF version of this document, be careful when you copy and paste commands that span multiple lines
as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Adding a person to contacts: `add p`

Keep track of who you know easily by adding them to your contacts.

Format: `add p n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]`

Parameters
* A person's `NAME`, `PHONE_NUMBER`, `EMAIL`, and `ADDRESS` are compulsory.
* A `TAG` is optional and can be used multiple times.

Example
* `add p n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friend t/colleague`:
  ![add person with all information added](images/addPerson.png)

### Adding a company to contacts: `add c`

Effortlessly manage your list of preferred companies by adding them to your contacts.

Format: `add c n/COMPANY_NAME p/PHONE_NUMBER e/EMAIL d/DESCRIPTION [t/TAG]`

Parameters
* A company's `COMPANY_NAME`, `PHONE_NUMBER`, `EMAIL`, and `DESCRIPTION` are compulsory.
* A `TAG` is optional and can be used multiple times.

Example
* `add c n/Apple p/98765432 e/applehr@example.com d/Top tech company t/tech t/interested`:
  ![add company with all information added](images/addCompany.png)

### Adding an internship to a company contact: `add i`

Add internships that interest you to the corresponding companies.

Format: `add i INDEX n/ROLE_NAME d/DESCRIPTION [s/SCHEDULED_INTERVIEW_TIME]`
* Adds an internship to the company at the specified `INDEX` in the currently displayed contact list of companies.

Parameters
* An internship's `INDEX`, `ROLE_NAME` and `DESCRIPTION` are compulsory.
  * `INDEX` refers to the index number shown in the displayed companies list.
  * `INDEX` must be a positive integer and cannot be larger than the size of the currently displayed contact list of companies. 
  * `ROLE_NAME` and `DESCRIPTION` can be any non-empty string and should not be blank.
* `SCHEDULED_INTERVIEW_TIME` is optional and can only be used once.
  * `SCHEDULED_INTERVIEW_TIME` must be in the format `DD-MM-YYYY HH:mm`.

Examples
* `add i 2 n/Software Engineering Intern 2024 d/Develop new features on existing software products`
* `add i 3 n/Marketing Intern 2024 d/Conduct market research and analysis s/20-02-2024 09:45`

### Deleting a person from contacts: `delete p`

Keep your list of contacts for people organised by deleting contacts you no longer need.

Format: `delete p INDEX`
* `INDEX` refers to the index number shown in the currently displayed contact list of people.
* Deletes the contact of the person at the specified `INDEX` in the currently displayed contact list of people.

Parameter
* `INDEX` is compulsory.
    * `INDEX` must be a positive integer and cannot be larger than the size of the currently displayed contact list of people.

Example
* `list p` followed by `delete p 2` deletes the second person in the list:
  ![delete company at index 2](images/deletePerson.png)
### Deleting a company from contacts: `delete c`

Keep your list of contacts for companies organised by deleting contacts you no longer need.

Format: `delete c INDEX`
* `INDEX` refers to the index number shown in the currently displayed contact list of companies.
* Deletes the contact of the company at the specified `INDEX` in the currently displayed contact list of companies.

Parameter
* `INDEX` is compulsory.
    * `INDEX` must be a positive integer and cannot be larger than the size of the currently displayed contact list of companies.

Example
* `list c` followed by `delete c 2` deletes the second company in the list:
  ![delete company at index 2](images/deleteCompany.png)

### Viewing a list of all persons: `list p`

Have a quick look at all the people you know in the contact list.

Format: `list p`

* `list p` shows:
![list of all companies](images/listPersons.png)

### Viewing a list of all companies: `list c`

Have a quick look at all the companies you are interested in in the contact list.

Format: `list c`

* `list c` shows:
![list of all companies](images/listCompanies.png)

### Viewing a person's contact `view p`

Find out the specific details of your desired contact by viewing that person's contact.

Format: `view p INDEX`
* `INDEX` refers to the index number shown in the currently displayed contact list of companies.
* Views the contact with the specified `INDEX` from the contact list.

Parameter
* `INDEX` is compulsory.
    * `INDEX` must be a positive integer and cannot be larger than the size of the currently displayed contact list of people.

Example
* `list p` followed by `view p 1` views the first contact in the contact list:
  ![show the information of the first person](images/viewPerson.png)

### Viewing a company's contact: `view c`

Find out the specific details of your desired company by viewing that company's contact.

Format: `view c INDEX`
* Views the contact with the specified `INDEX` from the contact list.
* `INDEX` refers to the index number shown in the currently displayed contact list of companies.

Parameter
* `INDEX` is compulsory.
    * `INDEX` must be a positive integer and cannot be larger than the size of the currently displayed contact list of companies.

Example
* `list c` followed by `view c 1` views the first contact in the companies list:
  ![show the information of the first company](images/viewCompany.png)

### Editing a person's contact: `edit p`

Edit the information of a person's contact

Format: `edit p INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]`
* At least one of `NAME`, `PHONE_NUMBER`, `EMAIL`, `ADDRESS` and `TAG` fields should be included.

Examples:
* `edit p 1 n/John p/98765432 e/john@example.com a/311, Clementi Ave 2, #02-26 t/friend`

### Editing a company's contact: `edit c`

Edit the information of a company's contact

Format: `edit c INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [d/DESCRIPTION] [t/TAG]`
* At least one of `NAME`, `PHONE_NUMBER`, `EMAIL`, `DESCRIPTION` and `TAG` fields should be included.

Examples:
* `edit c 1 n/Alpha p/98765432 e/alpha@example.com d/A cool company t/tech`

### Finding a person by name or tag: 'find p'

Search for a particular person by their name or using a tag you have assigned them.

Format: `find p [n/KEYWORD] [t/TAG]`
* Finds a person by name or tag.

Parameters:
* At least one of the parameters must be supplied.
* `KEYWORD` and `TAG` are optional and can be used multiple times.
  * They must be alphanumeric.
  * They cannot contain special characters or spaces.

Search Constraints:
* The search is case-insensitive. e.g. `john` will match `John`.
  * Partial keywords are not supported. e.g. `Jo` will not match `John`.
* Only the name and tags are searched.
* Persons matching at least one of the keywords and tags will be returned (i.e. OR search).

Example
* `find p n/John t/friend` returns `John Doe`:
  ![find person by name and tag](images/findPersonByNameAndTag.png)

### Finding a company by name or tag: 'find c'

Search for a particular company by their name or using a tag you have assigned them.

Format: `find c [n/KEYWORD] [t/TAG]`
* Finds a company by name or tag.

Parameters:
* At least one of the parameters must be supplied.
* `KEYWORD` and `TAG` are optional and can be used multiple times.
    * They must be alphanumeric.
    * They cannot contain special characters or spaces.

Search Constraints:
* The search is case-insensitive, e.g. `apple` will match `Apple`.
    * Partial keywords are not supported, e.g. `Ap` will not match `Apple`.
* Only the name and tags are searched.
* Persons matching at least one of the keywords and tags will be returned (i.e. OR search).

Example
* `find c n/Apple t/tech` returns `Apple`:
  ![find company by name and tag](images/findCompanyByNameAndTag.png)

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

| Action | Format                             | Examples                                                                                                                                                                                              |
|--------|------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Add    | `add c`, `add p`                   | e.g., `add p n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney`;<br/>`add c n/Apple p/98765432 e/johnd@example.com d/Top tech companyt/tech t/interested` |
| Delete | `delete c INDEX`, `delete p INDEX` | e.g., `delete p 3`                                                                                                                                                                                    |
| List   | `list c`, `list p`                 |                                                                                                                                                                                                       |
| View   | `view c INDEX`, `view p INDEX`     | e.g., `view c 1`                                                                                                                                                                                      |
| Edit   | `edit c INDEX`, `edit p INDEX`     | e.g., `edit p 1 n/John p/98765432 e/john@example.com a/311, Clementi Ave 2, #02-26 t/friend`;<br> `edit c 1 n/Alpha p/98765432 e/alpha@example.com d/A cool company t/tech`                           |                                                                                                                                                                                    |
| Find     | `find c`, `find p`                 | e.g., `find p n/John Doe t/friend`                                                                                                                                                                    |


