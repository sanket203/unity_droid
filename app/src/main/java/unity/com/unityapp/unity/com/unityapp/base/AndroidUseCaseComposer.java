/*
 * Copyright © 2017 Nedbank. All rights reserved.
 */

package unity.com.unityapp.unity.com.unityapp.base;


import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AndroidUseCaseComposer implements UseCaseComposer {

    @Override
    public <T> ObservableTransformer<T, T> apply() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
