package com.utilscontrol.hoclaixe.screens.main;

import androidx.lifecycle.MutableLiveData;

import com.utilscontrol.hoclaixe.core.base.Observers.BaseDisposableSingleObserver;
import com.utilscontrol.hoclaixe.core.base.interfaces.IBaseResponse;
import com.utilscontrol.hoclaixe.core.network.ApiService;
import com.utilscontrol.hoclaixe.core.network.responses.QuestionResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by ManhPQ on 2/22/20.
 */

public class MainActivityRepository {
    private ApiService apiService;
    private CompositeDisposable mDisposable = new CompositeDisposable();
    private MutableLiveData<QuestionResponse> mQuestionLiveData = new MutableLiveData<>();

    @Inject
    public MainActivityRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    MutableLiveData<QuestionResponse> getQuestionLiveData() {
        return mQuestionLiveData;
    }

    void getListQuestion() {
        mDisposable.clear();
        Single<Response<QuestionResponse>> responseObservable = apiService.getListQuestion();
        mDisposable.add(responseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseDisposableSingleObserver<>(new IBaseResponse<QuestionResponse>() {
                    @Override
                    public void onSuccess(QuestionResponse data) {
                        if (data != null) {
                            mQuestionLiveData.postValue(data);
                        } else {
                            mQuestionLiveData.postValue(null);
                        }
                    }

                    @Override
                    public void onExpiredAuth() {
                        // TODO: Process Expired Login Session
                    }

                    @Override
                    public void onError(Throwable e) {
                        mQuestionLiveData.postValue(null);
                    }
                }))
        );
    }
}
