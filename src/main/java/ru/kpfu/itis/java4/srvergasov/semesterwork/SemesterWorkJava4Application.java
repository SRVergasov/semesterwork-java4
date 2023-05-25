package ru.kpfu.itis.java4.srvergasov.semesterwork;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.remote.AdvertisementApi;

@SpringBootApplication
public class SemesterWorkJava4Application {

    private static final String API_URL = "https://official-joke-api.appspot.com/";

    @Bean
    public Gson gson() {
        return new GsonBuilder().setLenient().create();
    }

    @Bean
    public AdvertisementApi advertisementApi(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(AdvertisementApi.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(SemesterWorkJava4Application.class, args);
    }

}
