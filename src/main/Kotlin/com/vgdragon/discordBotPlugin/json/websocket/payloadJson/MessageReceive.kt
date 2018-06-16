package com.vgdragon.discordbot.discord.json.websocket.payloadJson

import com.vgdragon.discordbot.discord.json.*
import java.util.*

/*
type

0       DEFAULT
1       RECIPIENT_ADD
2       RECIPIENT_REMOVE
3       CALL
4       CHANNEL_NAME_CHANGE
5       CHANNEL_ICON_CHANGE
6       CHANNEL_PINNED_MESSAGE
7       GUILD_MEMBER_JOIN
 */
class MessageReceive{
    val id: String = ""
    val channel_id: String = ""
    val author: User = User()
    val content: String = ""
    val timestamp: Date = Date()
    val edited_timestamp: Date = Date()
    val tts: Boolean = false
    val mention_everyone: Boolean = false
    val mentions: List<User> = mutableListOf()
    val mention_roles: List<Role> = mutableListOf()
    val attachments: List<Attachments> = mutableListOf()
    val embeds: List<Embed> = mutableListOf()
    val reactions: List<Reaction> = mutableListOf()
    val nonce: String = ""
    val pinned: Boolean = false
    val webhook_id: String = ""
    val type: Int = 0
    val messageActivity: MessageActivity = MessageActivity()
    val application: Application = Application()
}

/*
type

1       JOIN
2       SPECTATE
3       LISTEN
5       JOIN_REQUEST
 */
class MessageActivity{
    val type: Int = 0
    val party_id: String = ""
}
class Application{
    val id: String = ""
    val cover_image: String = ""
    val description: String = ""
    val icon: String = ""
    val name: String = ""
}

