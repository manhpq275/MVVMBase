package com.utilscontrol.hoclaixe.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ManhPQ on 2/22/20.
 */

public class Question {
    @SerializedName("Id")
    @Expose
    public String id;
    @SerializedName("SortIndex")
    @Expose
    public Integer sortIndex;
    @SerializedName("QuestionType")
    @Expose
    public String questionType;
    @SerializedName("Content")
    @Expose
    public String content;
    @SerializedName("Image")
    @Expose
    public String image;
    @SerializedName("Option1")
    @Expose
    public String option1;
    @SerializedName("Option2")
    @Expose
    public String option2;
    @SerializedName("Option3")
    @Expose
    public String option3;
    @SerializedName("Option4")
    @Expose
    public String option4;
    @SerializedName("Answer")
    @Expose
    public String answer;
    @SerializedName("AnswerDesc")
    @Expose
    public String answerDesc;
    @SerializedName("A1")
    @Expose
    public String a1;
    @SerializedName("A2")
    @Expose
    public String a2;
    @SerializedName("A3A4")
    @Expose
    public String a3A4;
    @SerializedName("B1")
    @Expose
    public String b1;
}
