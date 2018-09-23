package pixelprint.com.footballclub

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class MyTeamUI : AnkoComponent<ViewGroup> {

    companion object {
        val tvTitleId = 1
        val tvYearId = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        /*verticalLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)

            textView {
                id = tvTitleId
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                text = "Sherlock"
                textSize = 16f // <- it is sp, no worries
                textColor = Color.BLACK
            }

            textView {
                id = tvYearId
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                text = "2009"
                textSize = 14f
            }
        }*/

        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView{
                id = tvYearId
                imageResource = R.drawable.img_arsenal

            }.lparams(dip(50), dip(50))

            textView {
                id = tvTitleId
                text = "Coba FC"
            }.lparams(matchParent, wrapContent){
                margin = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }

        }
    }
}