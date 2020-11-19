package com.example.kl_hw3

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custom_toast.view.*

private lateinit var btn : Button
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button);
        btn.setOnClickListener {

                val dialog = AlertDialog.Builder(MainActivity@this);
                dialog.setTitle("請選擇功能");
                dialog.setMessage("請根據下方按鈕選擇要顯示的物件")

                dialog.setNeutralButton("取消" ) { DialogInterface, i ->
                    Toast.makeText(MainActivity@ this, "dialog關閉", Toast.LENGTH_SHORT).show();
                }

                dialog.setNegativeButton("自定義Toast") { DialogInterface, i ->
                        showToast();
                }
                dialog.setPositiveButton("顯示list") { DialogInterface, i ->
                    showListDialog();
                }
                dialog.show();
        }
    }
        private fun showToast(){
            val toast = Toast(MainActivity@this);
            toast.setGravity(Gravity.TOP,0,50);
            toast.setDuration(Toast.LENGTH_SHORT);
            val inflater = getLayoutInflater();
            val layout = inflater.inflate(R.layout.custom_toast
                , findViewById<ViewGroup>(R.id.custom_toast_root)  )
            toast.view =layout
            toast.show()
        }


        private fun showListDialog(){
            val  list = arrayOf("message1","message2","message3","message4","message5")
            val dialoglist = AlertDialog.Builder(MainActivity@this);
            dialoglist.setTitle("使用List呈現");
            dialoglist.setItems(list){  DialogInterface , i->
                    Toast.makeText(MainActivity@this, "你選得是"+list[i], Toast.LENGTH_SHORT).show();
            }
            dialoglist.show();
        }
}