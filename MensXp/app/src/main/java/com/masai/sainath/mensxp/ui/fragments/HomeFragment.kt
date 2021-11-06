package com.masai.sainath.mensxp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import android.R
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.android.synthetic.main.fragment_home.*


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


//        val imageList=ArrayList<SlideModel>()
//        imageList.add(SlideModel("https://img.mensxp.com/media/shop/template/2021/nov/damensch-shop-banner-1635921095.jpeg?w=2380&h=982&cc=1&q=75",ScaleTypes.FIT))
//        imageList.add(SlideModel("https://img.mensxp.com/media/shop/template/2021/nov/mud-curated-box-banner-shop-1635789790.gif?w=2380&h=982&cc=1&q=75",ScaleTypes.FIT))
//        imageList.add(SlideModel("https://img.mensxp.com/media/shop/template/2021/oct/whisky-shop-mobile-banner-1635491801.jpeg?w=2380&h=982&cc=1&q=75",ScaleTypes.FIT))
//        imageList.add(SlideModel("https://img.mensxp.com/media/shop/template/2021/oct/ray-ban-mensxp-talent-banner-2200x906-1635404402.jpeg?w=2380&h=982&cc=1&q=75",ScaleTypes.FIT))
//        ImageSlider.setImageList(imageList,ScaleTypes.FIT)
        return binding.root
    }




}



