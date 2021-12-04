package com.office.koffice

import com.office.koffice.bar.Bar
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Stage


class HelloApplication : Application() {
    public val defaultWidthBar = 700.0
    public val defaultHeightBar = 700.0

    override fun start(primaryStage: Stage) {
        val mainWindowVBox = VBox()
        primaryStage.title = "Docs"
        
        mainWindowVBox.alignment = Pos.TOP_CENTER
        // stage

        val scene = Scene(mainWindowVBox, 1500.0, 800.0)
        mainWindowVBox.style = "-fx-background-color: #1F2833"
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