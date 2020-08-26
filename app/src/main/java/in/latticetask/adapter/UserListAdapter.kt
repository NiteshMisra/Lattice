package `in`.latticetask.adapter

import `in`.latticetask.R
import `in`.latticetask.model.User
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter(private var userList : List<User>) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    class UserViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val name : TextView = view.findViewById(R.id.name)
        val address : TextView = view.findViewById(R.id.address)
        val email : TextView = view.findViewById(R.id.email)
        val phone : TextView = view.findViewById(R.id.phone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_user_list,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.name.text = ("Name : ${currentItem.name}")
        holder.address.text = ("Address : ${currentItem.address}")
        holder.email.text = ("Email : ${currentItem.email}")
        holder.phone.text = ("Phone : ${currentItem.mobile}")
    }

}