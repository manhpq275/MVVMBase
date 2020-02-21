package com.utilscontrol.hoclaixe.core.network.responses;

import com.utilscontrol.hoclaixe.models.Question;

import java.util.ArrayList;

/**
 * Created by ManhPQ on 2/22/20.
 */

public class QuestionResponse {
    int statusCode;
    String message;
    ArrayList<Question> data;

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Question> getData() {
        return data;
    }
}
