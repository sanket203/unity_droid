package unity.com.unityapp.unity.com.unityapp.base.data.repository;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ResponseDataModel;

/**
 * Created by admin on 10/12/18.
 */

public interface BaseRepository {

    Observable<ResponseDataModel> getData();
}
