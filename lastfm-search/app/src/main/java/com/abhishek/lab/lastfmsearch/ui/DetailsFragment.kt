package com.abhishek.lab.lastfmsearch.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.abhishek.lab.lastfmsearch.R
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.include_toolbar_details.*

/**
 *
 * Created by  Abhishek Pathak on 16-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
class DetailsFragment : Fragment() {

    val args: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar_title.text = args.SearchResult.title
        searchResultType.text = args.SearchResult.resultType.name
        searchResultTitle.text = args.SearchResult.title
        searchResultSubTitle.text = args.SearchResult.subTitle
        Glide.with(imageView)
            .load(args.SearchResult.imageUrlLarge)
            .into(imageView)

        imageView
        button_back.setOnClickListener {
            findNavController().popBackStack()
        }

        open_url.visibility = if (args.SearchResult.url.isNullOrBlank()) View.GONE else View.VISIBLE
        open_url.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(args.SearchResult.url)
            startActivity(openURL)
        }
    }
}
