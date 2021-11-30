package com.office.koffice

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.ScrollPane
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import org.fxmisc.richtext.CodeArea
import kotlin.random.Random


class TextArea {
    val mapOfPages = HashMap<String, ArrayList<String>>()

    fun writingField(scrollPages : ScrollPane, textWindow: VBox, scene: Scene){

        val documentTextField = CodeArea()
        textWindow.children.add(documentTextField)

        fun isCodeAreaFull(area: CodeArea) {
            //31

            // }
        }

        fun add(){
            val autoPage = CodeArea()
            autoPage.setMaxSize(700.0, 750.0)
            autoPage.setMinSize(700.0, 750.0)
            autoPage.isWrapText = true

            autoPage.setOnKeyPressed { key ->
                println(autoPage.style)
                if(autoPage.length > 10 && textWindow.children.indexOf(autoPage) == textWindow.children.size - 1) {
                    add()
                    //isCodeAreaFull(autoPage)
                }
                val id = autoPage.id
                println(autoPage.baselineOffset)

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

        documentTextField.setOnKeyPressed {
            if(documentTextField.length > 10 && textWindow.children.indexOf(documentTextField) == textWindow.children.size - 1){
                add()
            }
        }

        documentTextField.isWrapText = true
        // documentTextField.font = Font.font(12.0)


        scrollPages.content = textWindow
        scrollPages.maxWidth = 700.0
        textWindow.alignment = Pos.CENTER
        textWindow.spacing = 17.0
        documentTextField.setMaxSize(700.0, 720.0)
        documentTextField.setMinSize(700.0, 720.0)



        scrollPages.vbarPolicy = ScrollPane.ScrollBarPolicy.ALWAYS
        scrollPages.hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
        scrollPages.hmax = 0.0
    }
}