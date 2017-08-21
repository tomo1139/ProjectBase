package develop.beta1139.projectbase.network;

import develop.beta1139.projectbase.data.NictTime;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by tomo on 2017/08/21.
 */

interface Api {
    public static String NICT_TIME_END_POINT = "http://ntp-a1.nict.go.jp";
    @GET("/cgi-bin/json")
    Single<NictTime> fetchNictTime();
}
