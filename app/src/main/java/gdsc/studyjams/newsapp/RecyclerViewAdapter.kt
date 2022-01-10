package gdsc.studyjams.newsapp

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import gdsc.studyjams.newsapp.databinding.RecyclerViewItemBinding
import gdsc.studyjams.newsapp.model.Article


class RecyclerViewAdapter(
    private val context: Context,
    var news: List<Article>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var binding: RecyclerViewItemBinding

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val diff = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        binding = RecyclerViewItemBinding.bind(view)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
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
            binding.headlineText.text = news[position].title
            setOnClickListener {
                onItemClickListener?.let { it(news[position]) }
            }

        }

//        binding.headlineImage.setImageResource(news[position].urlToImage)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    // adding onClick listener to the RecyclerViewHolder
    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

}