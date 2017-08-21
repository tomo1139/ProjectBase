package develop.beta1139.projectbase.network;

import java.io.IOException;

import develop.beta1139.projectbase.data.NictTime;
import io.reactivex.Single;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tomo on 2017/08/21.
 */

public class Nict {
    private Api mApi;

    public Nict() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .header("Accept", "application/json")
                        .header("User-Agent", "Your-App-Name")
                        .method(chain.request().method(), chain.request().body())
                        .build();
                Response response = chain.proceed(request);
                return response;
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.NICT_TIME_END_POINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        mApi = retrofit.create(Api.class);
    }

    public Single<NictTime> fetchNictTime() {
        return mApi.fetchNictTime();
    }
}
