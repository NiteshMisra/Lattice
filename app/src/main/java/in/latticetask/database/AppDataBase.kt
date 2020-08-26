package `in`.latticetask.database

import `in`.latticetask.extras.Constants
import `in`.latticetask.model.User
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun playListDao(): AppDao?

    companion object {
        private var instance: AppDataBase ?= null
        @Synchronized
        fun getInstance(context: Context): AppDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java, Constants.DATABASE_NAME
                ).fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }

}