package develop.beta1139.projectbase.viewModels;

import android.databinding.ObservableField;

/**
 * Created by tomo on 2017/08/21.
 */

public class MainViewModel {
    public ObservableField<String> mText = new ObservableField<>();

    public MainViewModel() {
        mText.set("text from MainViewModel");
    }
}