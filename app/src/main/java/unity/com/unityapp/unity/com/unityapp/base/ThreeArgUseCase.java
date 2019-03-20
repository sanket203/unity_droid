/*
 * Copyright © 2017 Nedbank. All rights reserved.
 */

package unity.com.unityapp.unity.com.unityapp.base;


import java.util.Map;

import io.reactivex.Observable;


public abstract class ThreeArgUseCase<A, B, C, R> extends UseCase<ThreeArgUseCase.Pair<A, B, C>, R> {

    public ThreeArgUseCase(final UseCaseComposer composer) {
        super(composer);
    }

    protected abstract Observable<R> createUseCaseObservable(A first, B second, C third);

    public Observable<R> execute(final A first, final B second, final C third) {
        return super.execute(new Pair<>(first, second, third));
    }

    public boolean isRunningForParam(final A param) {
        if (param == null) {
            return false;
        }
        for (Pair<A, B, C> key : observablesMap.keySet()) {
            if (key.first.equals(param)) {
                return true;
            }
        }
        return false;
    }

    public B getSecondParam(final A firstParam) {
        if (firstParam == null) {
            return null;
        }
        for (Map.Entry<Pair<A, B, C>, Observable<R>> entry : observablesMap.entrySet()) {
            if (entry.getKey().first.equals(firstParam)) {
                return entry.getKey().second;
            }
        }
        return null;
    }


    @Override
    protected final Observable<R> createUseCaseObservable(final Pair<A, B, C> param) {
        return createUseCaseObservable(param.first, param.second, param.third);
    }

    protected static class Pair<F, S, T> {
        F first;
        S second;
        T third;

        Pair(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?, ?> pair = (Pair<?, ?, ?>) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            if (second != null ? second.equals(pair.second) : pair.second != null) return false;
            return third != null ? third.equals(pair.third) : pair.third != null;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }
}
