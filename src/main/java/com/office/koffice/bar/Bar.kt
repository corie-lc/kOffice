package com.office.koffice.bar

import javafx.animation.FadeTransition
import javafx.beans.value.ObservableValue
import javafx.geometry.Bounds
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.layout.Pane
import javafx.scene.shape.Shape


class Bar {
    private val defaultWidthBar = 700.0
    private val defaultHeightBar = 65.0

    fun getMenuBar(scene: Scene, container : BorderPane) : VBox {
        val buttonOut = Button("Hide")
        val buttonHome = Button("Home Bar")
        val buttonFont = Button("Font Bar")
        val buttonLayout = Button("Layout Bar")
        val buttonFile = Button("File Bar")
        val buttonPrint = Button("Print Bar")
        val a = FadeTransition()


        val menuBar = VBox()
        menuBar.children.addAll(buttonOut, buttonHome, buttonFont, buttonLayout, buttonFile, buttonPrint)
        menuBar.styleClass.add("menu-bar")

        buttonFont.setOnAction {
            displaySecondaryBar(container, getFontBar(scene, container))
        }
        buttonFile.setOnAction {
            displaySecondaryBar(container, getFileBar(scene, container))
        }
        buttonLayout.setOnAction {
            displaySecondaryBar(container, getLayoutBar(scene, container))

        }
        buttonPrint.setOnAction {
            displaySecondaryBar(container, getPrintBar(scene, container))
        }

        return menuBar
    }


    private fun getLayoutBar(scene : Scene, container: BorderPane) : VBox{
        val layoutBar = VBox()

        scene.stylesheets.add("a.css")
        scene.stylesheets.add("a.css")
        layoutBar.styleClass.add("bar")
        layoutBar.alignment = Pos.TOP_CENTER


        layoutBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        layoutBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)

        return layoutBar
    }

    fun getFileBar(scene: Scene, container: BorderPane) : VBox{
        // def
        val buttonSaveFile =  Button("Save as")
        val buttonLoadFile = Button("Load File")
        val buttonNew = Button("New File")
        val fileBar = VBox()



        var fullText = ""

        // bar modifier
        fileBar.children.addAll(buttonLoadFile, buttonSaveFile)

        // style components --
        scene.stylesheets.add("a.css")
        buttonLoadFile.styleClass.add("menu-button")
        buttonSaveFile.styleClass.add("menu-button")

        fileBar.styleClass.add("bar")
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        fileBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)

        // on click components --
        buttonLoadFile.setOnAction {
            //    loadFile(stage, textWindow)
        }

        buttonSaveFile.setOnAction {
            //    saveAs(stage, textWindow)
        }


        return fileBar
    }

    fun getPrintBar(scene: Scene, container: BorderPane) : VBox{
        val printBar = VBox()

        scene.stylesheets.add("a.css")
        scene.stylesheets.add("a.css")
        printBar.styleClass.add("bar")
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
        fontBar.styleClass.add("bar")
        fontBar.alignment = Pos.TOP_CENTER

        // fontBar.children.add(menuButton)
        fontBar.alignment = Pos.TOP_CENTER
        fontBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        fontBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)

        return fontBar
    }

    private fun displaySecondaryBar(container : BorderPane, bar: VBox){
        //
    }

}