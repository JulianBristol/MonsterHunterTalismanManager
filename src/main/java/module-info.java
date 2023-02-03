module com.example.monsterhuntertalismanmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.monsterhuntertalismanmanager to javafx.fxml;
    exports com.example.monsterhuntertalismanmanager;
}