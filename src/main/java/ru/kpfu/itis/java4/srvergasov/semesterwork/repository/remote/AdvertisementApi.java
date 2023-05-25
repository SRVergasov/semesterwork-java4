package ru.kpfu.itis.java4.srvergasov.semesterwork.repository.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Advertisement;

public interface AdvertisementApi {

    @GET("random_joke")
    Call<Advertisement> getAdvertisement();

}
