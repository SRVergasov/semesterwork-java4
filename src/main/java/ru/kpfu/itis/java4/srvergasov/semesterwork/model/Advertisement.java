package ru.kpfu.itis.java4.srvergasov.semesterwork.model;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Advertisement {
    @SerializedName("id")
    private int id;
    @SerializedName("punchline")
    private String punchline;
    @SerializedName("setup")
    private String setup;
    @SerializedName("type")
    private String type;
}
