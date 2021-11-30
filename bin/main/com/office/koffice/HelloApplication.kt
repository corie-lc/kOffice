package com.office.koffice

import javafx.application.Application
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXMLLoader
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.ScrollPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage


class HelloApplication : Application() {
    override fun start(primaryStage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val mainWindowVBox = VBox()
        val textWindow = VBox()
        val scrollPages = ScrollPane()
        primaryStage.title = "Docs"


        // universal buttons
        val home = Button("Home")
        val buttonMainMenu = Button("Home")

        // layout bar

        // layout bar
        val layoutBaseOptions: ObservableList<String> = FXCollections.observableArrayList(
                "Option 1",
                "Option 2",
                "Option 3")

        val dropBaseLayoutOptions: ComboBox<String> = ComboBox<String>(layoutBaseOptions)
        val fontTypeOptions: ObservableList<String> = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3")
        val fontSizeOptions: ObservableList<Int> = FXCollections.observableArrayList(1, 5, 10)

        val dropFont: ComboBox<String> = ComboBox<String>(fontTypeOptions)
        val dropFontSize: ComboBox<Int> = ComboBox<Int>(fontSizeOptions)


        // file bar


        // file bar
        val buttonSave = Button("Save")
        val buttonNewSave = Button("New Save")
        val buttonLoadFile = Button("Open")


        // menu/ bars


        // menu/ bars
        val fontBar = HBox()
        val layoutBar = HBox()
        val fileBar = HBox()

        fontBar.children.addAll(home, dropFont, dropFontSize)
        layoutBar.children.addAll(buttonMainMenu, dropBaseLayoutOptions)
        fileBar.children.addAll(home, buttonSave, buttonNewSave, buttonLoadFile)

        fontBar.alignment = Pos.TOP_CENTER
        layoutBar.alignment = Pos.TOP_CENTER
        fileBar.alignment = Pos.TOP_CENTER


        // main option bar buttons


        // main option bar buttons
        val mainOptionBar = HBox()
        mainOptionBar.maxWidth = 700.0

        mainOptionBar.styleClass.add("mainOptionBar")
        val buttonFeature = Button("Feature Bar")
        val buttonFont = Button("Font Bar")
        val buttonLayout = Button("Layout Bar")
        val buttonFile = Button("File Bar")
        val buttonPrint = Button("Print Bar")
        mainOptionBar.children.addAll(buttonFeature, buttonFont, buttonLayout, buttonFile, buttonPrint)
        mainOptionBar.alignment = Pos.TOP_CENTER

        // document text field and document text window


        // document text field and document text window



        // Buttons control


        // Buttons control
        buttonMainMenu.setOnAction {
            mainWindowVBox.children.removeAt(0)
            mainWindowVBox.children.add(0, mainOptionBar)
        }

        home.setOnAction {
            mainWindowVBox.children.removeAt(0)
            mainWindowVBox.children.add(0, mainOptionBar)
        }

        buttonFont.setOnAction {
            mainWindowVBox.children.removeAt(0)
            mainWindowVBox.children.add(0, fontBar)
        }

        buttonFile.setOnAction {
            mainWindowVBox.children.removeAt(0)
            mainWindowVBox.children.add(0, fileBar)
        }

        buttonLayout.setOnAction {
            mainWindowVBox.children.removeAt(0)
            mainWindowVBox.children.add(0, layoutBar)
        }


        //

        //
        mainWindowVBox.alignment = Pos.TOP_CENTER
        mainWindowVBox.children.add(mainOptionBar)
        mainWindowVBox.children.add(scrollPages)

        val scene = Scene(mainWindowVBox, 800.0, 800.0)
        primaryStage.scene = scene




        // stage

        primaryStage.width = 1500.0
        primaryStage.show()
        scene.stylesheets.add("a.css")


        primaryStage.show()
        TextArea().writingField(scrollPages, textWindow, scene)

    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}