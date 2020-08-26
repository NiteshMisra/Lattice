package `in`.latticetask.extras

import `in`.latticetask.dagger.AppInterfaceComponent
import `in`.latticetask.dagger.AppModule
import `in`.latticetask.dagger.DaggerAppInterfaceComponent
import android.app.Application
import android.content.Context

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        context = this
        init()

    }

    companion object {

        private lateinit var appInterfaceComponent : AppInterfaceComponent
        private lateinit var context: Context

        fun getDaggerComponent(): AppInterfaceComponent {
            return appInterfaceComponent
        }
    }

    private fun init() {
        appInterfaceComponent = DaggerAppInterfaceComponent.builder()
            .appModule(AppModule(context))
            .build()
        appInterfaceComponent.inject(this)
    }

}