package com.android.holyeat.data.model

import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser
import java.util.*

data class Message (
    val _id: String,
    val _text: String,
    val _user: Author,
    val _createAt: Date,
        ): IMessage {
    override fun getId(): String {
        return _id
    }

    override fun getText(): String {
       return _text
    }

    override fun getUser(): IUser {
        return _user
    }

    override fun getCreatedAt(): Date {
       return _createAt
    }
}