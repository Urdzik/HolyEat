package com.android.holyeat.data.model

import com.stfalcon.chatkit.commons.models.IUser
import java.util.*

data class Author(
    val _id: String,
    val _name: String,
    val _avatar: String,
) : IUser {

    override fun getId(): String {
        return _id
    }

    override fun getName(): String {
        return _name
    }

    override fun getAvatar(): String {
        return _avatar
    }
}
