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

    fun getBar(scene: Scene) : HBox{
        println("here")
        val fileBar = HBox()
        //val menuButton = Bar().menuButton

        scene.stylesheets.add("a.css")
       // menuButton.styleClass.add("menu-bar")
        scene.stylesheets.add("a.css")
        fileBar.styleClass.add("bar")
        fileBar.alignment = Pos.TOP_CENTER

       // fileBar.children.add(menuButton)
        fileBar.children.add(Button("aa"))
        fileBar.alignment = Pos.TOP_CENTER
        fileBar.setMinSize(Bar().default_width_bar, Bar().default_height_bar)
        fileBar.setMaxSize(Bar().default_width_bar, Bar().default_height_bar)


        return fileBar
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