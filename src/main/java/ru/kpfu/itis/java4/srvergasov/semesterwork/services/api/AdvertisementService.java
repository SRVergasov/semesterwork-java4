package ru.kpfu.itis.java4.srvergasov.semesterwork.services.api;

import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AdvertisementDto;

public interface AdvertisementService {

    AdvertisementDto getAdvertisement(String categoryName);

}
