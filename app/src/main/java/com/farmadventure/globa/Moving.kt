package com.farmadventure.globa

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.*

class Moving : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moving)
        val textView: TextView = findViewById(R.id.txtMover)
        runBlocking {

            val job: Job = GlobalScope.launch(Dispatchers.IO) {
                getAsync(applicationContext)
            }
            job.join()
            val jsoup: String? = Hawk.get(Const.aResult, "")
            Log.d("cora", "cora $jsoup")

            textView.text = jsoup

            if (jsoup == "9jKc") {
                Intent(applicationContext, TestActivity::class.java).also { startActivity(it) }

            } else {
                Intent(applicationContext, Vieweb::class.java).also { startActivity(it) }
            }
            finish()
        }
    }

    private suspend fun getAsync(context: Context) {
        val asyncKey = Jsu(context)
        val asyncResult = asyncKey.getDocSecretKey()
        Hawk.put(Const.aResult, asyncResult)
    }
}