package com.example.rec

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rec.databinding.FragmentFirstBinding
import com.example.rec.rec.Adapter
import com.example.rec.rec.Product
import com.example.rec.retrofit.ApiInterface
import com.example.rec.retrofit.RetrofitClient

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }












getUserList()
        Log.e("wwwxxx",getUserList().toString())

        binding.myItemRecycleView.layoutManager=LinearLayoutManager(activity)
        var mList=ArrayList<Product>()
        for (i in 1..209){
           val item = Product("name $i","$i+100","$i   $i   $i")
            mList.add(item)
        }
        val adapter= Adapter(mList)
        binding.myItemRecycleView.adapter=adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getUserList(){
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val respone = apiInterface.getallUsers()
                if (respone.isSuccessful){
                    Log.e("wwwxxx",respone.body().toString())
                    val body= respone.body()
                    val gest= body!!.data.get(0)

                }
                else{
                    Log.e("xfdsf","asdfasdf")
                }
            }catch (Ex:java.lang.Exception){
                Log.e("sdf","sdf")
            }
        }
    }
}