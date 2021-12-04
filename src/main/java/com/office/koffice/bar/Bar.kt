package com.office.koffice.bar

import javafx.animation.ScaleTransition
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
import javafx.util.Duration


class Bar {
    public val default_width_bar = 700.0
    public val default_height_bar = 65.0

    fun getMenuButton(scene: Scene, container: VBox) : MenuButton {
        val buttonHome = MenuItem("Home Bar")
        val buttonFont = MenuItem("Font Bar")
        val buttonLayout = MenuItem("Layout Bar")
        val buttonFile = MenuItem("File Bar")
        val buttonPrint = MenuItem("Print Bar")


        val menuButton = MenuButton("Menu", null, buttonHome, buttonFont, buttonLayout, buttonFile, buttonPrint)
        menuButton.styleClass.add("menu-bar")

        buttonHome.setOnAction {
            replaceBar(container, HomeBar().getBar(scene, container))
        }
        buttonFont.setOnAction {
            replaceBar(container, FontBar().getBar(scene))
        }
        buttonFile.setOnAction {
            replaceBar(container, FileBar().getBar(scene))
        }
        buttonLayout.setOnAction {
            replaceBar(container, LayoutBar().getBar(scene))

        }
        buttonPrint.setOnAction {
            replaceBar(container, PrintBar().getBar(scene))
        }

        return menuButton
    }

    fun replaceBar(container: VBox, bar : HBox){
        container.children.removeAt(1)
        container.children.add(1, bar)
    }

    fun launchBar(stage : Stage, container: VBox, scene: Scene, int : Int, mainWindow: VBox, textWindow : VBox){
        //replaceBar(container, HomeBar().getBar(scene))
        val bar = HBox()
        scene.stylesheets.add("a.css")
        scene.stylesheets.add("a.css")
        bar.styleClass.add("bar")
        bar.alignment = Pos.TOP_CENTER
        bar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        bar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)
        scene.stylesheets.add("a.css")

        container.children.add( HomeBar().getBar(scene, container))

        bar.setOnMouseEntered {
            val scaleTransition = ScaleTransition()
            scaleTransition.duration = Duration.millis(1000.0)
            scaleTransition.node = bar
            scaleTransition.byX = 0.3
            scaleTransition.cycleCount = 1
            scaleTransition.isAutoReverse = true
            scaleTransition.play()
        }

        bar.setOnMouseExited {
            val scaleTransition = ScaleTransition()
            scaleTransition.duration = Duration.millis(1000.0)
            scaleTransition.node = bar
            scaleTransition.byX = -0.3
            scaleTransition.cycleCount = 1
            scaleTransition.isAutoReverse = true
            scaleTransition.play()
        }
    }


}