package pixelprint.com.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by agus on 22/09/18.
 */

@Parcelize
data class MyTeam(var name: String, var image: Int, val keterangan : String) : Parcelable