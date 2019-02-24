package maple.story.star.netty.extension

import io.netty.channel.ChannelHandlerContext
import io.netty.util.AttributeKey
import maple.story.star.client.MapleClient
import java.net.InetSocketAddress

fun <T> ChannelHandlerContext.get(key: AttributeKey<T>): T? =
    channel().attr(key).get()

fun ChannelHandlerContext.client(): MapleClient? =
    get(MapleClient.CLIENT_KEY)

fun <T> ChannelHandlerContext.set(key: AttributeKey<T>, value: T) {
    channel().attr(key).set(value)
}

fun ChannelHandlerContext.client(client: MapleClient) {
    set(MapleClient.CLIENT_KEY, client)
}

fun ChannelHandlerContext.ip(): String =
    (channel().remoteAddress() as InetSocketAddress).hostString

fun ChannelHandlerContext.clear() {
    channel().attr(MapleClient.CLIENT_KEY).set(null)
}