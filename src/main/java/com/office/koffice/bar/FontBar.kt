package com.office.koffice.bar

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

class FontBar {
    fun launchBar(stage: Stage, containers: VBox, scene: Scene){
        val fontBar = HBox()
       // fontBar.children.addAll(homeBar().buttonFeature, homeBar().buttonFont, homeBar().buttonLayout, homeBar().buttonFile, homeBar().buttonPrint)
        val menuButton = Bar().menuButton
        scene.stylesheets.add("a.css")
        menuButton.styleClass.add("menu-bar")
        fontBar.children.add(menuButton)
        fontBar.alignment = Pos.TOP_CENTER
        fontBar.styleClass.add("bar")
        fontBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        scene.stylesheets.add("a.css")

        containers.children.removeAt(0)
        containers.children.add(0, fontBar)
    }
}