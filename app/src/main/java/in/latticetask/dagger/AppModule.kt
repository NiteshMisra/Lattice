package `in`.latticetask.dagger

import `in`.latticetask.database.AppDataBase
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var context: Context) {

    @Provides
    @Singleton
    fun getDataBase() : AppDataBase {
        return AppDataBase.getInstance(context)
    }

}