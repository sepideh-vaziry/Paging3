package com.paging.example.model

import java.io.Serializable

class Answer : Serializable {

    var owner: Owner? = null
    var score: Int = 0
    var answer_id: Long = 0
    var question_id: Long = 0

}