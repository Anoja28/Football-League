module com.frauas {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.frauas to javafx.fxml;

    exports com.frauas;
}
