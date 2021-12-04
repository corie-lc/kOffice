package com.office.koffice

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
import javafx.stage.StageStyle

class CustomTitleBar {
    fun launchCustomTitleBar(primaryStage : Stage, mainLayout : VBox) {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        val hbox = HBox()
        hbox.alignment = Pos.TOP_RIGHT
        hbox.prefHeight = 30.0
        val closeBtn = Button("X")
        closeBtn.setOnAction { Platform.exit() }
        hbox.children.add(closeBtn)
        mainLayout.children.add(0, hbox)

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
    }
}