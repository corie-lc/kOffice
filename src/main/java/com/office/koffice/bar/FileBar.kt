package com.office.koffice.bar

import com.office.koffice.TextArea
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.FileChooser
import javafx.stage.Stage
import java.io.File

class FileBar {
    private val buttonSaveFile =  Button("Save as")
    private val buttonLoadFile = Button("Load File")
    private val buttonNew = Button("New File")
    private val fileBar = HBox()
    private var fullText = ""

    fun getBar(scene: Scene, textWindow: VBox, stage: Stage, container: VBox) : HBox{

        // bar modifier
        val fileBar = HBox()
        fileBar.children.add(Bar().getMenuButton(scene, container, stage, textWindow))
        fileBar.children.addAll(buttonLoadFile, buttonSaveFile)

        // style components --
        scene.stylesheets.add("a.css")
        buttonLoadFile.styleClass.add("menu-button")
        buttonSaveFile.styleClass.add("menu-button")

        fileBar.styleClass.add("bar")
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        fileBar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)

        // on click components --
        buttonLoadFile.setOnAction {
            loadFile(stage, textWindow)
        }

        buttonSaveFile.setOnAction {
            saveAs(stage, textWindow)
        }


        return fileBar
    }

    private fun saveAs(stage: Stage, textWindow: VBox) {
        val fileChooser = FileChooser()
        val selectedFile = fileChooser.showOpenDialog(stage)
        File(selectedFile.absoluteFile.toString()).writeText(TextArea().getAllText(textWindow))
    }

    private fun loadFile(stage: Stage, textWindow: VBox){
        val fileChooser = FileChooser()
        val selectedFile = fileChooser.showOpenDialog(stage)

        if(selectedFile.extension == "txt"){
            TextArea().writeToTextBox(getTextFileContent(selectedFile.absoluteFile), 0, textWindow)
        }
    }

    // utils
    private fun getTextFileContent(file: File): String {
        return file.readText()
    }

}