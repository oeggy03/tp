---
layout: page
title: Tran Ha Thu's Project Portfolio Page
---

### Project: SOCareers

SOCareers is an all-in-one app that helps CS majors to keep track of jobs/internship-related content.
The app allows students to keep track of company application timelines, their networks of people, and interview timelines.

**Summary of Contributions**:

Given below are my contributions to the project.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=oeggy03&breakdown=false&sort=groupTitle%20dsc&sortWithin=title&since=2023-09-22&timeframe=commit&mergegroup=&groupSelect=groupByRepos)

* **Enhancements implemented (Linked to relevant Pull Requests)**:
  * Enhance the existing AB3 to support another entity: `companies`. My part included adding JSON loading/saving support for companies:
    * [Enhance AddressBook: Add CRUD support for company database](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/91)
    * [Update the loading of Sample Data to support company sample data](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/93)
  * Enhance the existing AB3 to support each company having a list of internships. This includes implementing JSON support and creating of the Internship class:
    * [Add support for Internship classes within a Company class, and json loading support for Internships](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/108)
  * Enhance the UI of AB3:
    * [Enhance UI to support displaying companies](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/91)
  * Implemented the following commands:
    * [List Persons - `list p` command](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/81)
    * [Delete Company - `delete c [INDEX]` command](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/95)

* **Contribution to the UG**:
  To be updated soon.

* **Contribution to the DG**:
  * Edited existing AB3 UML Diagrams for the DG for v1.3. These include all the diagrams for the Design section (UI, Logic, Model, Storage) as of [this Pull Request](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/112), save for the Architecture Diagram. 
  * Updated the contents of the Design: UI section of the DG in to reflect our enhancements to the code:
    * The documentation of CompanyListPanel and CompanyCard.
  * Updated the contents of the Design: Logic section of the DG in to reflect our enhancements to the code:
    * Created the Sequence Diagram for `delete c 1` to show how a command affecting companies will run.
    * The documentation of making `XYZCommand` abstract, and having `XYZPersonCommand` and `XYZCompanyCommand` inherit from it, and the grouping of these classes into 1 package.
    * The documentation of how `XYZCommandParser` works to differentiate between executing the command on the `Person` or `Company` entity, and its accompanying UML Class diagram.
  * Updated the contents of the Design: Model section of the DG in to reflect our enhancements to the code:
    * Documented the new additions to the model as of v1.3, including the `Company`, `Internship` and their accompanying classes.
    * Created the new Class Diagrams for the persons and companies packages, which documented the `Person` and `Company` classes to a great detail.
  * Updated the contents of the Design: Storage section of the DG in to reflect our enhancements to the code:
    * Documented the new `JsonAdapted` classes (`JsonAdaptedCompany` and `JsonAdaptedInternship`) in the Class diagram.
  * Updated the contents of the Design: Commons section of the DG in to reflect our enhancements to the code:
    * Added short descriptions to each class in the commons package.

* **Contribution to team-based tasks**:
  To be updated soon.

* **Review/mentoring contributions**:
  * Reviewed pull requests from teammates:
    * [PR #23](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/23)
    * [PR #74](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/74)
    * [PR #75](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/75)
    * [PR #80](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/75)
    * [PR #84](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/84)
    * [PR #87](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/84)
    * [PR #96](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/96)
    * [PR #101](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/101)
    * [PR #102](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/102)
    * [PR #104](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/104)
    * [PR #105](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/105)
    * [PR #107](https://github.com/AY2324S1-CS2103T-T10-4/tp/pull/107)
    
  * Left 16 comments for their pull requests.

* **Contributions beyond the project team**:
  To be updated soon.

