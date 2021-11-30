package com.office.koffice.bar

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

class PrintBar {
    fun launchBar(stage: Stage, containers: VBox, scene : Scene){
        val printBar = HBox()
        val menuButton = Bar().menuButton
        scene.stylesheets.add("a.css")
        menuButton.styleClass.add("menu-bar")
        printBar.children.add(menuButton)
        //printBar.children.addAll(homeBar().buttonFeature, homeBar().buttonFont, homeBar().buttonLayout, homeBar().buttonFile, homeBar().buttonPrint)
        printBar.alignment = Pos.TOP_CENTER
        printBar.styleClass.add("bar")
        printBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        printBar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)
        scene.stylesheets.add("a.css")

        containers.children.removeAt(0)
        containers.children.add(0, printBar)
    }
}