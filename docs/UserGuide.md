---
layout: page
title: User Guide
---
# SOCareers User Guide
Welcome to the SOCareers User Guide! In this guide, we explain how to use the features available in SOCareers.

## Why choose SOCareers?
While we were applying to internships in our second year, we quickly realised how tedious it was to record everything in
various Excel sheets and Word documents, so SOCareers was born!

SOCareers is your ultimate companion to managing your professional connections and internship applications.
Designed with School of Computing (SoC) students in mind, it is optimised for use via a Command Line Interface (CLI).
If you can type fast, SOCareers enables you to organise your information more efficiently than traditional Graphical
User Interface (GUI) apps.

## How to use our guide
Our user guide provides the format of every command available in SOCareers as well as
examples to show you how to use each command.

If you are a **new user**, we recommend you look through our [Quick Start](#quick-start) guide. With installation
instructions, an overview of our GUI and a tutorial on how to use the CLI, it has everything to get you acquainted with
SOCareers!

If you are an **experienced user**, you can use the [Table of Contents](#table-of-contents) to easily find guides on your
desired commands. A [command summary](#command-summary) is also available if you prefer to have a quick reference for
our command formats!

Throughout our user guide, you will encounter different text formats or call-out boxes. Here are what they indicate:<br>
[Highlighted text](#): Links to jump to the corresponding sections in the user guide
`Monospaced text`: Command formats to guide your usage of SOCareers
<div markdown="span" class="alert alert-warning">
**:warning: Warning**<br>
Information that is important to know to prevent unexpected or undefined behaviour from SOCareers.
</div>

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
Details about parameters and their constraints to ensure SOCareers works as intended.
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
Handy tips to enhance your experience with SOCareers.
</div>

<div markdown="span" class="alert alert-secondary">
**:information_source: Additional Information**<br>
Additional information to enrich your understanding of SOCareers.
</div>

## Table of Contents
- [SOCareers User Guide](#socareers-user-guide)
  - [Why choose SOCareers?](#why-choose-socareers)
  - [How to use our guide](#how-to-use-our-guide)
  - [Table of Contents](#table-of-contents)
  - [Quick Start](#quick-start)
    - [Installation](#installation)
  - [Prefix Summary](#prefix-summary)
  - [| `end/END_TIME`               | `DD-MM-YYYY HH:mm`                                                                                                                                           | 20-02-2024 09:45            |](#-endend_time----------------dd-mm-yyyy-hhmm--------------------------------------------------------------------------------------------------------------------------------------------20-02-2024-0945------------)
  - [Features](#features)
    - [Viewing help: `help`](#viewing-help-help)
    - [Adding a person to contacts: `add p`](#adding-a-person-to-contacts-add-p)
    - [Adding a company to contacts: `add c`](#adding-a-company-to-contacts-add-c)
    - [Adding an internship to a company contact: `add i`](#adding-an-internship-to-a-company-contact-add-i)
    - [Deleting a person from contacts: `delete p`](#deleting-a-person-from-contacts-delete-p)
    - [Deleting a company from contacts: `delete c`](#deleting-a-company-from-contacts-delete-c)
    - [Deleting an internship from company: `delete i`](#deleting-an-internship-from-company-delete-i)
    - [Listing all persons: `list p`](#listing-all-persons-list-p)
    - [Listing all companies: `list c`](#listing-all-companies-list-c)
    - [Viewing a person's contact: `view p`](#viewing-a-persons-contact-view-p)
    - [Viewing a company's contact: `view c`](#viewing-a-companys-contact-view-c)
    - [Editing a person's contact: `edit p`](#editing-a-persons-contact-edit-p)
    - [Editing a company's contact: `edit c`](#editing-a-companys-contact-edit-c)
    - [Editing an internship: `edit i`](#editing-an-internship-edit-i)
    - [Finding a person by name or tag: `find p`](#finding-a-person-by-name-or-tag-find-p)
    - [Finding a company by name or tag: `find c`](#finding-a-company-by-name-or-tag-find-c)
    - [Sort companies based on internship date](#sort-companies-based-on-internship-date)
  - [FAQ](#faq)
  - [Command Summary](#command-summary)

------------------------------------------------------------------------------------------------------------------------

## Quick Start
### Installation

1. Ensure you have Java `11` or above installed in your computer by running the command
    `java --version` in your terminal.

2. Download the latest version of `SOCareers.jar` [here]([https://github.com/AY2324S1-CS2103T-T10-4/tp/releases).

3. Move `SOCareers.jar` to the home folder which is the folder you want to store SOCareers' internal data.
<div markdown="span" class="alert alert-secondary">
**:information_source: Information**<br>
The home folder's contents may be changed by SOCareers.
We recommend you to create a new empty folder to act as your home folder.
</div>

1. Open a command terminal.
2. Navigate your home folder by running the command `cd FILEPATH` where `FILEPATH` is the file path to your home folder.
3. Run the command `java -jar SOCareers.jar`  to start the application.
    * A GUI similar to the one shown below should appear in a few seconds.
    * Note that the app contains some sample data that you can later remove.
4. Our User Interface (UI) has 6 main sections:
   ![UiBoxed](images/UiBoxed.png)
    * **MenuBar**: Provides quick access to essential features of "Help" and "File".
    * **Command Box**: Allows you to type in your commands.
    * **Command Result Box**: Displays the result of running a command.
    * **Display Box**: Displays all the details of a person or a company after certain commands are run.
    * **List of People**: Displays brief details of every person added. The index, name and tags for each person are
    displayed here.
    * **List of Companies**: Displays brief details of every company added. The index, name, tags and the next
    internship interview date (represented by the "Next:" field) for each company are displayed here.
5. Type the command in the command box and press Enter to run it. Here are some examples of commands you can run:

   * `list p` : Lists all person contacts

   * `add p n/John Doe p/98765432 e/johnd@example.com a/311 Clementi Ave 2 #02-25 t/friend t/colleague`:
   Adds the person ‘John Doe’ with the following details:
     * Phone number: 98765432
     * Email: johnd@example.com
     * Address: 311 Clementi Ave 2 #02-25 
     * Tags: friends, colleagues

   * `delete c 3` : Deletes the third company contact shown in the current list.

   * `exit` : Exits the app.

<div markdown="block" class="alert alert-info">
**:information_source: Notes about the command format:**<br>

1. Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
   * e.g. in `add p n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS`, all the parameters must be supplied.

2. Items in square brackets are optional.<br>
   * e.g. `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

3. Parameters can be in any order.<br>
   * e.g. if the command specifies `n/NAME p/PHONE_NUMBER e/EMAIL`, `e/EMAIL p/PHONE_NUMBER n/NAME` is also acceptable.
</div>

<div markdown="span" class="alert alert-warning">
**:warning: Warning**<br>
If you are using a PDF version of this document, be careful when you copy and paste commands that span multiple lines
as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

You can refer to the [Prefix Summary](#prefix-summary) section for a summary on constraints on prefixes and the
[Features](#features) section below for details of each command.

## Prefix Summary
| **Prefix**                   | **Format**                                                                                                                                                   | **Example(s)**              |
|------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| `a/ADDRESS`                  | Any characters                                                                                                                                               | 311, Clementi Ave 2, #02-25 |
| `c/COMPANY_INDEX`            | A positive integer (e.g. 0, 1, 2…) that is smaller than the size of the list of companies currently displayed<br/><br>Takes in a maximum value of 2147483647 | 1, 10, 26                   |
| `d/DESCRIPTION`              | Any characters                                                                                                                                               | A streaming service company |
| `e/EMAIL `                   | local-part@domain                                                                                                                                            | johnd@example.com           |
| `i/INTERNSHIP_INDEX`         | A positive integer (e.g. 0, 1, 2…) that is smaller than the size of the list of companies currently displayed<br/><br>Takes in a maximum value of 2147483647 | 1, 10, 26                   |
| `n/COMPANY_NAME`             | Alphanumeric with spaces and the punctuation & , . -                                                                                                         | Apple Inc., AT&T            |
| `n/PERSON_NAME `             | Alphabetical with spaces                                                                                                                                     | John Doe                    |
| `n/KEYWORD `                 | Alphanumeric without spaces and the punctuation & , . -                                                                                                      | John, Doe                   |
| `p/PHONE_NUMBER`             | Numerical                                                                                                                                                    | 91234567                    |
| `s/SCHEDULED_INTERVIEW_TIME` | `DD-MM-YYYY HH:mm`                                                                                                                                           | 20-02-2024 09:45            |
| `t/TAG`                      | Alphanumeric                                                                                                                                                 | CS2103T                     |
| `start/START_TIME`           | `DD-MM-YYYY HH:mm`                                                                                                                                           | 20-02-2024 09:45            |
| `end/END_TIME`               | `DD-MM-YYYY HH:mm`                                                                                                                                           | 20-02-2024 09:45            |
------------------------------------------------------------------------------------------------------------------------

## Features

### Viewing help: `help`

Find help easily by accessing a link to our user guide.

Format: `help`

Example<br>
`help`: Provides you a link to our user guide in a pop-up box
<SCREENSHOT: help>

[Back to Table of Contents](#table-of-contents)


### Adding a person to contacts: `add p`

Keep track of who you know easily by adding them to your contacts.

Format: `add p n/PERSON_NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]`
<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* `TAG` can be used multiple times in one command.<br>
* 'NAME' can only contain alphabetical characters and spaces. No consecutive spaces are allowed.
</div>

Example
* `add p n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friends t/colleagues`: Adds the
person ‘John Doe’ with the following details:
  * Phone number: 98765432
  * Email: johnd@example.com
  * Address: 311, Clementi Ave 2, #02-25
  * Tags: friends, colleagues<br>

![add person with all information added](images/addPerson.png)

[Back to Table of Contents](#table-of-contents)

### Adding a company to contacts: `add c`

Keep track of your favourite companies effortlessly by adding them to your contacts.

Format: `add c n/COMPANY_NAME p/PHONE_NUMBER e/EMAIL d/DESCRIPTION [t/TAG]`
<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
`TAG` can be used multiple times in one command.<br>
</div><br>
<div markdown="span" class="alert alert-secondary">
**:information_source: Additional Information**<br>
Internships must be added separately using the [`add i`](#adding-an-internship-to-a-company-contact-add-i) command.
</div>

Example
* `add c n/Apple p/98765432 e/applehr@example.com d/Top tech company t/tech t/interested`: Adds the company Apple with
the following details:
  * Phone number: 98765432
  * Email: applehr@example.com
  * Description: Top tech company
  * Tags: tech, interested<br>

  ![add company with all information added](images/addCompany.png)

[Back to Table of Contents](#table-of-contents)

### Adding an internship to a company contact: `add i`

Keep track of your dream internships efficiently by adding them to their respective company contacts.

Format: `add i COMPANY_INDEX n/ROLE_NAME d/DESCRIPTION [s/SCHEDULED_INTERVIEW_TIME]`
<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `COMPANY_INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of companies currently displayed
* The `COMPANY_INDEX` depends on the currently displayed list of companies which changes as
you sort companies or search for specific companies<br>
* SCHEDULED_INTERVIEW_TIME must be in the format `DD-MM-YYYY HH:mm` and can only be used **once**
</div><br>

Example
* `list c` followed by `add i 3 n/Marketing Intern 2024 d/Conduct market research and analysis s/20-02-2024 09:45`:
Adds the internship named ‘Marketing Intern 2024’ to the third company in the list with the following details:
  * Description: Conduct market research and analysis
  * Scheduled interview time: 20 February 2024, 9.45am
<SCREENSHOT: add i>

[Back to Table of Contents](#table-of-contents)

### Deleting a person from contacts: `delete p`

Keep your list of persons organised by deleting contacts you no longer need.

Format: `delete p INDEX`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of persons currently displayed
* The `INDEX` depends on the currently displayed list of persons which changes as
you search for specific people
</div><br>

Example
* `list p` followed by `delete p 2`: Deletes the second person in the list of persons
![delete company at index 2](images/deletePerson.png)

[Back to Table of Contents](#table-of-contents)

### Deleting a company from contacts: `delete c`

Keep your list of companies organised by deleting companies you are no longer interested in.

Format: `delete c INDEX`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of companies currently displayed
* The `INDEX` depends on the currently displayed list of companies which changes as
you sort companies or search for specific companies
</div><br>

Example
* `list c` followed by `delete c 2`: Deletes the second company in the list of companies
  ![delete company at index 2](images/deleteCompany.png)

[Back to Table of Contents](#table-of-contents)

### Deleting an internship from company: `delete i`

Keep your list of internships for each company organised by deleting internships you are no longer interested in.

Format: `delete i c/COMPANY_INDEX i/INTERNSHIP_INDEX`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `COMPANY_INDEX` and `INTERNSHIP_INDEX` must each be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of their respective lists currently displayed 
* The `COMPANY_INDEX` depends on the currently displayed list of companies which changes as
you sort companies or search for specific companies
</div><br>

Example
* `list c` followed by `delete i c/2 i/1`: Deletes the first internship of the second company in the list of companies
<SCREENSHOT>

[Back to Table of Contents](#table-of-contents)

### Listing all persons: `list p`

Have a quick overview of all the people you know by viewing your list of persons.

Format: `list p`

Example<br>
`list p`: Shows the full, unfiltered list of persons currently in your contacts, as boxed in red
![list of all companies](images/listPersons.png)

[Back to Table of Contents](#table-of-contents)

### Listing all companies: `list c`

Have a quick overview of all the companies you are interested in by viewing your list of companies.

Format: `list c`

Example
* `list c`: Shows the full, unfiltered list of persons currently in your contacts, as boxed in red
  ![list of all companies](images/listCompanies.png)

[Back to Table of Contents](#table-of-contents)

### Viewing a person's contact: `view p`

Review the information you included about the people you know efficiently by viewing their contacts.

Format: `view p INDEX`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of persons currently displayed
* The `INDEX` depends on the currently displayed list of persons which changes as
you search for specific people
</div><br>

Example
* `list p` followed by `view p 1`:  Displays the first contact in the person list in the display box
  ![show the information of the first person](images/viewPerson.png)

[Back to Table of Contents](#table-of-contents)

### Viewing a company's contact: `view c`

Review the information you included about companies you are interested in and all their associated internships by
viewing their contacts.

Format: `view c INDEX`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of companies currently displayed
* The `INDEX` depends on the currently displayed list of companies which changes as
you sort companies or search for specific companies
</div><br>

Example
* `list c` followed by `view c 1`: Displays the first contact in the companies list in the display box
  ![show the information of the first company](images/viewCompany.png)

[Back to Table of Contents](#table-of-contents)

### Editing a person's contact: `edit p`

Keep your information on the people you know up-to-date by editing their contacts.

Format: `edit p INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* **At least one** of the `NAME`, `PHONE_NUMBER`, `EMAIL`, `ADDRESS` or `TAG` fields should be included
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of persons currently displayed
* The `INDEX` depends on the currently displayed list of persons which changes as you search for specific people
* TAGs can be used multiple times in one command
</div><br>

<div markdown="span" class="alert alert-warning">
**:warning: Warning**<br>
Editing the tags of a person overwrites any existing tags. Add the tags you would like to keep to the command to
ensure that they are not removed.
</div>

Example
* `edit p 1 n/John e/john@example.com a/123, Ang Mo Kio Ave 2, #02-26 t/friends`: Edits the first contact in the list of
persons to have the following new details:
  * Name: John
  * Email: john@example.com
  * Address: 123, Ang Mo Kio Ave 2, #02-26
  * Tags: friends

<SCREENSHOT>

[Back to Table of Contents](#table-of-contents)

### Editing a company's contact: `edit c`

Keep your information on the companies you are interested in up-to-date by editing their contacts.

Format: `edit c INDEX [n/COMPANY_NAME] [p/PHONE_NUMBER] [e/EMAIL] [d/DESCRIPTION] [t/TAG]`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* **At least one** of the `NAME`, `PHONE_NUMBER`, `EMAIL`, `DESCRIPTION` or `TAG` fields should be included
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of companies currently displayed
* The `INDEX` depends on the currently displayed list of companies which changes as
you sort companies or search for specific companies
* TAGs can be used multiple times in one command
</div><br>

<div markdown="span" class="alert alert-warning">
**:warning: Warning**<br>
Editing the tags of a company overwrites any existing tags. Add the tags you would like to keep to the command to
ensure that they are not removed.
</div>

Example
* `edit c 1 n/Alpha e/alpha@example.com d/A cool company t/tech`: Edits the first contact in the list of companies to
have the following new details:
  * Name: Alpha
  * Email: alpha@example.com
  * Description: A cool company
  * Tags: tech

<SCREENSHOT>

[Back to Table of Contents](#table-of-contents)

### Editing an internship: `edit i`

Keep your information on your dream internships up-to-date by editing them. 

Format: `edit i c/COMPANY_INDEX i/INTERNSHIP_INDEX [n/ROLE_NAME] [d/DESCRIPTION] [s/SCHEDULED_INTERVIEW_TIME]`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* **At least one** of the `ROLE_NAME`, `DESCRIPTION` or `SCHEDULED_INTERVIEW_TIME` fields should be included
* The `COMPANY_INDEX` and `INTERNSHIP_INDEX` must each be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of their respective lists currently displayed
* The `COMPANY_INDEX` depends on the currently displayed list of companies which changes as
you sort companies or search for specific companies
</div><br>

Example
* `edit i c/2 i/3 n/Finance Intern 2024 s/20-02-2024 09:45`: Edits the third internship of the second company in the
list of companies to have the following new details:
  * Name: Finance Intern 2024
  * Scheduled interview time: 20 February 2024, 9.45am

<SCREENSHOT>

[Back to Table of Contents](#table-of-contents)


### Finding a person by name or tag: `find p`

Find people you know in your contacts quickly by searching for them by their name or using a tag you have
assigned to them.

Format: `find p [n/KEYWORD] [t/TAG]`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* **At least one** of the `KEYWORD` or `TAG` fields should be included
* `KEYWORD` and `TAG` can be used multiple times in one command
  * KEYWORD must be alphabetical
  * TAG must be alphanumeric
  * They cannot contain spaces or special characters
</div><br>

<div markdown="span" class="alert alert-secondary">
**:information_source: Additional Information**<br>
* If the parameters are invalid, a general error message about the correct usage will be shown.
* Persons matching at least one of the keywords and tags will be returned (i.e. OR search)
* The search is case-insensitive (e.g. `john` will match `John`)
* Partial keywords are not supported (e.g. `Jo` will not match `John`)
</div>


Example
* `find p n/John t/friend`: Updates the list of persons with all matching searches and displays the first result 
John Doe in the display box
  ![find person by name and tag](images/findPersonByNameAndTag.png)

[Back to Table of Contents](#table-of-contents)

### Finding a company by name or tag: `find c`

Find a company you are interested in in your contacts quickly by searching for them by its name or
using a tag you have assigned to it.

Format: `find c [n/KEYWORD] [t/TAG]`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* **At least one** of the `KEYWORD` or `TAG` fields should be included
* `KEYWORD` and `TAG` can be used multiple times in one command
  * KEYWORD must be alphabetical
  * TAG must be alphanumeric
  * They cannot contain spaces or special characters
</div><br>

<div markdown="span" class="alert alert-secondary">
**:information_source: Additional Information**<br>
* If the parameters are invalid, a general error message about the correct usage will be shown.
* Persons matching at least one of the keywords and tags will be returned (i.e. OR search)
* The search is case-insensitive (e.g. `apple` will match `Apple`)
* Partial keywords are not supported (e.g. `Ap` will not match `Apple`)
</div>

Example
* `find c n/Apple t/tech`: Updates the list of companies with all matching searches and displays
the first result Apple in the display box:  
  ![find company by name and tag](images/findCompanyByNameAndTag.png)

[Back to Table of Contents](#table-of-contents)

### Sort companies based on internship date

Sort all companies that have internships in the specified time period and display them in order of their most recent interview date (in the specified time period).

Format: `sort c [start/START_DATETIME] [end/END_DATETIME]`

Parameters:
* `START_DATETIME` and `END_DATETIME` must be in the format `DD-MM-YYYY HH:mm`.
* `START_DATETIME` and `END_DATETIME` are optional and each can only be used once.
* `START_DATETIME` must be before `END_DATETIME`.
* `START_DATETIME` and `END_DATETIME` may be in the past or future.

Expected behaviour:
* If the parameters are invalid, a general error message about the correct usage will be shown. (Coming soon: specific error messages. Refer to DG for more information.)
* Even if `START_DATETIME` and `END_DATETIME` are not specified, only companies with internships will be returned.
* If `START_DATETIME` or (and) `END_DATETIME` are specified, only companies with internships in the specified time period will be returned.
* Companies that have internships in the specified time period will be sorted in order of their most recent interview date (only internships in the specified time period will be considered in sorting). But the `next` field of the company will not be updated, regardless of whether they are in the specified time period. Also, if you view a specific company, all its internships will be shown, regardless of whether they are in the specified time period.
* `START_DATETIME` and `END_DATETIME` are non-inclusive, i.e. internships on `START_DATETIME` or `END_DATETIME` will not be considered.
* If there are no companies with internships in the specified time period, an empty list will be returned.
* If there are no companies with internships, an empty list will be returned.
* If there are no companies, an empty list will be returned.

Examples:
* `sort c start/01-02-2024 00:01 end/01-04-2024 00:01` returns `Microsoft` and `Amazon`:
  ![sort companies by interview date](images/sortCompaniesByInterviewDate.png)

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous SOConnect home folder.

--------------------------------------------------------------------------------------------------------------------

## Command Summary

| Action | Format                            | Examples                                                                                                                                                                                              |
|--------|-----------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Add    | `add c`, `add p`                  | e.g., `add p n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney`;<br/>`add c n/Apple p/98765432 e/johnd@example.com d/Top tech companyt/tech t/interested` |
| Delete | `delete c INDEX`, `delete p INDEX` | e.g., `delete p 3`                                                                                                                                                                                    |
| List   | `list c`, `list p`                |                                                                                                                                                                                                       |
| View   | `view c INDEX`, `view p INDEX`    | e.g., `view c 1`                                                                                                                                                                                      |
| Edit   | `edit c INDEX`, `edit p INDEX`    | e.g., `edit p 1 n/John p/98765432 e/john@example.com a/311, Clementi Ave 2, #02-26 t/friend`;<br> `edit c 1 n/Alpha p/98765432 e/alpha@example.com d/A cool company t/tech`                           |                                                                                                                                                                                    |
| Find     | `find c`, `find p`                | e.g., `find p n/John Doe t/friend`                                                                                                                                                                    |
| Sort and filter | `sort c`                          | e.g., `sort c start/01-02-2024 00:01 end/01-04-2024 00:01`                                                                                                                                            |


