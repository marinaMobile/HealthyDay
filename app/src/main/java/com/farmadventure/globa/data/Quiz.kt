package com.farmadventure.globa.data

object Quiz {

    fun getQues(): ArrayList<Question> {

        val quesList = ArrayList<Question>()

        val ques1 = Question(1, "Сколько у Вас приемов пищи за день?",
           "Один", "Два", "Три", "Я не считаю")

        quesList.add(ques1)

        val ques2 = Question(2, "Вы ведете здоровый образ жизни?",
            "Пытаюсь, но не всегда получается", "Конечно", "Иногда", "Нет")

        quesList.add(ques2)

        val ques3 = Question(3, "Вы занимаетесь физической активностью?",
            "Иногда встаю с дивана", "Занимаюсь", "Выхожу на пробежку раз в год", "Редко")

        quesList.add(ques3)

        return quesList
    }
}