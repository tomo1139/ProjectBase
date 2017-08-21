package develop.beta1139.projectbase.views;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import develop.beta1139.projectbase.R;
import develop.beta1139.projectbase.databinding.ActivityMainBinding;
import develop.beta1139.projectbase.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setMainViewModel(new MainViewModel());
    }
}
