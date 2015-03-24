package com.trauzti.carplates;

import com.google.gson.annotations.SerializedName;

/**
 * Created by traustis on 3/23/15.
 */
public class RegistrationInfo {

    @SerializedName("registryNumber")
    public String registryNumber;

    @SerializedName("number")
    public String number;

    @SerializedName("factoryNumber")
    public String factoryNumber;

    @SerializedName("type")
    public String type;

    @SerializedName("color")
    public String color;

    @SerializedName("status")
    public String status;

    @SerializedName("nextCheck")
    public String nextCheck;

    @SerializedName("pollution")
    public String pollution;

    @SerializedName("weight")
    public String weight;

    @SerializedName("subType")
    public String subType;

    @SerializedName("registeredAt")
    public String registeredAt;


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bílnúmer: " + number + "\n");
        sb.append("Verksmiðjunúmer: " + factoryNumber + "\n");
        sb.append("Litur: " + color + "\n");
        sb.append("Tegund: " + type + "\n");
        sb.append("Undirtegund: " + subType + "\n");
        sb.append("Staða: " + status + "\n");
        sb.append("Þyngd: " + weight + "\n");
        sb.append("Mengun: " + pollution + "\n");
        sb.append("Skráður: " + registeredAt + "\n");
        sb.append("Næsta skoðun: " + nextCheck + "\n");
        return sb.toString();
    }

}

/*

 {
            "registryNumber": "AA031",
            "number": "AA031",
            "factoryNumber": "VF37ENFZE32286866",
            "type": "PEUGEOT",
            "subType": "306",
            "color": "Blár",
            "registeredAt": "26.02.1998",
            "status": "Í lagi",
            "nextCheck": "01.01.2013",
            "pollution": "",
            "weight": "1120"
        }
 */