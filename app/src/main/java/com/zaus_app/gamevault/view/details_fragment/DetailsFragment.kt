package com.zaus_app.gamevault.view.details_fragment

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.zaus_app.gamevault.R
import com.zaus_app.gamevault.data.entity.Game
import com.zaus_app.gamevault.data.entity.GameDetails
import com.zaus_app.gamevault.data.entity.RawgGame
import com.zaus_app.gamevault.databinding.FragmentDetailsBinding
import com.zaus_app.gamevault.utils.Converter
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailsFragmentViewModel by viewModels()
    private var _game: GameDetails? = null
    private val game get() = _game!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.get("id") as Int
        lifecycleScope.launch {
            _game = viewModel.interactor.getGameDetails(id).body()!!
            setGameDetails(game)
        }

        binding.detailsFabShare.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(
                Intent.EXTRA_TEXT,
                resources.getString(R.string.check_out)+" ${game.name} \n ${game.description}"
            )
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, resources.getString(R.string.share_to)))
        }
    }

    private fun setGameDetails(game: GameDetails) {
        binding.title.text = game.name
        binding.genres.text = Converter.convertGenresToString(game.genres)
        Glide.with(this)
            .load(game.backgroundImage)
            .centerCrop()
            .into(binding.detailsPoster)
        binding.detailsDescription.text = game.description
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}