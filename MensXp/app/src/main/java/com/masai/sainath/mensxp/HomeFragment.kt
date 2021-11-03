package com.masai.sainath.mensxp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.sainath.mensxp.adapters.BrandSpotLightAdapter
import com.masai.sainath.mensxp.adapters.CategoryImgAdapter
import com.masai.sainath.mensxp.adapters.ExclusiveAdapter
import com.masai.sainath.mensxp.adapters.FashionAdapter
import com.masai.sainath.mensxp.databinding.FragmentHomeBinding
import com.masai.sainath.mensxp.models.BrandModel
import com.masai.sainath.mensxp.models.CatImgModel
import com.masai.sainath.mensxp.models.ExclusiveModel
import com.masai.sainath.mensxp.models.FashionModel


class HomeFragment : Fragment() {

    lateinit var database: FirebaseFirestore
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater, container, false)

        database= FirebaseFirestore.getInstance()

        database.collection("Categories").addSnapshotListener { value, error ->
            val  listofCategories = arrayListOf<CatImgModel>()

            val data=value?.toObjects(CatImgModel::class.java)
            listofCategories.addAll(data!!)

            binding.RevCategories.layoutManager=
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
            binding.RevCategories.adapter= CategoryImgAdapter(requireContext(),listofCategories)

        }
        database.collection("BrandSpotLight").addSnapshotListener { value, error ->
            val  listOfBrands = arrayListOf<BrandModel>()

            val data=value?.toObjects(BrandModel::class.java)
            listOfBrands.addAll(data!!)

            binding.RevbrandSpotlight.layoutManager= GridLayoutManager(requireContext(),2)
            binding.RevbrandSpotlight.adapter= BrandSpotLightAdapter(requireContext(),listOfBrands)

        }

        database.collection("Exclusive").addSnapshotListener { value, error ->
            val  listOfExclusive = arrayListOf<ExclusiveModel>()

            val data=value?.toObjects(ExclusiveModel::class.java)
            listOfExclusive.addAll(data!!)

            binding.RevExclusive.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            binding.RevExclusive.adapter= ExclusiveAdapter(requireContext(),listOfExclusive)

        }
        database.collection("Fashion").addSnapshotListener { value, error ->
            val  listOfFashion = arrayListOf<FashionModel>()

            val data=value?.toObjects(FashionModel::class.java)
            listOfFashion.addAll(data!!)

            binding.RevFashion.layoutManager= GridLayoutManager(requireContext(),3)
            binding.RevFashion.adapter= FashionAdapter(requireContext(),listOfFashion)

        }
        return binding.root
    }




}



