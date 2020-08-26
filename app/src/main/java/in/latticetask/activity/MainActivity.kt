package `in`.latticetask.activity

import `in`.latticetask.R
import `in`.latticetask.adapter.UserListAdapter
import `in`.latticetask.databinding.ActivityMainBinding
import `in`.latticetask.viewmodel.AppViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.userListRcv.layoutManager = LinearLayoutManager(this)

        val appViewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        appViewModel.getUsers().observe(this, Observer {
            it?.apply {
                val userListAdapter = UserListAdapter(this)
                binding.userListRcv.adapter = userListAdapter
                userListAdapter.notifyDataSetChanged()
            }
        })

    }
}