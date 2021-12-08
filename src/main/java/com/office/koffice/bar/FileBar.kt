package com.office.koffice.bar

import com.office.koffice.HelloApplication
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
    var lastSavedLocation = ""

    fun saveAs(stage: Stage, textWindow: VBox) : String{
        val fileChooser = FileChooser()
        val selectedFile = fileChooser.showOpenDialog(stage)
        lastSavedLocation = selectedFile.toString()
        File(selectedFile.absoluteFile.toString()).writeText(TextArea().getAllText(textWindow))

        return selectedFile.toString()
    }

    private fun saveAs(file : String, textWindow: VBox){
        lastSavedLocation = file
        File(file).writeText(TextArea().getAllText(textWindow))
    }

    fun loadFile(textWindow: VBox, stage: Stage){
        val fileChooser = FileChooser()
        val selectedFile = fileChooser.showOpenDialog(stage)

        if(selectedFile.extension == "txt"){
            TextArea().writeToTextBox(getTextFileContent(selectedFile.absoluteFile), 0, textWindow)
        }
    }

    fun save(textWindow: VBox, file: String) {
        saveAs(file, textWindow)
    }

    // utils
    private fun getTextFileContent(file: File): String {
        return file.readText()
    }

}