package com.kingfly.colibri.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kingfly.colibri.data.Contact

class ContactViewmodel: ViewModel() {
    private lateinit var contacts: MutableLiveData<Contact>
}