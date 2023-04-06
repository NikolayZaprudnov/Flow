package ru.netology.nmedia.dto

import ru.netology.nmedia.enumeration.AttachmentType

data class Post(
    val id: Long,
    val author: String,
    val authorAvatar: String = "",
    val time: String,
    val content: String,
    val likedByMe: Boolean,
    val likesAmount: Int = 0,
    val repostAmount: Int = 0,
    var video: String? = null,
)

data class Attachment(
    val url: String,
    val description: String?,
    val type: AttachmentType,
)
