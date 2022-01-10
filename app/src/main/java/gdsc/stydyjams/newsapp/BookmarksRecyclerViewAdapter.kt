package gdsc.stydyjams.newsapp

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import gdsc.stydyjams.newsapp.database.bookmark.Bookmark
import gdsc.stydyjams.newsapp.databinding.RecyclerViewItemBinding

class BookmarksRecyclerViewAdapter(
    private val context: Context,
    private val bookmarks:List<Bookmark>
    ) : RecyclerView.Adapter<BookmarksRecyclerViewAdapter.ItemViewHolder>() {

    private lateinit var binding: RecyclerViewItemBinding

    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.headlineText)
    }

    private val differCallback = object : DiffUtil.ItemCallback<Bookmark>() {
        override fun areItemsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
            return oldItem == newItem
        }
    }

    val diff = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item , parent, false)
        binding = RecyclerViewItemBinding.bind(adapterLayout)
        return ItemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.root.setBackgroundColor(
                context.resources.getColor(
                    R.color.primary_background,
                    context.theme
                )
            )
        }
        holder.itemView.apply {
            binding.headlineText.setTextColor(Color.LTGRAY)
            binding.headlineText.text = bookmarks[position].headline
            setOnClickListener {
                onItemClickListener?.let { it(bookmarks[position]) }
            }

        }
    }

    override fun getItemCount(): Int = bookmarks.size

    private var onItemClickListener: ((Bookmark) -> Unit)? = null

    fun setOnItemClickListener(listener: (Bookmark) -> Unit) {
        onItemClickListener = listener
    }
}