package com.office.koffice.bar

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

class HomeBar {
    fun getBar(scene: Scene, container : VBox, stage: Stage, textWindow : VBox) : HBox{
        val homeBar = HBox()
        //val menuButton = Bar().menuButton

        scene.stylesheets.add("a.css")
      //  menuButton.styleClass.add("menu-bar")
        scene.stylesheets.add("a.css")
        homeBar.styleClass.add("bar")
        homeBar.alignment = Pos.TOP_CENTER

       // homeBar.children.add(menuButton)
        homeBar.alignment = Pos.TOP_CENTER
        homeBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        homeBar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)

        homeBar.children.add(Bar().getMenuButton(scene, container, stage, textWindow))

        return homeBar
    }
}