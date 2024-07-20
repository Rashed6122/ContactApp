package com.rash.contactapp.data

import com.rash.contactapp.R
import com.rash.contactapp.model.Contact

class DataSource {
    fun getContactData(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        contacts.add(
            Contact(
                R.drawable.son, R.string.son, "+20102239787"
            )
        )
        contacts.add(
            Contact(
                R.drawable.auntie, R.string.auntie, "+2011987654"
            )
        )
        contacts.add(
            Contact(
                R.drawable.granny, R.string.granny, "+209871456"
            )
        )
        contacts.add(
            Contact(
                R.drawable.sister, R.string.sister, "+2018642345"
            )
        )
        contacts.add(
            Contact(
                R.drawable.uncle, R.string.uncle, "+2098142578"
            )
        )
        contacts.add(
            Contact(
                R.drawable.brother, R.string.brother, "+205642987"
            )
        )
        contacts.add(
            Contact(
                R.drawable.daughter, R.string.daughter, "+2053678912"
            )
        )
        contacts.add(
            Contact(
                R.drawable.friend_1, R.string.friend_1, "+20876124539"
            )
        )
        contacts.add(
            Contact(
                R.drawable.friend_2, R.string.friend_2, "+20674533"
            )
        )
        contacts.add(
            Contact(
                R.drawable.neigbour, R.string.neighbour, "+208911235"
            )
        )
        contacts.add(
            Contact(
                R.drawable.grandfather, R.string.grandfather, "+2011987565"
            )
        )
        return contacts
    }
}