package gdsc.stydyjams.newsapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import gdsc.stydyjams.newsapp.database.bookmark.Bookmark
import gdsc.stydyjams.newsapp.databinding.FragmentBookmarksBinding
import gdsc.stydyjams.newsapp.viewmodels.ListViewModel

class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {

    private var _binding: FragmentBookmarksBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: ListViewModel
    lateinit var recyclerViewAdapter: BookmarksRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        // obtaining the instance of view model from the ViewModelProviderFactory present in MainActivity
        viewModel = (activity as MainActivity).viewModel

        val bookmarks = viewModel.getBookmarks()

//        val bookmarks = MutableLiveData(listOf(Bookmark("Hi","google.com"),
//            Bookmark("Bye","apple.com")))

        bookmarks.observe(viewLifecycleOwner, Observer {bookmarks ->
            recyclerViewAdapter =
                activity?.let { activityContext -> BookmarksRecyclerViewAdapter(activityContext, bookmarks) }!!
            recyclerViewAdapter.diff.submitList(bookmarks)
            val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            binding.articleHeadline.adapter = recyclerViewAdapter
            binding.articleHeadline.layoutManager = layoutManager

            binding.articleHeadline.addItemDecoration(
                    DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )

            recyclerViewAdapter.setOnItemClickListener { bookmark ->
                val bundle = Bundle().apply {
                    putSerializable("url", bookmark.url)
                }
               findNavController().navigate(R.id.action_bookmarks_fragment_to_newsFragment2, bundle)
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}