package com.office.koffice.bar

import javafx.application.Platform
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.ColorPicker
import javafx.scene.control.ComboBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import org.fxmisc.richtext.InlineCssTextArea


class FontBar {

    fun getFontBar(scene: Scene, textWindow: VBox) : VBox{
        val fontBar = VBox()
        val comboBox: ComboBox<*> = ComboBox<Int>(getAllSizes())
        val colorPicker = ColorPicker()

        comboBox.setOnAction {
            changeStyle(textWindow,"-fx-font-size: ${comboBox.value.toString().toInt()};")
        }
        colorPicker.setOnAction {
            changeStyle(textWindow,"-fx-fill: ${toRGBCode(colorPicker.value)}")
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
        fontBar.children.add(colorPicker)

        return fontBar
    }

    private fun getStyleHolderList(textWindow: VBox, style: String) : List<Any>{
        val returnList = mutableListOf<Any>()

        for(area in textWindow.children){
            area as InlineCssTextArea

            return if(area.selectedText.toList().isNotEmpty()){
                returnList.addAll(0, mutableListOf(area.selection.start, area.selection.end, style))
                returnList
            } else {
                returnList.add(style)
                returnList
            }
        }

        return returnList
    }

    private fun changeStyle(textWindow: VBox, style: String, start: Int, end: Int){
        // changing the font of selected text
        var finished = false

        for(area in textWindow.children){
            val areaLoop = area as InlineCssTextArea

            if(area.selectedText.toList().isNotEmpty()){
                areaLoop.setStyle(start, end, style)
                finished = true
                break
            } else {
                finished = false
            }
        }

        // runs code on entire project if nothing is selected
        if(!finished) {
            changeStyleAll(textWindow, style)
        }
    }


    private fun changeStyle(textWindow: VBox, style: String){
        // changing the font of selected text
        var finished = false

        for(area in textWindow.children){
            val areaLoop = area as InlineCssTextArea

            if(area.selectedText.toList().isNotEmpty()){
                areaLoop.setStyle(areaLoop.selection.start, area.selection.end, style)
                finished = true
                break
            } else {
                finished = false
            }
        }

        // runs code on entire project if nothing is selected
        if(!finished) {
            changeStyleAll(textWindow, style)
        }
    }

    // utils

    // change font for each page in project
    private fun changeStyleAll(textWindow: VBox, style: String){
        for(area in textWindow.children){
            val areaLoop = area as InlineCssTextArea
            println(style)
            areaLoop.style = style
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

    // utils
    private fun toRGBCode(color: Color): String {
        return String.format(
            "#%02X%02X%02X",
            (color.red * 255).toInt(),
            (color.green * 255).toInt(),
            (color.blue * 255).toInt()
        )
    }


}