package `in`.latticetask.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var name : String,
    var address : String,
    var email : String,
    val mobile : String,
    val password : String
){

    @NonNull
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

}