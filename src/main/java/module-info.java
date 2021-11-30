module com.office.koffice {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires org.fxmisc.richtext;


    opens com.office.koffice to javafx.fxml;
    exports com.office.koffice;
}