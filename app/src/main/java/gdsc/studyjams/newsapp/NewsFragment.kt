package gdsc.studyjams.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import gdsc.studyjams.newsapp.databinding.FragmentNewsBinding
import gdsc.studyjams.newsapp.viewmodels.ListViewModel


class NewsFragment : Fragment(R.layout.fragment_news) {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ListViewModel
    private val args by navArgs<NewsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // inflate the layout and bind to the _binding
        _binding = FragmentNewsBinding.inflate(inflater, container, false)

        // obtaining the instance of view model from the ViewModelProviderFactory present in MainActivity
        viewModel = (activity as MainActivity).viewModel

        // obtain the arguments passed from ListFragment - check nav_graph.xml for details about the argument passed
        val article = args.article

        // creating the web view for the URL provided in the article
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        // adding the article to the bookmark Room database on clicking the FloatingActionButton
        binding.fab.setOnClickListener {
            viewModel.addBookmark(article)
            view?.let { view ->
                Snackbar.make(
                    view,
                    "Article added to bookmarks",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        // inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}