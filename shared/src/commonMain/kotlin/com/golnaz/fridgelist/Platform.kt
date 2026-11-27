package com.golnaz.fridgelist

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform