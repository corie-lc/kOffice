package com.office.koffice.bar

import com.office.koffice.TextArea
import javafx.animation.FadeTransition
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.MenuItem
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage


class Bar {
    val defaultWidthBar = 300.0
    val defaultHeightBar = 65.0

    fun getMenuBar(scene: Scene, container : BorderPane, primaryStage: Stage, textWindow : VBox) : VBox {
        val buttonOut = Button("Hide")
        val buttonHome = Button("Home Bar")
        val buttonFont = Button("Font Bar")
        val buttonLayout = Button("Layout Bar")
        val buttonFile = Button("File Bar")
        val buttonPrint = Button("Print Bar")
        val buttonSettings = Button("Settings")
        val a = FadeTransition()


        val menuBar = VBox()
        menuBar.children.addAll(buttonOut, buttonHome, buttonFont, buttonLayout, buttonFile, buttonPrint, buttonSettings)
        menuBar.styleClass.add("menu-bar")

        buttonFont.setOnAction {
            displaySecondaryBar(container, FontBar().getFontBar(scene, textWindow))
        }
        buttonFile.setOnAction {
            displaySecondaryBar(container, FileBar().getFileBar(scene, container, primaryStage, textWindow))
        }
        buttonLayout.setOnAction {
            displaySecondaryBar(container, getLayoutBar(scene, container))

        }
        buttonPrint.setOnAction {
            displaySecondaryBar(container, getPrintBar(scene, container))
        }
        buttonSettings.setOnAction {
            displaySecondaryBar(container, getSettingsBar(scene, container, textWindow))
        }


        return menuBar
    }

    private fun getSettingsBar(scene : Scene, container: BorderPane, textWindow: VBox) : VBox{
        val settingsBar = VBox()

        // style
        scene.stylesheets.add("a.css")
        settingsBar.styleClass.add("menu-bar")
        settingsBar.alignment = Pos.TOP_CENTER
        settingsBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        settingsBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)

        return settingsBar
    }

    private fun getLayoutBar(scene : Scene, container: BorderPane) : VBox{
        val layoutBar = VBox()

        scene.stylesheets.add("a.css")
        layoutBar.styleClass.add("menu-bar")
        layoutBar.alignment = Pos.TOP_CENTER


        layoutBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        layoutBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        layoutBar.children.add(Button(""))

        return layoutBar
    }

    fun getPrintBar(scene: Scene, container: BorderPane) : VBox{
        val printBar = VBox()

        scene.stylesheets.add("a.css")
        scene.stylesheets.add("a.css")
        printBar.styleClass.add("menu-bar")
        printBar.alignment = Pos.TOP_CENTER


        printBar.alignment = Pos.TOP_CENTER
        printBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        printBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)

        return printBar
    }

    fun displaySecondaryBar(container : BorderPane, bar: VBox){
        bar.styleClass.add("menu-bar")
        container.right = bar
    }

}