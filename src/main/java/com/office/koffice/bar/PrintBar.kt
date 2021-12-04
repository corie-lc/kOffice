package com.office.koffice.bar

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

class PrintBar {
    fun getBar(scene: Scene) : HBox{
        println('a')
        val printBar = HBox()
       // val menuButton = Bar().menuButton

        scene.stylesheets.add("a.css")
   //     menuButton.styleClass.add("menu-bar")
        scene.stylesheets.add("a.css")
        printBar.styleClass.add("bar")
        printBar.alignment = Pos.TOP_CENTER


    //    printBar.children.add(menuButton)
        printBar.alignment = Pos.TOP_CENTER
        printBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        printBar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)

        return printBar
    }
}