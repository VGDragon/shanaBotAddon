package com.vgdragon.discordbot.discord.json.api.send

import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonObject
import com.vgdragon.discordbot.discord.json.Permission
import com.vgdragon.discordbot.discord.json.Role
import java.awt.Color

class CreateGuildRole(var name:String = "new role", var permission: Permission? = null, var color: Color = Color(0, 0, 0), var hoist: Boolean = false, var mentionable: Boolean = false){

    fun put(role: Role){
        name = role.name
        permission = Permission()
        permission!!.putPermissions(role.permissions)
        val roleColor = Color(role.color)
        color = Color(roleColor.red, roleColor.green, roleColor.blue, 0)
        hoist = role.hoist
        mentionable = role.mentionable
    }

    fun getJson(): JsonObject{
        val list: MutableList<Pair<String, Any>> = mutableListOf()
        if(name.isNotBlank()){
            if(!name.equals("new role"))
                list.add(Pair("name", name))
        }
        if(permission != null)
            list.add(Pair("permissions", permission!!.getPermissions()))
        if(color.rgb >= 0)
            list.add(Pair("color", color.rgb))
        if(hoist)
            list.add(Pair("hoist", hoist))
        if(mentionable)
            list.add(Pair("mentionable", mentionable))

        return jsonObject(list)

    }


}