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