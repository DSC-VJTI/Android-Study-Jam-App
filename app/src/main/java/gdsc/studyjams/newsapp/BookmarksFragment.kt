package gdsc.studyjams.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import gdsc.studyjams.newsapp.databinding.FragmentBookmarksBinding
import gdsc.studyjams.newsapp.model.Article
import gdsc.studyjams.newsapp.viewmodels.ListViewModel

class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {

    private var _binding: FragmentBookmarksBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: ListViewModel
    lateinit var adapter: BookmarksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        // obtaining the instance of view model from the ViewModelProviderFactory present in MainActivity
        viewModel = (activity as MainActivity).viewModel

        val bookmarks = viewModel.getBookmarks()

        bookmarks.observe(viewLifecycleOwner, { bookmark ->
            adapter =
                activity?.let { activityContext -> BookmarksAdapter(activityContext, bookmark) }!!
            adapter.diff.submitList(bookmark)
            val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            binding.articleHeadline.adapter = adapter
            binding.articleHeadline.layoutManager = layoutManager

            binding.articleHeadline.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )

            adapter.setOnItemClickListener {
                val bundle = Bundle().apply {
                    putSerializable("article", Article(it.headline, it.url))
                }
                findNavController().navigate(
                    R.id.action_bookmarks_fragment_to_newsFragment2,
                    bundle
                )
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