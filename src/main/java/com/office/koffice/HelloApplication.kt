package com.office.koffice

import com.office.koffice.bar.Bar
import javafx.application.Application
import javafx.application.Platform
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXMLLoader
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.ScrollPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
import javafx.stage.StageStyle


class HelloApplication : Application() {
    public val defaultWidthBar = 700.0
    public val defaultHeightBar = 700.0

    override fun start(primaryStage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val mainWindowVBox = VBox()
        primaryStage.title = "Docs"
        
        mainWindowVBox.alignment = Pos.TOP_CENTER
        // stage

        val scene = Scene(mainWindowVBox, 1500.0, 800.0)
        mainWindowVBox.style = "-fx-background-color: #222831"
        primaryStage.scene = scene

        primaryStage.width = 1500.0
        primaryStage.isResizable = true
        val textWindow = VBox()

        Bar().launchBar(primaryStage, mainWindowVBox, scene, 0, mainWindowVBox, textWindow)
        CustomTitleBar().launchCustomTitleBar(primaryStage, mainWindowVBox)

        TextArea().writingField(scene, mainWindowVBox, textWindow)

        primaryStage.show()

    }
}


fun main() {
    Application.launch(HelloApplication::class.java)
}