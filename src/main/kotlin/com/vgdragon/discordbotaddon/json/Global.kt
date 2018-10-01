package com.vgdragon.discordbot.discord.json

import com.github.salomonbrys.kotson.jsonArray
import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.vgdragon.discordbot.discord.json.api.receive.IntegrationObject
import java.util.*

class UnavailableGuild{
    val id: String = ""
    val unavailable: Boolean = false
}
class Attachments (
    val id: String = "",
    val filename: String = "",
    val size: Long = 0,
    val url: String = "",
    val proxy_url: String = "",
    val height: Long = 0,
    val width: Long = 0
)

/*
 * Examples:
 * https://anidiotsguide_old.gitbooks.io/discord-js-bot-guide/content/examples/using-embeds-in-messages.html
 */
class Embed (
        /**
         * The Title of the Emdeb.
         * The url will be placed on the Title.
         */
        var title: String = "",
        /**
         * type of embed (always "rich" for webhook embeds)
         */
        var type: String = "",
        var description: String = "",
        /**
         * url of embed (in the Title)
         */
        var url: String = "",
        /**
         * 	ISO8601 timestamp
         */
        var timestamp: Date? = null,
        /**
         * 	the color strip on the right
         * 	See: https://www.tydac.ch/color/
         */
        var color: Long = 16711680,
        var footer: Footer = Footer(),
        var image: Image = Image(),
        var thumbnail: Thumbnail = Thumbnail(),
        var video: Video = Video(),
        var provider: Provider = Provider(),
        var author: Author = Author(),
        var fields: List<Field> = mutableListOf()){

    /**
     * To copy the Data of an Embed Class in this Class.
     *
     * No idea why I did this o.O
     */
    fun put(embed: Embed){
        title = embed.title
        type = embed.type
        description = embed.description
        url = embed.url
        timestamp = embed.timestamp
        color = embed.color
        footer = embed.footer
        image = embed.image
        thumbnail = embed.thumbnail
        video = embed.video
        provider = embed.provider
        author = embed.author
        fields = embed.fields
    }
}
class Image(
    val url: String = "",
    val proxy_url: String = "",
    val height: Long = 0,
    val width: Long = 0
)
class Thumbnail(
    val url: String = "",
    val proxy_url: String = "",
    val height: Long = 0,
    val width: Long = 0
)
class Video (
    val url: String = "",
    val height: Long = 0,
    val width: Long = 0
)
class Provider(
    val name: String = "",
    val url: String = ""
)
class Author (
    val name: String = "",
    val url: String = "",
    val icon_url: String = "",
    val proxy_icon_url: String = ""
)
class Field (
    val name: String = "",
    val value: String = "",
    val inline: Boolean = false
)
class Footer(
    val text: String = "",
    val icon_url: String = "",
    val proxy_icon_url: String = ""
)
class Reaction (
    val count: Long = 0,
    /**
     * whether the current user reacted using this emoji
     */
    val me: Boolean = false,
    val emoji: Emoji = Emoji()
)
class Emoji (
    val id: String = "",
    val name: String = "",
    val roles: List<Role> = mutableListOf(),
    val user: User = User(),
    val require_colons: Boolean = false,
    val managed: Boolean = false,
    val animated: Boolean = false
)
class Role (
    val id: String = "",
    val name: String = "",
    val color: Int = 0,
    /**
     * whether the role should be displayed separately in the sidebar
     */
    val hoist: Boolean = false,
    val position: Int = 0,
    val permissions: Long = 0,
    val managed: Boolean = false,
    val mentionable: Boolean = false
){
    /**
     * to get a readable version of the Rights
     */
    fun simblePermissionView(): Permission{
        val permission = Permission()
        permission.putPermissions(permissions)
        return permission
    }
}
class User(val id: String = "",
           val username: String = "",
           /**
            * Example: VG Dragon#8672
            * discriminator = 8672
            */
           val discriminator: String = "",
           /**
            * the user's avatar hash
            * See: https://discordapp.com/developers/docs/reference#image-formatting
            */
           val avatar: String = "",
           val bot: Boolean = false,
           /**
            * whether the user has two factor enabled on their account
            */
           val mfa_enabled: Boolean = false,
           /**
            * 	whether the email on this account has been verified
            */
           val verified: Boolean = false,
           val email: String = "")
