package com.office.koffice

import com.office.koffice.bar.Bar
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage


class HelloApplication : Application() {
    public val defaultWidthBar = 700.0
    public val defaultHeightBar = 700.0

    override fun start(primaryStage: Stage) {
        // definitions
        val mainBorderPane = BorderPane()
        val leftBorderPane = BorderPane()
        val rightBorderPane = BorderPane()
        val scene = Scene(mainBorderPane, 1500.0, 800.0)
        val textWindow = VBox()

        //styles
        mainBorderPane.style = "-fx-background-color: gray"
        primaryStage.scene = scene
        primaryStage.width = 1500.0
        primaryStage.isResizable = true

        //placing
        mainBorderPane.left = leftBorderPane
        mainBorderPane.right = rightBorderPane
        leftBorderPane.center = Bar().getMenuBar(scene, mainBorderPane)
        mainBorderPane.center = TextArea().writingField(mainBorderPane, textWindow)

        primaryStage.show()

    }
}


fun main() {
    Application.launch(HelloApplication::class.java)
}