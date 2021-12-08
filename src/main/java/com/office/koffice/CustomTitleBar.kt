package com.office.koffice

import javafx.application.Platform
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.stage.Stage
import javafx.stage.StageStyle

class CustomTitleBar {
    fun getBar(primaryStage: Stage, mainLayout: BorderPane) : HBox{
        primaryStage.initStyle(StageStyle.UNDECORATED);
        val hbox = HBox()
        hbox.prefHeight = 30.0
        val closeBtn = Button("X")
        closeBtn.setOnAction { Platform.exit() }
        hbox.children.add(closeBtn)
        hbox.style = "-fx-background-color: #393E46;"


        class Delta {
            var x = 0.0
            var y = 0.0
        }

        val dragDelta = Delta()

        hbox.setOnMousePressed {
            dragDelta.x = primaryStage.x - it.screenX;
            dragDelta.y = primaryStage.y - it.screenY;
        }

        hbox.setOnMouseDragged {
            primaryStage.x = it.screenX + dragDelta.x;
            primaryStage.y = it.screenY + dragDelta.y;
        }

        return hbox
    }
}