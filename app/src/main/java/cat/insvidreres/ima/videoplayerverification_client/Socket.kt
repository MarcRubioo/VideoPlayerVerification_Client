package cat.insvidreres.ima.videoplayerverification_client

import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

object Socket  {

    lateinit var mSocket: Socket
    @Synchronized
    fun setSocket() {
        try {
            mSocket = IO.socket("localhost:8888")
        } catch (e: URISyntaxException) {

        }
    }
    @Synchronized
    fun getSocket(): Socket {
        return mSocket
    }
    @Synchronized
    fun establishConnection() {
        mSocket.connect()
    }
    @Synchronized
    fun closeConnection() {
        mSocket.disconnect()
    }
}