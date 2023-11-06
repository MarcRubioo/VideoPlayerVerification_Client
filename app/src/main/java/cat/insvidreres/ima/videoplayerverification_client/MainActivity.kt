package cat.insvidreres.ima.videoplayerverification_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.insvidreres.ima.videoplayerverification_client.databinding.ActivityMainBinding


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

        binding.button.setOnClickListener{
            mSocket.emit("EnviarCodiPeli", codi.toString())

        }
    }
}