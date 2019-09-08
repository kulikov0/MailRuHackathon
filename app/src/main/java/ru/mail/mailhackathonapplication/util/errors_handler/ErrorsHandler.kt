package ru.mail.mailhackathonapplication.util.errors_handler

interface ErrorsHandler {

    fun handleError(error: Int?, httpErrorCode: Int? = null)

}