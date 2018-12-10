/*
 * Copyright © 2017 Nedbank. All rights reserved.
 */

package unity.com.unityapp.unity.com.unityapp.base;


import io.reactivex.ObservableTransformer;

public interface UseCaseComposer {

    <T> ObservableTransformer<T, T> apply();

}
