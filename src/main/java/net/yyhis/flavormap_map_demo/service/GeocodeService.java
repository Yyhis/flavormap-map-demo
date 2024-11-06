package net.yyhis.flavormap_map_demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import net.yyhis.flavormap_map_demo.config.NaverMapConfig;
import net.yyhis.flavormap_map_demo.dto.CoordinateDto;
import net.yyhis.flavormap_map_demo.dto.ReverseGcResponseDto;
import reactor.core.publisher.Mono;

@Service
public class GeocodeService {
    @Autowired
    private NaverMapConfig naverMapConfig;

    @Autowired
    private WebClient.Builder webClientBuilder;

    // query to coordinate
    public String geocoding(CoordinateDto coordinate) throws IOException {
        return null;
    }

    // 좌표를 이용한 역지오코딩 메서드
    public ReverseGcResponseDto reverseGeocoding(CoordinateDto coordinate) {
        WebClient webClient = webClientBuilder.build();

        String urlString = naverMapConfig.getUrl() + "map-reversegeocode/v2/gc?coords=" + coordinate.getLongitude()
                + ","
                + coordinate.getLatitude()
                + "&output=json&orders=legalcode,admcode,addr,roadaddr";

        try {
            // WebClient를 사용하여 API 호출
            Mono<ReverseGcResponseDto> response = webClient.get()
                    .uri(urlString)
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .header("x-ncp-apigw-api-key-id", naverMapConfig.getClientId())
                    .header("x-ncp-apigw-api-key", naverMapConfig.getSecretKey())
                    .exchangeToMono(clientResponse -> {
                        if (clientResponse.statusCode().is2xxSuccessful()) {
                            return clientResponse.bodyToMono(ReverseGcResponseDto.class);
                        } else {
                            return Mono.error(new RuntimeException("API 호출 실패: " + clientResponse.statusCode()));
                        }
                    });

            return response.block(); // 동기 처리;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
