package ru.kpfu.itis.java4.srvergasov.semesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Advertisement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvertisementDto {
    private String title;
    private String description;
    private String href;

    public static AdvertisementDto from(Advertisement advertisement) {
        return AdvertisementDto.builder()
                .title(advertisement.getSetup())
                .description(advertisement.getPunchline())
                .href("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
                .build();
    }
}
