package gdsc.stydyjams.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gdsc.stydyjams.newsapp.databinding.FragmentListBinding
import gdsc.stydyjams.newsapp.viewmodels.ListViewModel


class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private val viewmodel : ListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // inflate the layout and bind to the _binding
        _binding = FragmentListBinding.inflate(inflater, container, false)

        var news = viewmodel.news
        val adapter = RecyclerViewAdapter(news.value!!)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        news.observe(viewLifecycleOwner, {
            val adapter = RecyclerViewAdapter(it)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
            Toast.makeText(context,"News Updated!",Toast.LENGTH_SHORT)
        })

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}