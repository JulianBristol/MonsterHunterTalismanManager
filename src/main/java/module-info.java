module com.example.monsterhuntertalismanmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.monsterhuntertalismanmanager to javafx.fxml;
    exports com.example.monsterhuntertalismanmanager;
}