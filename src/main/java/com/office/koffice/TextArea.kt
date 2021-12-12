package com.office.koffice

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.ScrollPane
import javafx.scene.control.TextArea
import javafx.scene.layout.*
import javafx.scene.text.Text
import org.fxmisc.richtext.InlineCssTextArea
import java.io.File
import kotlin.random.Random


class TextArea {
    private val mapOfPages = HashMap<String, ArrayList<String>>()
    private val scrollPages = ScrollPane()
    val documentTextField = InlineCssTextArea()



    fun getAllText(textWindow: VBox) : String{
        var allText = ""
        println(textWindow.children)

        for(item in textWindow.children){
            val itemMod = item as InlineCssTextArea
            allText += itemMod.text
            println(itemMod.text)
        }

        return allText
    }


    fun writeToTextBox(text : String, type: Int, textWindow : VBox){
        textWindow.children.clear()
        if(type == 0){
            var num = 15
            val list = text.toList()

            while(list.size >= num){
                add(textWindow, list.subList(0, 2200).toString())
                num += 2200
                continue
            }
            add(textWindow, text)
        }
    }

    fun add(textWindow: VBox,){
        val autoPage = InlineCssTextArea()
        autoPage.setMaxSize(1000.0, 720.0)
        autoPage.setMinSize(1000.0, 720.0)
        autoPage.isWrapText = true
        autoPage.styleClass.add("textWindow")

        autoPage.setOnMouseClicked {

        }

        autoPage.setOnKeyPressed { key ->
            println(textWindow.children.size)
            if(autoPage.length > 30 && textWindow.children.indexOf(autoPage) == textWindow.children.size - 1) {
                add(textWindow)

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
        scrollPages.vbarPolicy = ScrollPane.ScrollBarPolicy.ALWAYS


    }

    private fun add(textWindow: VBox, text : String){
        println(textWindow.children.size)

        val autoPage = InlineCssTextArea()
        autoPage.setMaxSize(1000.0, 720.0)
        autoPage.setMinSize(1000.0, 720.0)
        autoPage.isWrapText = true
        autoPage.styleClass.add("textWindow")


        autoPage.setOnKeyPressed { key ->
            println(textWindow.children.size)
            if(autoPage.length > 30 && textWindow.children.indexOf(autoPage) == textWindow.children.size - 1) {
                add(textWindow)
                //isInlineCssTextAreaFull(autoPage)
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

    fun writingField(mainWindow: BorderPane, textWindow: VBox) : ScrollPane{
        scrollPages.styleClass.add("scroll-page")


        documentTextField.setOnKeyPressed {
            if(documentTextField.length > 30 && documentTextField.length > 30 && textWindow.children.indexOf(documentTextField) == textWindow.children.size - 1){
                add(textWindow)
            }
        }


        documentTextField.isWrapText = true
        // documentTextField.font = Font.font(12.0)


        scrollPages.content = textWindow
        scrollPages.maxWidth = 700.0
        scrollPages.isResizable
        textWindow.spacing = 17.0
        documentTextField.setMaxSize(1000.0, 720.0)
        documentTextField.setMinSize(1000.0, 720.0)
        documentTextField.styleClass.add("textWindow")

        scrollPages.vbarPolicy = ScrollPane.ScrollBarPolicy.ALWAYS
        scrollPages.hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
        scrollPages.hmax = 0.0
        textWindow.children.add(documentTextField)

        return scrollPages
    }


    // utils
}