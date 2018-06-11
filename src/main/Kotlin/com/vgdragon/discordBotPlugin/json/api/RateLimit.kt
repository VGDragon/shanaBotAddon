package com.vgdragon.discordbot.discord.json.api

import java.util.*

class RateLimit(val limit: Long, val remaining: Long, val reset: Date)