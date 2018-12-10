package unity.com.unityapp.unity.com.unityapp.base;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by admin on 10/12/18.
 */

public class BasePresenter<V extends BaseView> implements LifecycleProvider<Integer> {


    private final BehaviorSubject<Integer> lifecycleSubject = BehaviorSubject.create();

    protected V view;

    protected void onBind() {

    }

    protected void onUnbind() {

    }

    public final void bind(V viewToBind) {
        view = viewToBind;
        onBind();
        lifecycleSubject.onNext(0);
    }

    public final void unbind() {
        onUnbind();
        lifecycleSubject.onNext(1);
        view = null;
    }

    @Override
    public Observable<Integer> lifecycle() {
        return lifecycleSubject.hide();
    }

    @Override
    public <T> LifecycleTransformer<T> bindUntilEvent(Integer event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecyclePresenter.bindPresenter(lifecycleSubject);
    }
}
