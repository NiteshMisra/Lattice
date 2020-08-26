package `in`.latticetask.dagger

import `in`.latticetask.extras.MyApplication
import `in`.latticetask.viewmodel.AppViewModel
import `in`.latticetask.viewmodel.BaseViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppInterfaceComponent {

    fun inject(myApplication : MyApplication)

    fun inject(baseViewModel: BaseViewModel)

}