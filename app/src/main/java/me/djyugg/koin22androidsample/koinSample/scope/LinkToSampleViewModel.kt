package me.djyugg.koin22androidsample.koinSample.scope

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LinkToSampleViewModel(private val linkToSampleClass: LinkToSampleClass) : ViewModel() {
    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    fun updateText(text: String) = _text.postValue("$text, ${linkToSampleClass.getText()}")
}