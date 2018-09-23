package pixelprint.com.footballclub

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext

/**
 * Created by agus on 22/09/18.
 */

class MyTeamAdapter(var list : MutableList<MyTeam>, var listener: (MyTeam) -> Unit) : RecyclerView.Adapter<MyTeamAdapter.TeamViewHolder>() {

    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
//        return TeamViewHolder(MainActivity.MyTeamUI().createView(AnkoContext.create(parent.context, parent)))
        return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent, false))
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(MyTeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    /*override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
//        val movie = list[position]
//        holder.tvTitle.text = movie.title
//        holder.tvYear.text = "${movie.image}"

        holder.bindItem(list[position])
    }*/

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(list[position], listener)
    }

    /*override fun getItemCount(): Int {
        return list.size
    }*/

    override fun getItemCount(): Int = list.size

//    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    /*inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        var tvTitle: TextView
//        var tvYear: TextView
//
//        init {
//            tvTitle = itemView.findViewById(MainActivity.MyTeamUI.tvTitleId)
//            tvYear = itemView.findViewById(MainActivity.MyTeamUI.tvYearId)
//        }

        fun bindItem(items: MyTeam, listener: (MyTeam) -> Unit) {
//      name.text = items.name
//      Glide.with(itemView.context).load(items.image).into(image)
            *//*itemView.name.text = items.name
            Glide.with(itemView.context).load(items.image).into(itemView.image)

            itemView.setOnClickListener {
//                listener(items)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    itemView.context.startActivity<SecondActivity>("image" to items.image, "name" to items.name
                }
            }*//*

            var imageView : ImageView
            var textView : TextView

            init {
                imageView = itemView.findViewById(MyTeamUI.tvYearId)
                textView = itemView.findViewById(MyTeamUI.tvTitleId)
            }

            fun bindItem (items : MyTeam, listener : (MyTeam) -> Unit){
                textView.text = items.name
                Glide.with(itemView.context).load(items.image).into(imageView)
                itemView.setOnClickListener {
                    listener(items)
                }
            }
        }

    }*/

    inner class TeamViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var imageView : ImageView
        var textView : TextView

        init {
            imageView = itemView.findViewById(MyTeamUI.tvYearId)
            textView = itemView.findViewById(MyTeamUI.tvTitleId)
        }

        fun bindItem (items : MyTeam, listener : (MyTeam) -> Unit){
            textView.text = items.name
            Glide.with(itemView.context).load(items.image).into(imageView)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}