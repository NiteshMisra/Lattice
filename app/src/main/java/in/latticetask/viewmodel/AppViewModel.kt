package `in`.latticetask.viewmodel

import `in`.latticetask.model.User
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gallery.extra.Coroutines

class AppViewModel : BaseViewModel() {

    private val appDao = appDataBase.playListDao()

    fun addUser(user: User) {
        Coroutines.io { appDao?.apply { this.addUser(user) } }
    }

    fun getUsers(): LiveData<List<User>> {
        val userList: MutableLiveData<List<User>> = MutableLiveData()
        Coroutines.io { appDao?.apply { userList.postValue(this.getAllUser()) } }
        return userList
    }

}