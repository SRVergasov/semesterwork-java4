package ru.kpfu.itis.java4.srvergasov.semesterwork.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AdvertisementDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.exceptions.ApiException;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Advertisement;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.remote.AdvertisementApi;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.AdvertisementService;

import java.io.IOException;

import static ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AdvertisementDto.from;

@Component
@AllArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementApi advertisementApi;

    @Override
    public AdvertisementDto getAdvertisement(String categoryName) {
        Call<Advertisement> ad = advertisementApi.getAdvertisement();
        try {
            Response<Advertisement> advertisementResponse = ad.execute();
            if (advertisementResponse.isSuccessful()) {
                if (advertisementResponse.body() != null) {
                    return from(advertisementResponse.body());
                } else {
                    throw new ApiException("Null response");
                }
            } else {
                throw new ApiException("Not successful request");
            }
        } catch (IOException exception) {
            throw new ApiException("Cannot connect");
        }
    }
}
