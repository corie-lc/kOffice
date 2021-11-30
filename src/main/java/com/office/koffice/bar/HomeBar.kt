package com.office.koffice.bar

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

class HomeBar {
    fun launchBar(stage: Stage, containers: VBox, scene: Scene){
        val homeBar = HBox()
        val menuButton = Bar().menuButton

        scene.stylesheets.add("a.css")
        menuButton.styleClass.add("menu-bar")
        homeBar.children.add(menuButton)
        homeBar.alignment = Pos.TOP_CENTER
        homeBar.styleClass.add("bar")
        homeBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        homeBar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)
        scene.stylesheets.add("a.css")

        containers.children.add(0, homeBar)
    }
}