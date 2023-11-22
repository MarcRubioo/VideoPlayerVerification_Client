package cat.insvidreres.ima.videoplayerverification_client

import android.widget.Toast
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException

object Socket  {

    lateinit var mSocket: Socket
    @Synchronized
    fun setSocket() {
        try {
            mSocket = IO.socket("http://169.254.180.117:8888")
        } catch (e: URISyntaxException) {
            e.printStackTrace()
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