package develop.beta1139.projectbase.viewModels;

import android.databinding.ObservableField;

import develop.beta1139.projectbase.data.NictTime;
import develop.beta1139.projectbase.network.Nict;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by tomo on 2017/08/21.
 */

public class MainViewModel {
    public ObservableField<String> mText = new ObservableField<>();

    private PublishSubject<String> mPublishSubject = PublishSubject.create();
    public Observable<String> mObservable = mPublishSubject.hide();

    public MainViewModel() {
        mText.set("text from MainViewModel");
    }

    public void onClick() {

        Nict nict = new Nict();
        nict.fetchNictTime()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<NictTime>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onSuccess(@NonNull NictTime nictTime) {
                        mText.set("onClick: " + nictTime.getSt());
                        mPublishSubject.onNext("success");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mPublishSubject.onNext("error");
                    }
                });
    }
}
