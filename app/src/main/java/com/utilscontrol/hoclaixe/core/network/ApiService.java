package com.utilscontrol.hoclaixe.core.network;

import com.utilscontrol.hoclaixe.core.network.responses.QuestionResponse;
import com.utilscontrol.hoclaixe.utils.ApiConstants;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by ManhPQ on 2/22/20.
 */

public interface ApiService {
    @GET(ApiConstants.GET_QUESTION)
    Single<Response<QuestionResponse>> getListQuestion();
}
