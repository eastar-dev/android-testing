package dev.eastar.tdd.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dev.eastar.tdd.R
import dev.eastar.tdd.databinding.SingleFrBinding

class SingleFr : Fragment() {

    companion object {
        fun newInstance() = SingleFr()
    }

    private lateinit var bb: SingleFrBinding
    private val viewModel: SingleViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        bb = SingleFrBinding.inflate(inflater, container, false)
        bb.viewmodel = viewModel
        return inflater.inflate(R.layout.single_fr, container, false)
    }
}