package com.office.koffice.bar

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Cell
import javafx.scene.control.ComboBox
import javafx.scene.layout.VBox
import org.fxmisc.richtext.InlineCssTextArea


class FontBar {

    fun getFontBar(scene: Scene, textWindow: VBox) : VBox{
        val fontBar = VBox()
        val comboBox: ComboBox<*> = ComboBox<Int>(getAllSizes())

        comboBox.setOnAction {
            changeFont(textWindow, comboBox.value.toString().toInt())
        }

        // styles
        scene.stylesheets.add("a.css")
        fontBar.styleClass.add("menu-bar")
        comboBox.styleClass.add("font-size")
        fontBar.alignment = Pos.TOP_CENTER
        fontBar.alignment = Pos.TOP_CENTER
        fontBar.setMinSize(Bar().defaultWidthBar, Bar().defaultHeightBar)
        fontBar.setMaxSize(Bar().defaultWidthBar, Bar().defaultHeightBar)

        // assignment
        fontBar.children.add(comboBox)

        return fontBar
    }


    private fun changeFont(textWindow: VBox, fontSize: Int){
        // changing the font of selected text
        var finished = false

        for(area in textWindow.children){
            val areaLoop = area as InlineCssTextArea

            if(area.selectedText.toList().isNotEmpty()){
                areaLoop.setStyle(area.selection.start, area.selection.end, "-fx-font-size: $fontSize")
                finished = true
                break
            } else {
                finished = false
            }
        }

        // runs code on entire project if nothing is selected
        if(!finished) {
            changeFontAll(textWindow, fontSize)
        }
    }

    // utils

    // change font for each page in project
    private fun changeFontAll(textWindow: VBox, font : Int){
        for(area in textWindow.children){
            val areaLoop = area as InlineCssTextArea
            areaLoop.style = "-fx-font-size: $font"
        }
    }

    // collects each font size available, and returns list of sizes
    private fun getAllSizes(): ObservableList<Int> {
        val list: ObservableList<Int> = FXCollections.observableArrayList()
        var currentNum = 0
        val max = 100
        val multiplesOf = 2

        while(currentNum < max){
            currentNum += currentNum + multiplesOf
            list.add(currentNum)
        }

        return list
    }

}