package com.office.koffice.bar

import com.office.koffice.TextArea
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.FileChooser
import javafx.stage.Stage
import java.io.File

class FileBar {
    private var lastSavedLocation = ""


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

        // style -
        scene.stylesheets.add("a.css")
        buttonLoadFile.styleClass.add("menu-button")
        buttonSaveFile.styleClass.add("menu-button")
        fileBar.styleClass.add("menu-bar")
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        fileBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)

        // on click components --
        buttonLoadFile.setOnAction {
            FileBar().loadFile(textWindow, stage)
        }

        buttonSaveFile.setOnAction {
            lastSavedLocation =  FileBar().saveAs(stage, textWindow)
        }

        // button event handlers
        buttonSave.setOnAction {
            FileBar().save(textWindow, lastSavedLocation)
        }

        buttonNewProject.setOnAction {
            textWindow.children.clear()
            TextArea().add(textWindow)
        }



        return fileBar
    }


    // saves file with the user collecting a file through the file app
    private fun saveAs(stage: Stage, textWindow: VBox) : String{
        val fileChooser = FileChooser()
        val selectedFile = fileChooser.showOpenDialog(stage)
        lastSavedLocation = selectedFile.toString()
        File(selectedFile.absoluteFile.toString()).writeText(TextArea().getAllText(textWindow))

        return selectedFile.toString()
    }

    // saves file with already collected file
    private fun saveAs(file : String, textWindow: VBox){
        lastSavedLocation = file
        File(file).writeText(TextArea().getAllText(textWindow))
    }

    // saves file with already collected file
    fun save(textWindow: VBox, file: String) {
        saveAs(file, textWindow)
    }

    // loads file into project
    private fun loadFile(textWindow: VBox, stage: Stage){
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