package com.example.earthquarkalartapp

import android.widget.EditText

fun EditText.isEmpty() : Boolean {
    return if (this.text.toString().isEmpty()) {
        this.error = "This place need to be filled up?"
        true
    } else {
        false
    }
}