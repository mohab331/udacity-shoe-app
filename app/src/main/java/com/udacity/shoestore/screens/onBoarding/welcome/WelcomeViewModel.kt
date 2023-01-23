
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.OnBoardingWelcomeModel

class WelcomeViewModel : ViewModel() {
     val welcomeModel  = OnBoardingWelcomeModel(title = "Welcome!" , welcomeText = "you can store and retrieve shoe information")
}