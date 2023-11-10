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
1. [Quick Start](#quick-start)
1. [Features](#features)
   1. [Viewing the User Guide](#viewing-the-user-guide-help)
   1. [Adding a contact](#adding-a-contact-add)
      1. [Adding a person to contacts](#adding-a-person-to-contacts-add-p)
      2. [Adding a company to contacts](#adding-a-company-to-contacts-add-c)
      3. [Adding an internship to a company contact](#adding-an-internship-to-a-company-contact-add-i)
   2. [Listing contacts](#listing-contacts-list)
      1. [Listing all persons](#listing-all-persons-list-p)
      2. [Listing all companies](#listing-all-companies-list-c)
   3. [Deleting a contact](#deleting-a-contact-delete)
      1. [Deleting a person from contacts](#deleting-a-person-from-contacts-delete-p)
      2. [Deleting a company from contacts](#deleting-a-company-from-contacts-delete-c)
      3. [Deleting an internship from a company contact](#deleting-an-internship-from-a-company-contact-delete-i)
   4. [Viewing a contact](#viewing-a-contact-view)
      1. [Viewing a person's contact](#viewing-a-persons-contact-view-p)
      2. [Viewing a company's contact](#viewing-a-companys-contact-view-c)
   5. [Editing a contact](#editing-a-contact-edit)
      1. [Editing a person's contact](#editing-a-persons-contact-edit-p)
      2. [Editing a company's contact](#editing-a-companys-contact-edit-c)
      3. [Editing an internship](#editing-an-internship-edit-i)
   6. [Finding a contact](#finding-a-contact-find)
      1. [Finding a person by name or tag](#finding-a-person-by-name-or-tag-find-p)
      2. [Finding a company by name or tag](#finding-a-company-by-name-or-tag-find-c)
   7. [Sorting contacts](#sorting-contacts-sort)
      1. [Sorting companies based on internship date](#sorting-companies-based-on-internship-date-sort-c)
   8. [Clearing all contacts](#clearing-all-contacts-clear)
   8. [Exiting SOCareers](#exiting-socareers-exit)
3. [FAQ](#faq)
4. [Known Limitations](#known-limitations)
5. [Command Summary](#command-summary)

------------------------------------------------------------------------------------------------------------------------

## Quick Start
### Installation

1. Ensure you have Java `11` or above installed in your computer by running the command
    `java --version` in your terminal.

2. Download the latest version of `SOCareers.jar` [here](https://github.com/AY2324S1-CS2103T-T10-4/tp/releases).

3. Move `SOCareers.jar` to the home folder which is the folder you want to store SOCareers' internal data.
<div markdown="span" class="alert alert-secondary">
**:information_source: Information**<br>
The home folder's contents may be changed by SOCareers.
We recommend you to create a new empty folder to act as your home folder.
</div>

### Running SOCareers
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
    * **List of Persons**: Displays brief details of every person added. The index, name and tags for each person are
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

---

## Features

### Viewing the User Guide: `help`

Find help easily by accessing a link to our user guide.

Format: `help`

Example<br>
`help`: Provides you a link to our user guide in a pop-up box
![help pop up box with link to this User Guide](images/help.png)

[Back to Table of Contents](#table-of-contents)

### Adding a contact: `add`

#### Adding a person to the list of persons: `add p`

Keep track of who you know easily by adding them to your contacts.

Format: `add p n/PERSON_NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]`
<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* `TAG` can be used multiple times in one command.<br>
* 'NAME' can only contain alphabetical characters and spaces. No consecutive spaces are allowed.
</div>

**Example**
* `add p n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friends t/colleagues`: Adds the
person named ‘John Doe’ to the list of persons with the following details:
  * Phone number: 98765432
  * Email: johnd@example.com
  * Address: 311, Clementi Ave 2, #02-25
  * Tags: friends, colleagues<br>

* After the command is run, the output in the Ui should be similar to the one shown here. The person is added to the list of persons, as highlighted in the red box:
![add person with all information added](images/addPerson.png)

[Back to Table of Contents](#table-of-contents)

#### Adding a company to contacts: `add c`

Keep track of your favourite companies effortlessly by adding them to your contacts.

Format: `add c n/COMPANY_NAME p/PHONE_NUMBER e/EMAIL d/DESCRIPTION [t/TAG]`
<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
`TAG` can be used multiple times in one command.<br>
</div>
<div markdown="span" class="alert alert-secondary">
**:information_source: Additional Information**<br>
Internships must be added separately using the [`add i`](#adding-an-internship-to-a-company-contact-add-i) command.
</div>

**Example**
* `add c n/TikTok p/98765432 e/tiktokHiring@example.com d/Top Tech Company t/tech t/interested`: Adds the company named ‘TikTok’ to the list of companies with
the following details:
  * Phone number: 98765432
  * Email: tiktokHiring@example.com
  * Description: Top Tech Company
  * Tags: tech, interested<br>

* After the command is run, the output in the Ui should be similar to the one shown here. The company is added to the list of companies, as highlighted in the red box:
![add company with all information added](images/addCompany.png)

[Back to Table of Contents](#table-of-contents)

#### Adding an internship to a company contact: `add i`

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
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* You can use the command [`list c`](#listing-all-companies-list-c) to view all the companies and their indexes before running this command.
* You can use the command [`view c`](#viewing-a-companys-contact-view-c) to view company and the added internship, after running this command.
Note that the added internship may not always appear at the bottom of the list of internships! The list of internships is sorted by the scheduled interview time.
</div>

**Example**
* `add i 3 n/Marketing Intern 2024 d/Conduct market research and analysis s/20-02-2024 09:45`:
Adds the internship named ‘Marketing Intern 2024’ to the third company in the list with the following details:
  * Description: Conduct market research and analysis
  * Scheduled interview time: 20 February 2024, 9.45am

* After the command is run, the output in the Ui should be similar to the one shown here:
![add internships with all information added](images/addInternship.png)

[Back to Table of Contents](#table-of-contents)

### Listing contacts: `list`
#### Listing all persons: `list p`

Have a quick overview of all the persons you know by viewing your list of persons.

Format: `list p`

**Example**
* `list p`: Shows the full, unfiltered list of persons currently in your contacts
* After the command is run, the output in the Ui should be similar to the one shown here. The full list of companies is shown, as highlighted in red:
![list of all companies](images/listPersons.png)

[Back to Table of Contents](#table-of-contents)

#### Listing all companies: `list c`

Have a quick overview of all the companies you are interested in by viewing your list of companies.

Format: `list c`

**Example**
* `list c`: Shows the full, unfiltered list of companies currently in your contacts
* After the command is run, the output in the Ui should be similar to the one shown here. The full list of companies is shown, as highlighted in red:
  ![list of all companies](images/listCompanies.png)

[Back to Table of Contents](#table-of-contents)

### Deleting a contact: `delete`
#### Deleting a person from contacts: `delete p`

Keep your list of persons organised by deleting contacts you no longer need.

Format: `delete p INDEX`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of persons currently displayed
* The `INDEX` depends on the currently displayed list of persons which changes as
you search for specific persons
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* You can use the command [`list p`](##listing-all-persons-list-p) to view all the persons and their indexes before running this command.
</div>

**Example**
* `delete p 2`: Deletes the second person in the list of persons
* After the command is run, the output in the Ui should be similar to the one shown here:
![delete company at index 2](images/deletePerson.png)

[Back to Table of Contents](#table-of-contents)

#### Deleting a company from contacts: `delete c`

Keep your list of companies organised by deleting companies you are no longer interested in.

Format: `delete c INDEX`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of companies currently displayed
* The `INDEX` depends on the currently displayed list of companies which changes as
you sort companies or search for specific companies
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* You can use the command [`list c`](#listing-all-companies-list-c) to view all the companies and their indexes before running this command.
</div>

**Example**
* `delete c 2`: Deletes the second company in the list of companies
* After the command is run, the output in the Ui should be similar to the one shown here:
  ![delete company at index 2](images/deleteCompany.png)

[Back to Table of Contents](#table-of-contents)

#### Deleting an internship from a company contact: `delete i`

Keep your list of internships for each company organised by deleting internships you are no longer interested in.

Format: `delete i c/COMPANY_INDEX i/INTERNSHIP_INDEX`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `COMPANY_INDEX` and `INTERNSHIP_INDEX` must each be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of their respective lists currently displayed 
* The `COMPANY_INDEX` depends on the currently displayed list of companies which changes as
you sort companies or search for specific companies
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* You can use the command [`list c`](#listing-all-companies-list-c) to view all companies and their indexes before running this command.
* You can use the command [`view c`](#viewing-a-companys-contact-view-c) to view the company, all its internship and their indexes before running this command.
</div>

**Example**
* `delete i c/2 i/1`: Deletes the first internship of the second company in the list of companies
* After the command is run, the output in the Ui should be similar to the one shown here. The company which you just deleted the internship from will also be shown in the display box, as highlighted in red:
  ![delete internship at company index 2 and internship index 1](images/deleteInternship.png)

[Back to Table of Contents](#table-of-contents)

### Viewing a contact: `view`
#### Viewing a person's contact: `view p`

Review the information you included about the persons you know efficiently by viewing their contacts.

Format: `view p INDEX`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of persons currently displayed
* The `INDEX` depends on the currently displayed list of persons which changes as
you search for specific persons
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* You can use the command [`list p`](##listing-all-persons-list-p) to view all the persons and their indexes before running this command.
</div>

**Example**
* `view p 1`:  Displays the first contact in the person list in the display box
* After the command is run, the output in the Ui should be similar to the one shown here:
  ![show the information of the first person](images/viewPerson.png)

[Back to Table of Contents](#table-of-contents)

#### Viewing a company's contact: `view c`

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
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* You can use the command [`list c`](#listing-all-companies-list-c) to view all the companies and their indexes before running this command.
</div>

**Example**
* `view c 1`: Displays the first contact in the companies list in the display box
* After the command is run, the output in the Ui should be similar to the one shown here:
  ![show the information of the first company](images/viewCompany.png)

[Back to Table of Contents](#table-of-contents)

### Editing a contact: `edit`
#### Editing a person's contact: `edit p`

Keep your information on the persons you know up-to-date by editing their contacts.

Format: `edit p INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]`

<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* **At least one** of the `NAME`, `PHONE_NUMBER`, `EMAIL`, `ADDRESS` or `TAG` fields should be included
* The `INDEX` must be:
    * a positive integer (e.g. 0, 1, 2…) with a maximum value of 2147483647
    * smaller than the size of the list of persons currently displayed
* The `INDEX` depends on the currently displayed list of persons which changes as you search for specific persons
* For unspecified parameters, the original value of that parameter for the person will be kept
* TAGs can be used multiple times in one command
</div>

<div markdown="span" class="alert alert-warning">
**:warning: Warning**<br>
Editing the tags of a person overwrites any existing tags. Add the tags you would like to keep to the command to
ensure that they are not removed.
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* You can use the command [`list p`](#listing-all-persons-list-p) to view all the companies and their indexes before running this command.
* You can use the command [`view p`](#viewing-a-persons-contact-view-p) to view the person and their updated details.
</div>

**Example**
* `edit p 1 n/Tim e/tim@example.com a/123, Ang Mo Kio Ave 2, #02-26 t/friends`: Edits the first contact in the list of
persons to have the following new details:
  * Name: Tim
  * Email: tim@example.com
  * Address: 123, Ang Mo Kio Ave 2, #02-26
  * Tags: friends
* After the command is run, the output in the Ui should be similar to the one shown here. The person's corresponding entry in the list of persons will also update, as highlighted in red:
  ![edit the information of the first person](images/editPerson.png)

[Back to Table of Contents](#table-of-contents)

#### Editing a company's contact: `edit c`

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
* For unspecified parameters, the original value of that parameter for the company will be kept
* TAGs can be used multiple times in one command
</div>

<div markdown="span" class="alert alert-warning">
**:warning: Warning**<br>
Editing the tags of a company overwrites any existing tags. Add the tags you would like to keep to the command to
ensure that they are not removed.
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* You can use the command [`list c`](#listing-all-companies-list-c) to view all the companies and their indexes before running this command.
* You can use the command [`view c`](#viewing-a-companys-contact-view-c) to view the person and their updated details.
</div>

**Example**
* `edit c 1 n/AlphaGrep e/alphaGrep@example.com d/A cool company t/tech`: Edits the first contact in the list of companies to
have the following new details:
  * Name: AlphaGrep
  * Email: alphaGrep@example.com
  * Description: A cool company
  * Tags: tech
* After the command is run, the output in the Ui should be similar to the one shown here. The company's corresponding entry in the list of companies will also update, as highlighted in red:
  ![edit the information of the first company](images/editCompany.png)

[Back to Table of Contents](#table-of-contents)

#### Editing an internship: `edit i`

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
* For unspecified parameters, the original value of that parameter for the internship will be kept
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* You can use the command [`list c`](#listing-all-companies-list-c) to view all the companies and their indexes before running this command.
* You can use the command [`view c`](#viewing-a-companys-contact-view-c) to view the company, its internships and their indexes before running this command.
* The position (index) of the internship may change after editing! This is due to the list of internships being sorted, with the internship with the earliest scheduled time displayed first.
</div>

**Example**
* `edit i c/1 i/1 n/Finance Intern 2024 s/20-02-2024 09:45`: Edits the first internship of the first company in the
list of companies to have the following new details:
  * Name: Finance Intern 2024
  * Scheduled interview time: 20 February 2024, 9.45am
* After the command is run, the output in the Ui should be similar to the one shown here. The internship entry will update and might move to a different position on the list, as highlighted in red:
  ![edit the information of the second company first internship](images/editInternship.png)

[Back to Table of Contents](#table-of-contents)

### Finding a contact: `find`
#### Finding a person by name or tag: `find p`

Find persons you know in your contacts quickly by searching for them by their name or using a tag you have
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

**Example**
* `find p n/John t/friend`: Updates the list of persons by listing only those who match the specified name or tag
* After the command is run, the output in the UI should be similar to the one shown here. Only the persons matching the specified name or tag will be listed, as highlighted in red:
![find person all params](images/findPersonByNameAndTag.png)

[Back to Table of Contents](#table-of-contents)

#### Finding a company by name or tag: `find c`

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

**Example**
* `find c n/AlphaGrep t/tech`: Updates the list of companies by listing only those who match the specified name or tag
* After the command is run, the output in the Ui should be similar to the one shown here. Only the companies matching the specified name or tag will be listed, as highlighted in red:
  ![find person all params](images/findCompanyByNameAndTag.png)

[Back to Table of Contents](#table-of-contents)

### Sorting contacts: `sort`
####  Sorting companies based on internship date: `sort c`

Sort all companies that have internships in the specified time period and display them in order of their most recent scheduled interview time (in the specified time period).

Format: `sort c [start/START_DATETIME] [end/END_DATETIME]`
<div markdown="span" class="alert alert-info">
**:pencil: Parameter Information**<br>
* `START_DATETIME` and `END_DATETIME` must be in the format `DD-MM-YYYY HH:mm`.
* `START_DATETIME` and `END_DATETIME` are optional and each can only be used once.
* `START_DATETIME` must be before `END_DATETIME`.
   * No companies or error message will be shown otherwise.
* `START_DATETIME` and `END_DATETIME` may be in the past or future.
</div><br>

<div markdown="span" class="alert alert-secondary">
**:information_source: Additional Information**<br>
* Companies that have internships in the specified time period will be sorted in order of their most recent interview date.
* If a time period is specified, only internships with interview dates in the specified time period will be considered in sorting.
* The `Next` field of the company will not be updated with this command, nor will the internships shown when executing the `view c` command.
* Even if `START_DATETIME` and `END_DATETIME` are not specified, only companies with internships will be shown.
* If `START_DATETIME` and/or `END_DATETIME` are specified, only companies with internships in the specified time period will be shown.
* `START_DATETIME` and `END_DATETIME` are non-inclusive, i.e. internships on `START_DATETIME` or `END_DATETIME` will not be considered.
* If there are no companies with internships in the specified time period, the list of companies shown will be empty.
* If there are no companies with internships, the list of companies shown will be empty.
* If there are no companies, the list of companies shown will be empty.
</div>

**Example**
* `sort c start/01-02-2024 00:01 end/01-04-2024 00:01` sorts and displays the companies whose next scheduled interview time is within the specified time period
* After the command is run, the output in the UI should be similar to the one shown here. Only the companies matching the specifications will be listed, as highlighted in red:
  ![sort companies by interview date](images/sortCompaniesByInterviewDate.png)

[Back to Table of Contents](#table-of-contents)

### Clearing all contacts: `clear`

Clear SOCareers' list of persons and list of companies to remove contacts in bulk.

Format: `clear`
<div markdown="span" class="alert alert-warning">
**:warning: Warning**<br>
This is a dangerous operation that will delete all contacts you have added!
</div>

<div markdown="span" class="alert alert-primary">
**:bulb: Tip**<br>
* If you are unsure, you may make a copy of the `data` folder in the home folder of SOCareers as a backup before executing this command.
</div>

**Example**
* After the command is run, the UI should be as follows:
  ![clear command result](images/clear.png)

[Back to Table of Contents](#table-of-contents)

### Exiting SOCareers: `exit`

Exit SOCareers quickly with a command.

[Back to Table of Contents](#table-of-contents)


--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous SOConnect home folder.

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Known Limitations

* After deleting your contact from SOCareers, it will still be displayed in the display box immediately after
  * Once you view another contact using view p or view c, the deleted contact will no longer be shown anywhere in SOCareers.

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Command Summary

| Action | Format                             | Examples                                                                                                                                                                                              |
|--------|------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Add    | `add c`, `add p`, `add i`          | e.g., `add p n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney`;<br/>`add c n/Apple p/98765432 e/johnd@example.com d/Top tech companyt/tech t/interested` |
| List   | `list c`, `list p`                 |                                                                                                                                                                                                       |
| Delete | `delete c INDEX`, `delete p INDEX` | e.g., `delete p 3`                                                                                                                                                                                    |
| View   | `view c INDEX`, `view p INDEX`     | e.g., `view c 1`                                                                                                                                                                                      |
| Edit   | `edit c INDEX`, `edit p INDEX`     | e.g., `edit p 1 n/John p/98765432 e/john@example.com a/311, Clementi Ave 2, #02-26 t/friend`;<br> `edit c 1 n/Alpha p/98765432 e/alpha@example.com d/A cool company t/tech`                           |                                                                                                                                                                                    |
| Find   | `find c`, `find p`                 | e.g., `find p n/John Doe t/friend`                                                                                                                                                                    |
| Sort   | `sort c`                           | e.g., `sort c start/01-02-2024 00:01 end/01-04-2024 00:01`                                                                                                                                            |

[Back to Table of Contents](#table-of-contents)


