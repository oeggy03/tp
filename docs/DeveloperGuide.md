---
layout: page
title: Developer Guide
---
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

* This project is based on the AddressBook-Level3 project created by the [SE-EDU initiative](https://se-education.org/).

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **Design**

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document `docs/diagrams` folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.
</div>

### Architecture

<img src="images/ArchitectureDiagram.png" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** (consisting of classes [`Main`](https://github.com/AY2324S1-CS2103T-T10-4/tp/blob/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/AY2324S1-CS2103T-T10-4/tp/tree/master/src/main/java/seedu/address/MainApp.java)) is in charge of the app launch and shut down.
* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following four components:

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<img src="images/ComponentManagers.png" width="300" />

The sections below give more details of each component.

### UI component

The **API** of this component is specified in [`Ui.java`](https://github.com/AY2324S1-CS2103T-T10-4/tp/tree/master/src/main/java/seedu/address/ui/Ui.java)

<img src="images/UiClassDiagram.png" width="1200" />

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `CompanyListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/AY2324S1-CS2103T-T10-4/tp/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/AY2324S1-CS2103T-T10-4/tp/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Person` or `Company` object residing in the `Model`.

### Logic component

**API** : [`Logic.java`](https://github.com/AY2324S1-CS2103T-T10-4/tp/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the entire `Logic` component:

<img src="images/LogicClassDiagram.png" width="550"/>

The sequence diagram below illustrates the interactions within the `Logic` component, 
taking `execute("delete p 1")` API call as an example.

The command `delete p 1` deletes the first person listed in the list of people in the addressbook.

<img src="images/DeletePersonSequenceDiagram.png" width="1200" />

When executing a command that affects Company objects, the logic works similarly.

The sequence diagram below takes `execute("delete c 1")` API call as an example. 
The command `delete c 1` deletes the first company listed in the list of companies in the addressbook.
<img src="images/DeleteCompanySequenceDiagram.png" width="1200" />

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

How the `Logic` component works:

1. When `Logic` is called upon to execute a command, it is passed to an `AddressBookParser` object which in turn creates a parser that matches the command (e.g., `DeleteCommandParser`) and uses it to parse the command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `DeletePersonCommand`) which is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to delete a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<img src="images/ParserClasses.png" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `DeleteCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `DeleteCommand`) which the `AddressBookParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

<img src="images/IndividualClasses.png" width="800"/>

Due to our two main entities (`Person` and `Company`) having similar commands (e.g. Delete, Find, Add...), there are packages for such commands to improve abstraction.
In these packages (e.g. deletecommand, findcommand packages), we can find the class `XYZCommand` that is created by `XYZCommandParser`. 

How `XYZCommandParser` works:
* When called upon to parse a command argument (e.g. `p 1` in `delete p 1`), it determines whether the argument wants to work with the persons entity, or the companies. This is often determined by `p` or `c` (e.g. `delete p 1` deletes the first person, `delete c 1` deletes the first company).
* `XYZCommandParser` then returns the appropriate `XYZCommand` class. For people, this is `XYZPersonCommand`, and for companies, `XYZCompanyCommand`.

### Model component
**API** : [`Model.java`](https://github.com/AY2324S1-CS2103T-T10-4/tp/tree/master/src/main/java/seedu/address/model/Model.java)

Here's a (partial) class diagram of the entire `Model` component:

<img src="images/ModelClassDiagram.png" width="450" />


The `Model` component,

* stores the address book data i.e., all `Person` objects (which are contained in a `UniquePersonList` object), and all `Company` objects (which are contained in a `UniqueCompanyList` object)
* stores the currently 'selected' `Person` or `Company` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` or `ObservableList<Company>`respectively that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

`Model` has 2 main packages: persons and companies. (`Person` and `Company` class details omitted from the class diagram above)

The details of the `Person` class is shown below:

<img src="images/PersonModelDiagram.png" width="500" />

The details of the `Company` class is shown below:

<img src="images/CompanyModelDiagram.png" width="800" />

### Storage component

**API** : [`Storage.java`](https://github.com/AY2324S1-CS2103T-T10-4/tp/tree/master/src/main/java/seedu/address/storage/Storage.java)

<img src="images/StorageClassDiagram.png" width="700" />

The `Storage` component,
* can save both address book data and user preference data in JSON format, and read them back into corresponding objects.
* inherits from both `AddressBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

### Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

#### The `AppUtil` class:
is a container for App specific utility functions.

#### The `CollectionUtil` class:
contains utility methods related to Collections.

#### The `ConfigUtil` class:
a class for accessing the Config File.

#### The `DateTimeParserUtil` class:
handles all the parsing of Strings into LocalDateTime objects, and vice versa. The format of the String is determined by the final static variables `DATE_FORMAT` and `TIME_FORMAT`.

#### The `FileUtil` class:
writes and reads files.

#### The `JsonUtil` class:
converts a Java object instance to JSON and vice versa.

#### The `StringUtil` class:
contains helper functions for handling strings.

#### The `ToStringBuilder` class:
builds a string representation of an object.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### \[Proposed\] Undo/redo feature

#### Proposed Implementation

The proposed undo/redo mechanism is facilitated by `VersionedAddressBook`. It extends `AddressBook` with an undo/redo history, stored internally as an `addressBookStateList` and `currentStatePointer`. Additionally, it implements the following operations:

* `VersionedAddressBook#commit()` — Saves the current address book state in its history.
* `VersionedAddressBook#undo()` — Restores the previous address book state from its history.
* `VersionedAddressBook#redo()` — Restores a previously undone address book state from its history.

These operations are exposed in the `Model` interface as `Model#commitAddressBook()`, `Model#undoAddressBook()` and `Model#redoAddressBook()` respectively.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `VersionedAddressBook` will be initialized with the initial address book state, and the `currentStatePointer` pointing to that single address book state.

![UndoRedoState0](images/UndoRedoState0.png)

Step 2. The user executes `delete 5` command to delete the 5th person in the address book. The `delete` command calls `Model#commitAddressBook()`, causing the modified state of the address book after the `delete 5` command executes to be saved in the `addressBookStateList`, and the `currentStatePointer` is shifted to the newly inserted address book state.

![UndoRedoState1](images/UndoRedoState1.png)

Step 3. The user executes `add n/David …​` to add a new person. The `add` command also calls `Model#commitAddressBook()`, causing another modified address book state to be saved into the `addressBookStateList`.

![UndoRedoState2](images/UndoRedoState2.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a command fails its execution, it will not call `Model#commitAddressBook()`, so the address book state will not be saved into the `addressBookStateList`.

</div>

Step 4. The user now decides that adding the person was a mistake, and decides to undo that action by executing the `undo` command. The `undo` command will call `Model#undoAddressBook()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous address book state, and restores the address book to that state.

![UndoRedoState3](images/UndoRedoState3.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index 0, pointing to the initial AddressBook state, then there are no previous AddressBook states to restore. The `undo` command uses `Model#canUndoAddressBook()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.

</div>

The following sequence diagram shows how the undo operation works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the address book to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`. Thus, the `addressBookStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)

The following activity diagram summarizes what happens when a user executes a new command:

<img src="images/CommitActivityDiagram.png" width="250" />

#### Design considerations:

**Aspect: How undo & redo executes:**

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.

_{more aspects and alternatives to be added}_

### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_


--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**:
* majors in Computing at NUS
* searching for job opportunities or internships
* prefers swift and organized tracking for application processes
* prefers desktop apps for managing applications and contacts

**Value proposition**: Efficiently manage job and internship applications and vital contacts with clear timelines using a desktop app.

### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​                                           | I want to …​                            | So that I can…​                                                       |
| -------- | ------------------------------------------------- | -------------------------------------- | --------------------------------------------------------------------- |
| `* * *`  | CS student at NUS                                 | add companies with openings             | keep track of potential internship/job opportunities                  |
| `* * *`  | CS student at NUS                                 | delete company applications             | declutter and focus on companies I'm truly interested in              |
| `* * *`  | CS student at NUS                                 | view all company applications           | have a comprehensive overview of my potential opportunities           |
| `* * *`  | CS student at NUS                                 | add seniors’ contact information        | connect for potential collaborative projects                         |
| `* * *`  | CS student at NUS                                 | add professors’ contact information     | seek guidance or ask academic-related questions                      |
| `* * *`  | CS student at NUS                                 | add contacts from networking events     | have a database for potential job or internship references            |
| `* * *`  | CS student at NUS                                 | view each contact                       | access their details swiftly when needed                             |
| `* * *`  | CS student at NUS                                 | delete contacts                         | keep my contacts list updated and organized                          |
| `* *`    | CS student frequently attending networking events | categorize contacts                     | easily differentiate between professors, seniors, and other contacts |

*{More to be added}*

### Use cases

(For all use cases below, the **System** is the `SOCareers` and the **Actor** is the `User`, unless specified otherwise)

**Use case: Add a new company**

**MSS**

1. User requests to list companies.
2. SOCareers shows a list of companies.
3. User requests to add a new company to the list.
4. SOCareers prompts the user to enter the company details.
5. User enters the company details.
6. SOCareers validates the provided details.
7. SOCareers adds the company to the list.
8. SOCareers displays a message confirming the addition of the company.

   Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 6a. SOCareers detects an error in the entered details.

    * 6a1. SOCareers requests for the correct details.
    * 6a2. User enters new details.
      Steps 6a1-6a2 are repeated until the details entered are correct.
      Use case resumes from step 7.

* *a. At any point, User decides to abort adding a new company.
    * *a1. SOCareers displays a message confirming the cancellation.
      Use case ends.



**Use case: Add contact information**

**MSS**

1. User requests to add contact information.
2. SOCareers prompts the user for the name of the contact.
3. User enters the name.
4. SOCareers prompts the user for contact information.
5. User enters the contact details.
6. SOCareers validates the provided details.
7. SOCareers adds the contact information to the contacts list.
8. SOCareers displays a message confirming the addition of the contact information.

   Use case ends.

**Extensions**

* 6a. SOCareers detects an error in the entered details.

    * 6a1. SOCareers requests for the correct details depending on the error.
    * 6a2. User enters new details.
      Steps 6a1-6a2 are repeated until the details entered are correct.
      Use case resumes from step 7.

* *a. At any point, User decides to abort adding contact information.
    * *a1. SOCareers displays a message confirming the cancellation.
      Use case ends.


**Use case: Delete company applications**

**MSS**

1. User requests to list company applications.
2. SOCareers shows a list of company applications.
3. User selects a certain company application for deletion.
4. SOCareers prompts for confirmation.
5. User confirms.
6. SOCareers deletes the selected company application.
7. SOCareers displays a message confirming the deletion.

   Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.



**Use case: View all company applications**

**MSS**

1. User requests to view all company applications.
2. SOCareers displays a comprehensive list of company applications.

   Use case ends.



[//]: # (**Use case: Add seniors’ contact information**)

[//]: # ()
[//]: # (&#40;Note: This can follow the format of the "Add contact information" use case with specific categorization for 'seniors'.&#41;)

[//]: # ()
[//]: # ()
[//]: # ()
[//]: # (**Use case: Add professors’ contact information**)

[//]: # ()
[//]: # (&#40;Note: This too can follow the format of the "Add contact information" use case with specific categorization for 'professors'.&#41;)

[//]: # ()
[//]: # ()
[//]: # ()
[//]: # (**Use case: Add contacts from networking events**)

[//]: # ()
[//]: # (&#40;Note: This also can follow the format of the "Add contact information" use case with a specific tag or category for 'networking events'.&#41;)



**Use case: View a specific contact**

**MSS**

1. User requests to view a specific contact.
2. SOCareers displays the detailed information of the selected contact.

   Use case ends.



**Use case: Delete contacts**

**MSS**

1. User requests to list contacts.
2. SOCareers shows a list of contacts.
3. User selects a certain contact for deletion.
4. SOCareers prompts for confirmation.
5. User confirms.
6. SOCareers deletes the selected contact.
7. SOCareers displays a message confirming the deletion.

   Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.



**Use case: Categorize contacts**

**MSS**

1. User requests to categorize a contact.
2. SOCareers prompts the user to select a category (professors, seniors, others).
3. User selects the desired category.
4. SOCareers categorizes the contact accordingly.
5. SOCareers displays a message confirming the categorization.

   Use case ends.

**Extensions**

* 2a. The contact list is empty.

  Use case ends.

* 4a. The category selected already exists for the contact.

    * 4a1. SOCareers displays an error message indicating the contact is already categorized under the selected category.

  Use case resumes at step 2.

*{More to be added}*

### Non-Functional Requirements

1. Should work on standard student laptops and desktops.
2. Should be able to manage up to 1000 companies and contacts without degradation in performance.
3. A CS student who is not proficient in tech should be able to use all functionalities within 3 clicks.

*{More to be added}*

### Glossary

* **SOCareers**: A desktop application for NUS Computing majors to streamline their job and internship applications.
* **Contact**: A company or person of interest saved to SOCareers.
* **User**: CS majors at NUS looking for job or internship opportunities.

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### Deleting a person

1. Deleting a person while all persons are being shown

   1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

   1. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

   1. Test case: `delete 0`<br>
      Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

   1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.

1. _{ more test cases …​ }_

### Saving data

1. Dealing with missing/corrupted data files

   1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_
