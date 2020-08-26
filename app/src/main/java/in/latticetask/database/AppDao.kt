package `in`.latticetask.database

import `in`.latticetask.model.User
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user : User)

    @Query("Select * from User")
    fun getAllUser() : List<User>

}