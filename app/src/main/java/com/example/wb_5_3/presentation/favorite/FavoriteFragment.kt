package com.example.wb_5_3.presentation.favorite

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wb_5_3.R
import com.example.wb_5_3.appComponent
import com.example.wb_5_3.databinding.FragmentFavoriteBinding
import com.example.wb_5_3.utils.Resource
import javax.inject.Inject


class FavoriteFragment : Fragment() {

    private var binding: FragmentFavoriteBinding? = null

    private var adapter: FavoriteAdapter? = null

    private var loadingPermission: Boolean = true

    private val vm: FavoriteViewModel by viewModels{
        viewModelFactory
    }

    @Inject
    lateinit var viewModelFactory: FavoriteViewModelFactory

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        vm.favoriteCatsList.observe(viewLifecycleOwner, Observer {
            adapter?.submitList(it)
            binding?.favoriteProgressBar?.visibility = View.GONE
        })

        vm.loadingPermission.observe(viewLifecycleOwner, Observer {
            loadingPermission = it
        })

        if (loadingPermission) {
            vm.getFavoriteCats().observe(viewLifecycleOwner, Observer { resource ->
                when (resource) {
                    is Resource.Success -> {
                        resource.data?.let { vm.setFavoriteCatsList(it) }
                    }
                    is Resource.Error -> {
                        resource.message?.let { Log.e("Error", it) }
                        Toast.makeText(context, resource.message, Toast.LENGTH_SHORT).show()
                        binding?.favoriteProgressBar?.visibility = View.GONE
                    }
                    is Resource.Loading -> {
                        binding?.favoriteProgressBar?.visibility = View.VISIBLE
                    }
                }
            })
            vm.setLoadingPermissionFalse()
        }
    }

    private fun setupRecyclerView() {
        adapter = FavoriteAdapter()

        binding?.apply {
            favoriteRecyclerView.adapter = adapter
            favoriteRecyclerView.layoutManager = GridLayoutManager(context, 2)
            favoriteRecyclerView.itemAnimator = null
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}