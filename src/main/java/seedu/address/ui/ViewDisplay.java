package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.model.company.Company;
import seedu.address.model.person.Person;

/**
 * A ui for a large viewing area that is displayed at the bottom right of the application.
 */
public class ViewDisplay extends StackPane {

    private static final String FXML = "ViewDisplay.fxml";

    public ViewDisplay() {
        super();
    }

    public void displayEntity(Person person) {
        requireNonNull(person);
        this.getChildren().clear();
        this.getChildren().add(new ViewPersonDisplay(person).getRoot());
    }

    public void displayEntity(Company company) {
        requireNonNull(company);
        this.getChildren().clear();
        this.getChildren().add(new ViewCompanyDisplay(company).getRoot());
    }

}
