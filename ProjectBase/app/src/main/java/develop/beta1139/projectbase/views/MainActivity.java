package develop.beta1139.projectbase.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import develop.beta1139.projectbase.R;
import develop.beta1139.projectbase.databinding.ActivityMainBinding;
import develop.beta1139.projectbase.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainViewModel();
        mBinding.setMainViewModel(mViewModel);
        mBinding.setMainActivity(this);
    }

    public void onClick(View view) {
        mViewModel.onClick();
    }
}
