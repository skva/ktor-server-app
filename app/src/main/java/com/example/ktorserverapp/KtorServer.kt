package com.example.ktorserverapp

import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

class KtorServer {
    private var server: NettyApplicationEngine? = null

    fun start() {
        server = embeddedServer(Netty, port = 8080) {
            routing {
                get ("/") {
                    call.respondText("Hello, Ktor!", ContentType.Text.Plain)
                }
                get ( "/hello" ) {
                    call.respondText("Hello, World!", ContentType.Text.Plain)
                }
            }
        }
        server?.start(wait = false)
    }

    fun stop() {
        server?.stop(1000, 1000)
    }
}