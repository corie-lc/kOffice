package com.office.koffice.bar

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

class LayoutBar {
    fun launchBar(stage: Stage, containers: VBox, scene: Scene){
        val layoutBar = HBox()
       // layoutBar.children.addAll(homeBar().buttonFeature, homeBar().buttonFont, homeBar().buttonLayout, homeBar().buttonFile, homeBar().buttonPrint)
        val menuButton = Bar().menuButton
        scene.stylesheets.add("a.css")
        menuButton.styleClass.add("menu-bar")
        layoutBar.children.add(menuButton)
        layoutBar.alignment = Pos.TOP_CENTER
        layoutBar.styleClass.add("bar")
        layoutBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        scene.stylesheets.add("a.css")

        containers.children.removeAt(0)
        containers.children.add(0, layoutBar)
    }
}