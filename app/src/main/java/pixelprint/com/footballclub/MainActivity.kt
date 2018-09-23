package pixelprint.com.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    private var footballTeam: MutableList<MyTeam> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Bind the recyclerview
        /*val recyclerView = findViewById(R.id.myFootallClub) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)

        val list: ArrayList<MyTeam> = arrayListOf()
        list.add(MyTeam("Barcelona FC",R.drawable.img_barca, "--"))
        list.add(MyTeam("Real Madrid FC",R.drawable.img_madrid, "--"))
        list.add(MyTeam("Bayern Munchen FC",R.drawable.img_bayern, "--"))
        list.add(MyTeam("Manchester City FC",R.drawable.img_city, "--"))
        list.add(MyTeam("Manchester United FC",R.drawable.img_mu, "--"))
        list.add(MyTeam("Chelsea FC",R.drawable.img_chelsea, "--"))
        list.add(MyTeam("AC Milan FC",R.drawable.img_acm, "--"))
        list.add(MyTeam("Arsenal FC",R.drawable.img_arsenal, "--"))

        recyclerView.adapter = MyTeamAdapter(list)*/

        initData()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = MyTeamAdapter(footballTeam){
                    startActivity<SecondActivity>(SecondActivity.POSITIONEXTRA to it)
                    val toast = Toast.makeText(context, it.name, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val keterangan = resources.getStringArray(R.array.club_info)

        footballTeam.clear()

        for (i in name.indices){
            footballTeam.add(MyTeam(name[i], image.getResourceId(i,0), keterangan[i] ))
        }
        Log.e("info", footballTeam.size.toString())

        image.recycle()

    }
}
