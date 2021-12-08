package com.office.koffice.bar

import com.office.koffice.HelloApplication
import com.office.koffice.TextArea
import javafx.animation.FadeTransition
import javafx.application.Application
import javafx.beans.value.ObservableValue
import javafx.geometry.Bounds
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.layout.Pane
import javafx.scene.shape.Shape
import javafx.stage.Stage
import org.fxmisc.richtext.CodeArea


class Bar {
    private val defaultWidthBar = 300.0
    private val defaultHeightBar = 65.0

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
            displaySecondaryBar(container, getFontBar(scene, container))
        }
        buttonFile.setOnAction {
            displaySecondaryBar(container, getFileBar(scene, container, primaryStage, textWindow))
        }
        buttonLayout.setOnAction {
            displaySecondaryBar(container, getLayoutBar(scene, container))

        }
        buttonPrint.setOnAction {
            displaySecondaryBar(container, getPrintBar(scene, container))
        }
        buttonSettings.setOnAction {
            displaySecondaryBar(container, getSettingsBar(scene, container))
        }


        return menuBar
    }

    private fun getSettingsBar(scene : Scene, container: BorderPane) : VBox{
        val settingsBar = VBox()
        val buttonPlusSizeTextArea = Button("+ Window Size")

        buttonPlusSizeTextArea.setOnAction {
            //TextArea().plusWidthTextWindow()
        }

        scene.stylesheets.add("a.css")
        settingsBar.styleClass.add("menu-bar")
        settingsBar.alignment = Pos.TOP_CENTER


        settingsBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        settingsBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        settingsBar.children.add(Button("Plus Size"))

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

    fun getFileBar(scene: Scene, container: BorderPane, stage: Stage, textWindow: VBox) : VBox{
        // def
        val buttonSaveFile =  Button("Save as")
        val buttonLoadFile = Button("Load File")
        val buttonSave = Button("Save File")
        val buttonNewProject = Button("Project")
        val fileBar = VBox()



        var fullText = ""

        // bar modifier
        fileBar.children.addAll(buttonLoadFile, buttonSaveFile, buttonSave, buttonNewProject)

        // style components --
        scene.stylesheets.add("a.css")
        buttonLoadFile.styleClass.add("menu-button")
        buttonSaveFile.styleClass.add("menu-button")

        fileBar.styleClass.add("menu-bar")
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        fileBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        var lastSaveLocation = ""

        // on click components --
        buttonLoadFile.setOnAction {
            FileBar().loadFile(textWindow, stage)
        }

        buttonSaveFile.setOnAction {
            lastSaveLocation =  FileBar().saveAs(stage, textWindow)
        }

        buttonSave.setOnAction {
            FileBar().save(textWindow, lastSaveLocation)
        }

        buttonNewProject.setOnAction {
            textWindow.children.clear()
            TextArea().add(textWindow)
        }



        return fileBar
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

    fun getFontBar(scene: Scene, container: BorderPane) : VBox{
        val fontBar = VBox()


        scene.stylesheets.add("a.css")
        // menuButton.styleClass.add("menu-bar")
        scene.stylesheets.add("a.css")
        fontBar.styleClass.add("menu-bar")
        fontBar.alignment = Pos.TOP_CENTER

        // fontBar.children.add(menuButton)
        fontBar.alignment = Pos.TOP_CENTER
        fontBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        fontBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)

        return fontBar
    }

    fun displaySecondaryBar(container : BorderPane, bar: VBox){
        bar.styleClass.add("menu-bar")
        container.right = bar
    }

}