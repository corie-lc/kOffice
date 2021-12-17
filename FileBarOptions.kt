package com.office.koffice

import javafx.stage.FileChooser
import javafx.stage.Stage


class FileBarOptions {
    fun saveAs(text : String, stage: Stage) {
        val fileChooser = FileChooser()
        val selectedFile = fileChooser.showOpenDialog(stage)

        System.out.println(selectedFile)
    }
}