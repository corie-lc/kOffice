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
    private val buttonHome = MenuItem("Home Bar")
    private val buttonFont = MenuItem("Font Bar")
    private val buttonLayout = MenuItem("Layout Bar")
    private val buttonFile = MenuItem("File Bar")
    private val buttonPrint = MenuItem("Print Bar")
    val menuButton = MenuButton("Menu", null, buttonHome, buttonFont, buttonLayout, buttonFile)

    fun launchBar(stage : Stage, container: VBox, scene: Scene, int : Int, mainWindow: VBox, textWindow : VBox){
        val bar = HBox()
        scene.stylesheets.add("a.css")
        menuButton.styleClass.add("menu-bar")
        bar.alignment = Pos.TOP_CENTER
        bar.styleClass.add("bar")
        bar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        bar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)
        scene.stylesheets.add("a.css")

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


        if(int == 0) {
            container.children.add(bar)
            bar.children.add(menuButton)
        }

        if(int == 1) {
            FontBar().launchBar(stage, container, scene)
        }

        if(int == 2) {
            FileBar().launchBar(stage, container, scene, mainWindow, textWindow)
        }

        if(int == 3) {
            LayoutBar().launchBar(stage, container, scene)
        }

        if(int == 4) {
            PrintBar().launchBar(stage, container, scene)
        }

        buttonHome.setOnAction {
            launchBar(stage, container, scene, 0, mainWindow, textWindow)
        }
        buttonFont.setOnAction {
            launchBar(stage, container, scene, 1, mainWindow, textWindow)
        }
        buttonFile.setOnAction {
            launchBar(stage, container, scene, 2, mainWindow, textWindow)
        }
        buttonLayout.setOnAction {
            launchBar(stage, container, scene, 3, mainWindow, textWindow)
        }
        buttonPrint.setOnAction {
            launchBar(stage, container, scene, 4, mainWindow, textWindow)
        }
    }


}