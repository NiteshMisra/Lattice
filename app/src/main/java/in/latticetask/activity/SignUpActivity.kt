package `in`.latticetask.activity

import `in`.latticetask.R
import `in`.latticetask.databinding.ActivitySignUpBinding
import `in`.latticetask.extras.AppUtils
import `in`.latticetask.model.User
import `in`.latticetask.viewmodel.AppViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        binding.submitBtn.setOnClickListener {

            if(!validate()){
                return@setOnClickListener
            }

            val appViewModel = ViewModelProvider(this).get(AppViewModel::class.java)
            val user = User(
                binding.userNameEdt.text.toString(),
                binding.userAddressEdt.text.toString(),
                binding.userEmailEdt.text.toString(),
                "+91${binding.userPhoneEdt.text}",
                binding.userPasswordEdt.text.toString()
            )
            appViewModel.addUser(user)

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    private fun validate() : Boolean {

        binding.errorMsg.visibility = View.VISIBLE

        // User name

        if (binding.userNameEdt.text.toString().isEmpty()) {
            binding.errorMsg.text = (("* Enter your name"))
            return false
        }

        if (binding.userNameEdt.text.toString().length < 4) {
            binding.errorMsg.text = (("* Name should be at least 4 char. long"))
             return false
        }

        // User Address

        if (binding.userAddressEdt.text.toString().isEmpty()) {
            binding.errorMsg.text = (("* Enter your address"))
            return false
        }

        if (binding.userAddressEdt.text.toString().length < 10) {
            binding.errorMsg.text = (("* Address should be at least 10 char. long"))
            return false
        }

        // User Email Address

        if (binding.userEmailEdt.text.toString().isEmpty()) {
            binding.errorMsg.text = (("* Enter your email-id"))
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(binding.userEmailEdt.text.toString()).matches()) {
            binding.errorMsg.text = (("* Enter valid email address"))
            return false
        }

        // User Mobile No.

        if (binding.userPhoneEdt.text.toString().isEmpty()) {
            binding.errorMsg.text = (("* Enter your mobile no."))
            return false
        }

        if (binding.userPhoneEdt.text.toString().length < 10) {
            binding.errorMsg.text = (("* Mobile no. should be at least 10 char. long"))
            return false
        }

        // User Password

        if (binding.userPhoneEdt.text.toString().isEmpty()) {
            binding.errorMsg.text = (("* Enter your mobile no."))
            return false
        }

        if (binding.userPhoneEdt.text.toString().length < 8) {
            binding.errorMsg.text = (("* Password must be at least 8 char long"))
            return false
        }

        if (binding.userPhoneEdt.text.toString().length > 15) {
            binding.errorMsg.text = (("* Password must be at lesser than 15 char."))
            return false
        }

        if (!AppUtils.isValidPassword(binding.userPasswordEdt.text.toString())) {
            binding.errorMsg.text =
                (("* Password must contain 1 upper character, 1 lower character and a number"))
            return false
        }

        binding.errorMsg.visibility = View.GONE

        return true

    }
}