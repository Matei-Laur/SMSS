package com.example.smssend

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.smssend.databinding.FragmentMainBinding
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.smssend.SMS_Response
import kotlinx.coroutines.launch


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val Header: Header = Header( "SMS Send is a demo app that calls a private API to send short messages from the 0726697455 Vodafone phone number to an arbitrary destination.")
    private val Footer: Footer = Footer( "Of course is dark. Dark as pitch to protect the eyes.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val V: View = inflater.inflate(R.layout.fragment_send_sms, container, false)
//        val button =  V.findViewById<View>(R.id.send_button) as Button
//        val dest =  V.findViewById<View>(R.id.dest) as EditText
//        val text =  V.findViewById<View>(R.id.text) as EditText
       val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
  //      binding = FragmentMainBinding.inflate(layoutInflater);
        binding.header=Header
        binding.footer=Footer
        binding.sendASms.setOnClickListener{View: View ->
            Navigation.findNavController(View).navigate(R.id.action_mainFragment_to_sendsmsFragment)
        }

        return binding.root
    }
}