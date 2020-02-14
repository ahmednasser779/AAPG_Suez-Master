
package net.aapgsuez.aapgsuez;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestResponse {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("imgquestion")
    @Expose
    private String imgquestion;
    @SerializedName("Answers")
    @Expose
    private Answers answers;
    @SerializedName("True Ans")
    @Expose
    private String trueAns;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImgquestion() {
        return imgquestion;
    }

    public void setImgquestion(String imgquestion) {
        this.imgquestion = imgquestion;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    public String getTrueAns() {
        return trueAns;
    }

    public void setTrueAns(String trueAns) {
        this.trueAns = trueAns;
    }

}
