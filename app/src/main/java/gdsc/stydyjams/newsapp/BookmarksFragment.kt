package gdsc.stydyjams.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import gdsc.stydyjams.newsapp.databinding.FragmentBookmarksBinding
import gdsc.stydyjams.newsapp.viewmodels.ListViewModel

class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {

    private var _binding: FragmentBookmarksBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: ListViewModel
    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // obtaining the instance of view model from the ViewModelProviderFactory present in MainActivity
        viewModel = (activity as MainActivity).viewModel
        val bookmarks = viewModel.getBookmarks()


//        recyclerViewAdapter = activity?.let { activityContext -> bookmarks.value?.let {
//            RecyclerViewAdapter(activityContext,
//                it
//            )
//        } }!!
//
//
//        bookmarks.observe(viewLifecycleOwner, Observer {article ->
//            recyclerViewAdapter.diff.submitList(article)
//        })


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmarks, container, false)
    }



}