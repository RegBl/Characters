package io.github.regbl.characters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.regbl.characters.databinding.FragmentRandomCharacterBinding

@AndroidEntryPoint
class RandomCharacterFragment : Fragment() {

    private val viewModel: RandomCharacterViewModel by viewModels()
    private var _binding: FragmentRandomCharacterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRandomCharacterBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.randomCharacterViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.button.setOnClickListener { viewModel.getRandomCharacter() }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}