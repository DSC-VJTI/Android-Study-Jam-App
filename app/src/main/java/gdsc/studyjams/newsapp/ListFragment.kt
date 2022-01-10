package gdsc.studyjams.newsapp

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import gdsc.studyjams.newsapp.databinding.FragmentListBinding
import gdsc.studyjams.newsapp.viewmodels.ListViewModel


class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: ListViewModel

    // to add the Bookmarks icon to the action bar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_bookmarks, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // adding the navigation logic to the action bar icon
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_navigate_to_bookmarks -> {
            goToNextScreen()
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // adds the options i.e., the bookmark icon to the action bar once the view is created
        setHasOptionsMenu(true)

        // obtaining the instance of view model from the ViewModelProviderFactory present in MainActivity
        viewModel = (activity as MainActivity).viewModel

        // inflate the layout and bind to the _binding
        _binding = FragmentListBinding.inflate(inflater, container, false)

        // obtaining the data to populate the recycler view
        val news = viewModel.news

        // setting up the recycler view
        news.observe(viewLifecycleOwner, {
            val adapter =
                activity?.let { activityContext -> RecyclerViewAdapter(activityContext, it) }
            val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = layoutManager

            // add default divider
            binding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            Toast.makeText(context, "News Updated!", Toast.LENGTH_SHORT).show()

            adapter?.setOnItemClickListener { article ->
                val bundle = Bundle().apply {
                    putSerializable("article", article)
                }
                findNavController().navigate(R.id.action_listFragment_to_newsFragment2, bundle)
            }
        })

        // inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun goToNextScreen() {
        findNavController().navigate(R.id.action_listFragment_to_bookmarksFragment)
    }

}