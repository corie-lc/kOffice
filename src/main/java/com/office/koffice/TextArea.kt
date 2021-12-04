package com.office.koffice

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.ScrollPane
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import org.fxmisc.richtext.CodeArea
import org.fxmisc.richtext.StyleClassedTextArea
import java.io.File
import kotlin.random.Random


class TextArea {
    private val mapOfPages = HashMap<String, ArrayList<String>>()
    private val scrollPages = ScrollPane()
    val documentTextField = CodeArea()

    fun getAllText(textWindow: VBox) : String{
        var allText = ""
        println(textWindow.children)

        for(item in textWindow.children){
            val itemMod = item as CodeArea
            allText += itemMod.text
            println(itemMod.text)
        }

        return allText
    }


    fun writeToTextBox(text : String, type: Int, textWindow : VBox){
        println(textWindow.children)
        textWindow.children.clear()
        if(type == 0){
            var num = 15
            val list = text.toList()

            while(list.size >= num){
                add(textWindow, list.subList(0, 6200).toString())
                num += 6200
                continue
            }
            add(textWindow, text)
        }
    }

    private fun add(textWindow: VBox,){
        println(textWindow.children.size)

        val autoPage = CodeArea()
        autoPage.setMaxSize(1000.0, 720.0)
        autoPage.setMinSize(1000.0, 720.0)
        autoPage.isWrapText = true
        autoPage.styleClass.add("textWindow")


        autoPage.setOnKeyPressed { key ->
            println(textWindow.children.size)
            if(autoPage.length > 30 && textWindow.children.indexOf(autoPage) == textWindow.children.size - 1) {
                add(textWindow)
                //isCodeAreaFull(autoPage)
            }
            val id = autoPage.id

            if(mapOfPages.containsKey(id)){
                mapOfPages[id]?.add(key.code.char)
            } else{
                mapOfPages[id] = ArrayList<String>()
                mapOfPages[id]?.add(key.code.char)
            }
        }

        autoPage.id = Random.nextInt().toString()
        textWindow.children.add(autoPage)


    }

    private fun add(textWindow: VBox, text : String){
        println(textWindow.children.size)

        val autoPage = CodeArea()
        autoPage.setMaxSize(1000.0, 720.0)
        autoPage.setMinSize(1000.0, 720.0)
        autoPage.isWrapText = true
        autoPage.styleClass.add("textWindow")



        autoPage.setOnKeyPressed { key ->
            println(textWindow.children.size)
            if(autoPage.length > 30 && textWindow.children.indexOf(autoPage) == textWindow.children.size - 1) {
                add(textWindow)
                //isCodeAreaFull(autoPage)
            }
            val id = autoPage.id

            if(mapOfPages.containsKey(id)){
                mapOfPages[id]?.add(key.code.char)
            } else{
                mapOfPages[id] = ArrayList<String>()
                mapOfPages[id]?.add(key.code.char)
            }
        }

        autoPage.id = Random.nextInt().toString()
        autoPage.replaceText(text)
        textWindow.children.add(autoPage)


    }

    fun writingField(scene: Scene, mainWindow : VBox, textWindow: VBox){
        mainWindow.children.add(scrollPages)


        documentTextField.setOnKeyPressed {
            if(documentTextField.length > 30 && documentTextField.length > 30 && textWindow.children.indexOf(documentTextField) == textWindow.children.size - 1){
                add(textWindow)
            }
        }


        documentTextField.isWrapText = true
        // documentTextField.font = Font.font(12.0)


        scrollPages.content = textWindow
        scrollPages.maxWidth = 1000.0
        textWindow.alignment = Pos.BOTTOM_CENTER
        textWindow.spacing = 17.0
        documentTextField.setMaxSize(1000.0, 720.0)
        documentTextField.setMinSize(1000.0, 720.0)
        documentTextField.styleClass.add("textWindow")

        scrollPages.vbarPolicy = ScrollPane.ScrollBarPolicy.ALWAYS
        scrollPages.hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
        scrollPages.hmax = 0.0
        textWindow.children.add(documentTextField)
    }

    // utils
}