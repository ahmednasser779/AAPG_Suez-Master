
package net.aapgsuez.aapgsuez;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answers {

    @SerializedName("ans1")
    @Expose
    private String ans1;
    @SerializedName("ans2")
    @Expose
    private String ans2;
    @SerializedName("ans3")
    @Expose
    private String ans3;
    @SerializedName("ans4")
    @Expose
    private String ans4;
    @SerializedName("ans5")
    @Expose
    private String ans5;

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getAns5() {
        return ans5;
    }

    public void setAns5(String ans5) {
        this.ans5 = ans5;
    }

}
