package com.utilscontrol.hoclaixe.core.base.Observers;

import com.utilscontrol.hoclaixe.core.base.interfaces.IBaseResponse;
import com.utilscontrol.hoclaixe.utils.Constants;

import io.reactivex.observers.DisposableSingleObserver;
import retrofit2.Response;

/**
 * Created by ManhPQ on 2/22/20.
 */

public class BaseDisposableSingleObserver<T> extends DisposableSingleObserver<Response<T>> {
    private IBaseResponse<T> mListener;

    public BaseDisposableSingleObserver(IBaseResponse<T> listener) {
        this.mListener = listener;
    }

    @Override
    public void onSuccess(Response<T> response) {
        if (response.code() == Constants.REQUEST_CODE_SUCCESS){
            if (mListener != null){
                mListener.onSuccess(response.body());
            }
        } else if (response.code() == Constants.REQUEST_CODE_EXPIRED_AUTH){
            if (mListener != null){
                mListener.onExpiredAuth();
            }
        } else {
            // TODO: some case define here
        }
    }

    @Override
    public void onError(Throwable e) {
        if (mListener != null){
            mListener.onError(e);
        }
    }
}