class Channel(

    val id : String,
    /**
    * type
    * 0     GUILD_TEXT
    * 1     DM
    * 2     GUILD_VOICE
    * 3     GROUP_DM
    * 4     GUILD_CATEGORY
     */
    val type : Int,
    val guild_id : String,
    val position : Int,
    val permission_overwrites : List<PermissionOverwrite>,
    val name : String,
    val topic : String,
    val nsfw : Boolean,
    val last_message_id: String,
    val bitrate : Int,
    val user_limit : Int,
    /**
     * the recipients of the DM
     */
    val recipients : List<User>,
    val icon : String,
    /**
     * 	id of the DM creator
     */
    val owner_id : String,
    /**
     * application id of the group DM creator if it is bot-created
     */
    val application_id : String,
    val parent_id : String,
    val last_pin_timestamp : Date
)
class PermissionOverwrite(
    val id : String = "",
    /**
     * either "role" or "member"
     */
    val type : String = "",
    val allow : Long = 0,
    val deny : Long = 0
){
    fun getJson(): JsonObject{
        return jsonObject("id" to id,
                "type" to type,
                "allow" to allow,
                "deny" to deny)
    }
}
class Guild (
    val id: String ,
    /**
     * 	guild name (2-100 characters)
     */
    val name: String ,
    /**
     * icon hash
     */
    val icon: String ,
    /**
     * splash hash
     */
    val splash: String ,
    /**
     * whether or not the user(Bot) is the owner of the guild
     */
    val owner: Boolean ,
    val owner_id: String ,
    /**
     * 	total permissions for the user in the guild (does not include channel overrides)
     */
    val permissions: Int ,
    /**
     * voice region id for the guild
     */
    val region: String ,
    val afk_channel_id: String ,
    val afk_timeout: Long ,
    val embed_enabled: Boolean ,
    val embed_channel_id: String ,
    /**
     * 0	NONE	        unrestricted
     * 1	LOW	            must have verified email on account
     * 2	MEDIUM	        must be registered on Discord for longer than 5 minutes
     * 3	HIGH	        (╯°□°）╯︵ ┻━┻ - must be a member of the server for longer than 10 minutes
     * 4	VERY_HIGH	    ┻━┻ミヽ(ಠ益ಠ)ﾉ彡┻━┻ - must have a verified phone number
     */
    val verification_level: Int ,
    /**
     * 0    ALL_MESSAGES
     * 1    ONLY_MENTIONS
     */
    val default_message_notifications: Int ,
    /**
     * 0    DISABLED
     * 1    MEMBERS_WITHOUT_ROLES
     * 2    ALL_MEMBERS
     */
    val explicit_content_filter: Int ,
    val roles: List<Role> ,
    val emojis: List<Emoji> ,
    /**
     * enabled guild features
     */
    val features: List<String> ,
    /**
     * two factor
     * 0    NONE
     * 1    ELEVATED
     */
    val mfa_level: Int,
    /**
     * application id of the guild creator if it is bot-created
     */
    val application_id: String,
    val widget_enabled: Boolean,
    val widget_channel_id: String,
    /**
     * the id of the channel to which system messages are sent
     */
    val system_channel_id: String,

    /*
    *   These fields are only sent within the GUILD_CREATE event
     */
    /**
     * ISO8601 timestamp
     */
    val joined_at: Date,
    val large: Boolean,
    val unavailable: Boolean,
    val member_count: Int,
    /**
     * (without the guild_id key)
     */
    val voice_states: List<VoiceState>,
    val members: List<Member>,
    val channels: List<Channel>,
    val presences: List<PresenceUpdate>
)
class VoiceState {
    val guild_id: String = ""
    val channel_id: String = ""
    val user_id: String = ""
    /**
     * the guild member this voice state is for
     */
    val member: Member = Member()
    val session_id: String = ""
    val deaf: Boolean = false
    val mute: Boolean = false
    val self_deaf: Boolean = false
    val self_mute: Boolean = false
    val suppress: Boolean = false
}
class Member {
    val user: User = User()
    val nick: String = ""
    val roles: List<String> = listOf()
    val joined_at: Date = Date()
    val deaf: Boolean = false
    val mute: Boolean = false
}
class PresenceUpdate (
    val user: User,
    val roles: List<String>,
    val game: Activity,
    val guild_id: String,
    val status: String
)


