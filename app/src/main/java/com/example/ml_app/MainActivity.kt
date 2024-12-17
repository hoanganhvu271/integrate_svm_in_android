package com.example.ml_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ml_app.ui.theme.ML_appTheme

import com.chaquo.python.Python
import com.chaquo.python.PyObject
import com.chaquo.python.android.AndroidPlatform
//
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this));
        }

        predictSVM();
        enableEdgeToEdge()
        setContent {
            ML_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



fun predictSVM(): String {

    val features = IntArray(611) { 0 }

    // Khởi tạo Chaquopy
    val python = Python.getInstance()
    val pyModule = python.getModule("predict") // Tên file Python

    // Gọi hàm `predict` từ file Python
    val result: PyObject = pyModule.callAttr("predict", features)

    // Trả về kết quả
    Log.d("vu", "result: $result");
    return result.toString()


}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ML_appTheme {
        Greeting("Android")
    }
}