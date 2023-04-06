package ru.netology.nmedia.entity

import ru.netology.nmedia.dto.Attachment
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.enumeration.AttachmentType
import jakarta.persistence.*

@Entity
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    var author: String,
    var authorAvatar: String,
    @Column(columnDefinition = "TEXT")
    var time: String,
    var content: String,
    var likedByMe: Boolean,
    var likesAmount: Int = 0,
    var repostAmount: Int = 0,
    var video: String?
) {
    fun toDto() = Post(id, author, authorAvatar, time, content, likedByMe, likesAmount, repostAmount, video)

    companion object {
        fun fromDto(dto: Post) = PostEntity(
            dto.id,
            dto.author,
            dto.authorAvatar,
            dto.time,
            dto.content,
            dto.likedByMe,
            dto.likesAmount,
            dto.repostAmount,
            dto.video
        )
    }
}

@Embeddable
data class AttachmentEmbeddable(
    var url: String,
    @Column(columnDefinition = "TEXT")
    var description: String?,
    @Enumerated(EnumType.STRING)
    var type: AttachmentType,
) {
    fun toDto() = Attachment(url, description, type)

    companion object {
        fun fromDto(dto: Attachment?) = dto?.let {
            AttachmentEmbeddable(it.url, it.description, it.type)
        }
    }
}
