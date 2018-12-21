package unity.com.unityapp.unity.com.unityapp.base.networking;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by admin on 10/12/18.
 */

public class NetworkClient {

    private static NetworkClient instance;

    private Retrofit retrofit;

    public static NetworkClient getInstance() {
        if (instance == null) {
            instance = new NetworkClient();

        }

        return instance;
    }

    public <T> T create(final Class<T> service) {
        if (retrofit == null) {
            retrofit = createRetrofit();
        }

        return retrofit.create(service);
    }

    public Retrofit createRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();

        final String baseUrl = "http://192.168.43.63:8080/bramhanunity/";

        final Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client);
        return retrofitBuilder.build();
    }


}
