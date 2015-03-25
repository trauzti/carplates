package com.trauzti.carplates;

import com.google.gson.annotations.SerializedName;

/**
 * Created by traustis on 3/23/15.
 */
public class RegistrationInfo {
    public String registryNumber, number, factoryNumber, type, color, status, nextCheck, pollution, weight, subType, registeredAt;

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
