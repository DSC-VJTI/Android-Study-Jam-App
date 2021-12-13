package gdsc.stydyjams.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gdsc.stydyjams.newsapp.databinding.FragmentListBinding


class ListFragment : Fragment(R.layout.fragment_list) {


    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // inflate the layout and bind to the _binding
        _binding = FragmentListBinding.inflate(inflater, container, false)

            var news = mutableListOf(
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
        )

        val adapter = RecyclerViewAdapter(news)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}