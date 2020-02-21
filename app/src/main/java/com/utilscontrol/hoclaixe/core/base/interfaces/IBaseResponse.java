package com.utilscontrol.hoclaixe.core.base.interfaces;

/**
 * Created by ManhPQ on 2/22/20.
 */

public interface IBaseResponse<T> {
    void onSuccess(T data);
    void onExpiredAuth();
    void onError(Throwable e);
}
