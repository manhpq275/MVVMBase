package com.utilscontrol.hoclaixe.screens.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utilscontrol.hoclaixe.core.network.responses.QuestionResponse;

import javax.inject.Inject;

/**
 * Created by ManhPQ on 2/22/20.
 */

class MainActivityViewModel extends ViewModel {
    private MainActivityRepository repository;

    @Inject
    public MainActivityViewModel(MainActivityRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<QuestionResponse> getQuestionLiveData(){
        return repository.getQuestionLiveData();
    }

    public void getListQuestion() {
        repository.getListQuestion();
    }
}
