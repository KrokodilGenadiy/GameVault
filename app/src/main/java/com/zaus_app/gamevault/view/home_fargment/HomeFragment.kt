package com.zaus_app.gamevault.view.home_fargment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaus_app.gamevault.databinding.FragmentHomeBinding
import com.zaus_app.gamevault.domain.Interactor
import com.zaus_app.gamevault.utils.Converter
import com.zaus_app.gamevault.view.MainActivity
import com.zaus_app.moviefrumy_20.view.rv_adaptes.GamesAdapter
import com.zaus_app.moviefrumy_20.view.rv_adaptes.TopSpacingItemDecoration
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeFragmentViewModel by viewModels()
    private val filmsAdapter by lazy {
        GamesAdapter(object : GamesAdapter.OnItemClickListener {
            override fun click(id: Int) {
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainRecycler.apply {
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        getGames()
    }

    private fun getGames() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMovies().collectLatest { games ->
                filmsAdapter.submitData(games)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
