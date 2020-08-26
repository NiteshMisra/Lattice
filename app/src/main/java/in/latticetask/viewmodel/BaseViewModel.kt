package `in`.latticetask.viewmodel

import `in`.latticetask.database.AppDataBase
import `in`.latticetask.extras.MyApplication
import android.content.Context
import androidx.lifecycle.ViewModel
import javax.inject.Inject

open class BaseViewModel : ViewModel() {

    // Add all the common things used in most of the view Model

    @Inject
    lateinit var appDataBase: AppDataBase

    init {
        MyApplication.getDaggerComponent().inject(this)
    }

}