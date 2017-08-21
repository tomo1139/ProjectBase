package develop.beta1139.projectbase.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import develop.beta1139.projectbase.R;
import develop.beta1139.projectbase.databinding.ActivityMainBinding;
import develop.beta1139.projectbase.viewModels.MainViewModel;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private MainViewModel mViewModel;

    private CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainViewModel();
        mBinding.setMainViewModel(mViewModel);
        mBinding.setMainActivity(this);

        mDisposable.add(mViewModel.mObservable.subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Toast toast = Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG);
                toast.show();
            }
        }));
    }

    public void onClick(View view) {
        mViewModel.onClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
