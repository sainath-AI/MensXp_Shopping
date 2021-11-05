package com.masai.sainath.mensxp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.sainath.mensxp.adapters.FragmentCatAdapter
import com.masai.sainath.mensxp.databinding.FragmentCategoryBinding
import com.masai.sainath.mensxp.models.FragmentCategoryModel


class CategoryFragment : Fragment() {

    lateinit var database: FirebaseFirestore
    lateinit var binding: FragmentCategoryBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCategoryBinding.inflate(layoutInflater, container, false)


        database= FirebaseFirestore.getInstance()

        database.collection("Categories").addSnapshotListener { value, error ->
            val  listOfFragCAt = arrayListOf<FragmentCategoryModel>()

            val data=value?.toObjects(FragmentCategoryModel::class.java)
            listOfFragCAt.addAll(data!!)

            binding.RevFragmentCar.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            binding.RevFragmentCar.adapter= FragmentCatAdapter(requireContext(),listOfFragCAt)

        }
        return binding.root
    }


}