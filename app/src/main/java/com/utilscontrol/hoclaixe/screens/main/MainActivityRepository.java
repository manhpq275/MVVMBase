package com.utilscontrol.hoclaixe.screens.main;

import androidx.lifecycle.MutableLiveData;

import com.utilscontrol.hoclaixe.core.network.ApiService;
import com.utilscontrol.hoclaixe.core.network.responses.QuestionResponse;
import com.utilscontrol.hoclaixe.utils.Constants;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
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
                .subscribeWith(new DisposableSingleObserver<Response<QuestionResponse>>() {
                    @Override
                    public void onSuccess(Response<QuestionResponse> response) {
                        if (response.code() == Constants.REQUEST_CODE_SUCCESS) {
                            if (response.body() != null) {
                                mQuestionLiveData.postValue(response.body());
                            } else {
                                mQuestionLiveData.postValue(null);
                            }
                        } else {
                            mQuestionLiveData.postValue(null);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        mQuestionLiveData.postValue(null);
                    }
                })
        );
    }
}
