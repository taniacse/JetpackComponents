package com.example.jetpackcomponents.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpackcomponents.R
import kotlinx.android.synthetic.main.activity_coroutins_example.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinsExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutins_example)

        button.setOnClickListener {

            CoroutineScope(IO).launch {
                fakeApiRequest()
            }


        }
    }

    private  suspend fun fakeApiRequest(){
        val resilt1 = getResultFromApi()
        println("debug : $resilt1")

        textView.text = resilt1
    }

    private suspend fun getResultFromApi():String{


        LogThread("getResultFromApi")
        delay(1000)
        return "Result #1"
    }

    private fun LogThread(methodName: String){

        println("Debug : $methodName : ${Thread.currentThread().name}")
    }
}
