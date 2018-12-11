package unity.com.unityapp.unity.com.unityapp.base.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import unity.com.unityapp.unity.com.unityapp.base.AndroidUseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepositoryImpl;
import unity.com.unityapp.unity.com.unityapp.base.networking.NetworkClient;

/**
 * Created by admin on 10/12/18.
 */
@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(final Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public BaseRepository providesBaseRepository(NetworkClient networkClient) {
        return new BaseRepositoryImpl(networkClient);
    }

    @Provides
    @Singleton
    NetworkClient provideNetworkClient() {
        return NetworkClient.getInstance();
    }

    @Provides
    UseCaseComposer provideUseCaseComposer() {
        return new AndroidUseCaseComposer();
    }
}
