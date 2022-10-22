package com.example.newsscrap.newsdetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsscrap.databinding.FragmentNewsDetailsBinding

class FragmentNewsDetails : Fragment() {

    private lateinit var mBinding: FragmentNewsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = FragmentNewsDetailsArgs.fromBundle(requireArguments())
        Log.i("ARGUMENTO GUAY", args.url.toString())
        mBinding.wvNoticia.loadUrl(args.url!!)
    }



}