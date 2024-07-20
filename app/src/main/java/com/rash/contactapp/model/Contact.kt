package com.rash.contactapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Contact
    (
    @DrawableRes val picture : Int,
    @StringRes val name : Int ,
    val phone : String
) {
}