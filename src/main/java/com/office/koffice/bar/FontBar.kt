package com.office.koffice.bar

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

class FontBar {
    fun getBar(scene: Scene, textWindow: VBox, stage: Stage, container: VBox) : HBox{
        val fontBar = HBox()


        scene.stylesheets.add("a.css")
       // menuButton.styleClass.add("menu-bar")
        scene.stylesheets.add("a.css")
        fontBar.styleClass.add("bar")
        fontBar.alignment = Pos.TOP_CENTER

       // fontBar.children.add(menuButton)
        fontBar.alignment = Pos.TOP_CENTER
        fontBar.children.add(Bar().getMenuButton(scene, textWindow, stage, container))
        fontBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        fontBar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)

        return fontBar
    }
}