class Permission{
    var createInstantInvite: Boolean = false
    var kickMembers: Boolean = false
    var banMembers: Boolean = false
    var administrator: Boolean = false
    var manageChannels: Boolean = false
    var manageGuild: Boolean = false
    var addReactions: Boolean = false
    var viewAuditLog: Boolean = false
    var viewChannel: Boolean = false
    var sendMessages: Boolean = false
    var sendTtsMessages: Boolean = false
    var manageMessages: Boolean = false
    var embedLinks: Boolean = false
    var attachFiles: Boolean = false
    var readMessageHistory: Boolean = false
    var mentionEveryone: Boolean = false
    var useExternalEmojis: Boolean = false
    var connect: Boolean = false
    var speak: Boolean = false
    var muteMembers: Boolean = false
    var deafenMembers: Boolean = false
    var moveMembers: Boolean = false
    var useVad: Boolean = false
    var changeNickname: Boolean = false
    var manageNicknames: Boolean = false
    var manageRoles: Boolean = false
    var manageWebhooks: Boolean = false
    var manageEmojis: Boolean = false

    fun setAllTrue(){
        createInstantInvite = true
        kickMembers = true
        banMembers = true
        administrator = true
        manageChannels = true
        manageGuild = true
        addReactions = true
        viewAuditLog = true
        viewChannel = true
        sendMessages = true
        sendTtsMessages = true
        manageMessages = true
        embedLinks = true
        attachFiles = true
        readMessageHistory = true
        mentionEveryone = true
        useExternalEmojis = true
        connect = true
        speak = true
        muteMembers = true
        deafenMembers = true
        moveMembers = true
        useVad = true
        changeNickname = true
        manageNicknames = true
        manageRoles = true
        manageWebhooks = true
        manageEmojis = true
    }
    /**
     * The Permissions in Discord are Numbers.
     * The number need to be converted into Binary to read the Permissions.
     * This function convert the Rights into a number(Permission).
     */
    fun getPermissions(): Long{
        val list: MutableList<Int> = mutableListOf()

        list.add(if(createInstantInvite) 1 else 0)
        list.add(if(kickMembers) 1 else 0)
        list.add(if(banMembers) 1 else 0)
        list.add(if(administrator) 1 else 0)
        list.add(if(manageChannels) 1 else 0)
        list.add(if(manageGuild) 1 else 0)
        list.add(if(addReactions) 1 else 0)
        list.add(if(viewAuditLog) 1 else 0)
        list.add(0)
        list.add(0)
        list.add(if(viewChannel) 1 else 0)
        list.add(if(sendMessages) 1 else 0)
        list.add(if(sendTtsMessages) 1 else 0)
        list.add(if(manageMessages) 1 else 0)
        list.add(if(embedLinks) 1 else 0)
        list.add(if(attachFiles) 1 else 0)
        list.add(if(readMessageHistory) 1 else 0)
        list.add(if(mentionEveryone) 1 else 0)
        list.add(if(useExternalEmojis) 1 else 0)
        list.add(0)
        list.add(if(connect) 1 else 0)
        list.add(if(speak) 1 else 0)
        list.add(if(muteMembers) 1 else 0)
        list.add(if(deafenMembers) 1 else 0)
        list.add(if(moveMembers) 1 else 0)
        list.add(if(useVad) 1 else 0)
        list.add(if(changeNickname) 1 else 0)
        list.add(if(manageNicknames) 1 else 0)
        list.add(if(manageRoles) 1 else 0)
        list.add(if(manageWebhooks) 1 else 0)
        list.add(if(manageEmojis) 1 else 0)

        return convertBinaryToDecimal(list)

    }
    /**
     * The Permissions in Discord are Numbers.
     * The number need to be converted into Binary to read the Permissions.
     * This function convert the number(Permission) into readable Rights.
     */
    fun putPermissions(permissions: Long){
        val convertDecimalToBinary = convertDecimalToBinary(permissions)
        for((int, bool) in convertDecimalToBinary.withIndex()){
            when(int) {
                0 -> createInstantInvite = bool == 1
                1 -> kickMembers = bool == 1
                2 -> banMembers = bool == 1
                3 -> administrator = bool == 1
                4 -> manageChannels = bool == 1
                5 -> manageGuild = bool == 1
                6 -> addReactions = bool == 1
                7 -> viewAuditLog = bool == 1
                8 -> null
                9 -> null
                10 -> viewChannel = bool == 1
                11 -> sendMessages = bool == 1
                12 -> sendTtsMessages = bool == 1
                13 -> manageMessages = bool == 1
                14 -> embedLinks = bool == 1
                15 -> attachFiles = bool == 1
                16 -> readMessageHistory = bool == 1
                17 -> mentionEveryone = bool == 1
                18 -> useExternalEmojis = bool == 1
                19 -> null
                20 -> connect = bool == 1
                21 -> speak = bool == 1
                22 -> muteMembers = bool == 1
                23 -> deafenMembers = bool == 1
                24 -> moveMembers = bool == 1
                25 -> useVad = bool == 1
                26 -> changeNickname = bool == 1
                27 -> manageNicknames = bool == 1
                28 -> manageRoles = bool == 1
                29 -> manageWebhooks = bool == 1
                30 -> manageEmojis = bool == 1
            }
        }

    }

