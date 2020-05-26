package com.example.smssend

import android.os.Bundle
import android.os.StrictMode
import android.util.Log.i
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.smssend.databinding.FragmentSendSmsBinding
import kotlinx.android.synthetic.main.fragment_send_sms.*
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.URL
import java.util.concurrent.TimeUnit


class SendsmsFragment : Fragment() {
    private lateinit var binding: FragmentSendSmsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentSendSmsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_send_sms, container, false)

        binding.text.doAfterTextChanged{
            val senderName = exp_name.text.toString()
            val senderNum = exp_num.text.toString()
            val message = senderName +"("+senderNum+")"+" said:\n" + text.text.toString()
            prev.setText(message)
        }

        binding.sendButton.setOnClickListener{View: View ->
            val CONNECT_TIMEOUT = 15L
            val READ_TIMEOUT = 15L
            val WRITE_TIMEOUT = 15L

            fun performPostOperation(urlString: String, dest: String, text: String, token: String): String? {
                return try {
                    val client = OkHttpClient.Builder()
                        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                        .build()


                    val body = FormBody.Builder()
                        .add("tel", dest)
                        .add("text", text)
                        .build();
                    val request = Request.Builder()
                        .url(URL(urlString))
                        .header("password", token)
                        .post(body)
                        .build()

                    val response = client.newCall(request).execute()
                    response.body?.string()
                }
                catch (e: IOException) {
                    e.printStackTrace()
                    null
                }
            }


            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)

//            val destination = dest.text.toString()
//            val sender_name = exp_name.text.toString()
//            val sender_num = exp_num.text.toString()
//            val message = sender_name +"("+sender_num+")"+" said:\n" + text.text.toString()

            val destination = dest.text.toString()
            val senderName = exp_name.text.toString()
            val senderNum = exp_num.text.toString()
            val message = senderName +"("+senderNum+")"+" said:\n" + text.text.toString()
            performPostOperation("https://theodorelinor.go.ro/sms_send",destination,message,"Ceekap6maiH=u")
            val text = "Message sent!"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(activity, text, duration)
            toast.show()
        }
        return binding.root
    }
}
