
package net.aapgsuez.aapgsuez;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MagazineResponse {

    @SerializedName("articles")
    @Expose
    private List<MagazineModel> magazines = null;

    public List<MagazineModel> getMagazineModels() {
        return magazines;
    }

    public void setMagazineModels(List<MagazineModel> magazines) {
        this.magazines = magazines;
    }

}