    private fun convertBinaryToDecimal(num: List<Int>): Long {
        var num = num
        var decimalNumber = 0L
        var bit: Long = 1
        for((i, int) in num.withIndex()){
            if(i == 0){
                decimalNumber = int.toLong()
                continue
            }
            bit *= 2
            decimalNumber += (int * bit)

        }
        return decimalNumber
    }
    private fun convertDecimalToBinary(n: Long): List<Int> {
        var n = n
        var remainder: Int

        val list: MutableList<Int> = mutableListOf()
        while (n != 0L) {
            remainder = (n % 2).toInt()
            n /= 2
            list.add(remainder)
        }
        return list
    }


}
class ConnectionObject(
        val id:String,
        val name: String,
        val type: String,
        val revoked: Boolean,
        val integrations: List<IntegrationObject>

)
class EditPosition(
        /**
         * for Channel position: Channel ID
         * for Role position: Role ID
         */
        var id: String ,
        var position: Int)
class Activity(
        val name	            : String,
        val type	            : Int,
        val url                 : String,
        val timestamps          : Timestamps,
        val application_id      : String,
        val details             : String,
        val state               : String,
        val party               : Party,
        val assets              : Assents,
        val secrets             : ActivitySecrets,
        val instance            : Boolean,
        val flags               : Int

)
data class Party(
        var size: PartySize? = null,
        var id: String = ""
) {

    fun getJson(): JsonObject {
        val pairList: MutableList<Pair<String, Any>> = mutableListOf()
        if(id.isNotBlank())
            pairList.add(Pair("id", id))
        if(size != null)
            pairList.add(Pair("size", size!!.getJson().asJsonObject))
        if(pairList.size < 1)
            return jsonObject()

        return jsonObject(pairList)
    }
}
data class Assents(
        var large_image: String = "",
        var large_text: String = "",
        var small_image: String = "",
        var small_text: String = ""
) {

    fun getJson(): JsonObject{

        val pairList: MutableList<Pair<String, Any>> = mutableListOf()
        if(large_image.isNotBlank())
            pairList.add(Pair("large_image", large_image))
        if(large_text.isNotBlank())
            pairList.add(Pair("large_text", large_text))
        if(small_image.isNotBlank())
            pairList.add(Pair("small_image", small_image))
        if(small_text.isNotBlank())
            pairList.add(Pair("small_text", small_text))

        if(pairList.size < 1)
            return jsonObject()

        return jsonObject(pairList)
    }

}

class ActivitySecrets(
        val join: String,
        val spectate: String,
        val match: String
)

data class PartySize(
        var currentSize: Int = 1,
        var maximalSize: Int = 1
) {

    fun getJson(): JsonArray {
        return jsonArray(currentSize, maximalSize)
    }
}
data class Timestamps(
        var start: Long = 0,
        var end: Long = 0
){

    fun getJson(): JsonObject{
        val pairList: MutableList<Pair<String, Any>> = mutableListOf()
        if(start > 0)
            pairList.add(Pair("start", start))
        if(end > 0)
            pairList.add(Pair("end", end))
        if(pairList.size > 1)
            return jsonObject()

        return jsonObject(pairList)
    }
}