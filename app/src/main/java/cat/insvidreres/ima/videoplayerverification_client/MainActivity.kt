package cat.insvidreres.ima.videoplayerverification_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cat.insvidreres.ima.videoplayerverification_client.databinding.ActivityMainBinding
import io.socket.emitter.Emitter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Socket.setSocket()
        Socket.establishConnection()

        val mSocket = Socket.getSocket()
        val codi = binding.editTextText.text

        mSocket.on("HOLA", Emitter.Listener { args ->
            val message = args[0] as String
            println("RECEIVED HOLA EVENT: $message")
        })

        binding.button.setOnClickListener{
            mSocket.emit("EnviarCodiPeli", codi.toString())
            Toast.makeText(this, "Codi enviat!!! ", Toast.LENGTH_SHORT).show()
        }
    }
}