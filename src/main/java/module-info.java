module com.example.monsterhuntertalismanmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.monsterhunter.main to javafx.fxml;
    exports com.monsterhunter.main;
    exports com.monsterhunter;
    opens com.monsterhunter to javafx.fxml;
    opens com.monsterhunter.model to javafx.fxml;
    exports com.monsterhunter.model;
}