package com.office.koffice.bar

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.HBox

class LayoutBar {
    fun getBar(scene: Scene) : HBox{
        val layoutBar = HBox()
        //val menuButton = Bar().menuButton

        scene.stylesheets.add("a.css")
      //  menuButton.styleClass.add("menu-bar")
        scene.stylesheets.add("a.css")
        layoutBar.styleClass.add("bar")
        layoutBar.alignment = Pos.TOP_CENTER

       // layoutBar.children.add(menuButton)
        layoutBar.alignment = Pos.TOP_CENTER
        layoutBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        layoutBar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)

        return layoutBar
    }
}