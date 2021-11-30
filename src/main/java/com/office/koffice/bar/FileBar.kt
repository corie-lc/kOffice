package com.office.koffice.bar

import com.office.koffice.FileBarOptions
import com.office.koffice.HelloApplication
import com.office.koffice.TextArea
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.FileChooser
import javafx.stage.Stage
import org.fxmisc.richtext.CodeArea
import java.io.File

class FileBar {
    private val buttonSaveFile =  Button("Save as")
    private val buttonLoadFile = Button("Load File")
    private val buttonNew = Button("New File")
    private val fileBar = HBox()
    private val menuButton = Bar().menuButton
    private var fullText = ""

    fun launchBar(stage: Stage, containers: VBox, scene: Scene, mainWindow: VBox, textWindow: VBox){
        scene.stylesheets.add("a.css")

        menuButton.styleClass.add("menu-bar")

        fileBar.children.add(menuButton)
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.styleClass.add("bar")
        fileBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)

        scene.stylesheets.add("a.css")

        mainWindow.children.removeAt(1)

        containers.children.add(1, fileBar)

        // settings
        fileBar.children.addAll(buttonSaveFile, buttonLoadFile, buttonNew)

        buttonSaveFile.setOnAction { saveAs( stage) }
        buttonLoadFile.setOnAction { loadFile(stage,textWindow) }
        buttonSaveFile.styleClass.add("menu-button")
        buttonLoadFile.styleClass.add("menu-button")
        buttonNew.styleClass.add("menu-button")

        // collect all text
    }

    private fun saveAs(stage: Stage) {
        val fileChooser = FileChooser()
        val selectedFile = fileChooser.showOpenDialog(stage)
/*
        for(item in textWindow.children){
            val area = item as CodeArea
            fullText += area.text
        }


 */
        File(selectedFile.toURI()).writeText(fullText)


        System.out.println(fullText)
    }

    private fun loadFile(stage: Stage, textWindow: VBox){
        val fileChooser = FileChooser()
        val selectedFile = fileChooser.showOpenDialog(stage)

        if(selectedFile.extension == "txt"){
            TextArea().writeToTextBox(getTextFileContent(selectedFile.absoluteFile), 0, textWindow)
        }
    }

    // utils
    private fun getTextFileContent(file : File) : String {
        val text = file.readText()
        return text
    }

}