package gdsc.stydyjams.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import gdsc.stydyjams.newsapp.databinding.FragmentNewsBinding
import androidx.fragment.app.FragmentActivity
import android.app.Activity
import android.text.Layout
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController


class NewsFragment : Fragment(R.layout.fragment_news) {
    private var myContext: FragmentActivity? = null
    private var _binding: FragmentNewsBinding? = null
    private lateinit var navController: NavController
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // inflate the layout and bind to the _binding
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
//        val navHostFragment: NavHostFragment? = (childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?)
//        if (navHostFragment != null) {
//            navController = navHostFragment.navController
//        }
//        binding.saveButton.setOnClickListener {
////            var dialog = CustomDialogFragment()
////            val fragManager: FragmentManager = myContext!!.supportFragmentManager
////            dialog.show(fragManager,"customDialog")
//            val action = NewsFragmentDirections.actionNewsFragmentToDialogFragment()
//            findNavController().navigate(action)
//
//        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onAttach(activity: Activity) {
        myContext = activity as FragmentActivity
        super.onAttach(activity)
    }


}