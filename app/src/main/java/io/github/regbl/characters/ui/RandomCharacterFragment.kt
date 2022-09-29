package io.github.regbl.characters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.github.regbl.characters.databinding.FragmentRandomCharacterBinding

class RandomCharacterFragment : Fragment() {

    lateinit var viewModel: RandomCharacterViewModel
    private var _binding: FragmentRandomCharacterBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[RandomCharacterViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRandomCharacterBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.randomCharacterViewModel = viewModel

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}