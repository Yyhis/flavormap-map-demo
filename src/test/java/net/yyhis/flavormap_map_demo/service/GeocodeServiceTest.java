package net.yyhis.flavormap_map_demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.yyhis.flavormap_map_demo.dto.CoordinateDto;
import net.yyhis.flavormap_map_demo.dto.ReverseGcResponseDto;

@SpringBootTest
public class GeocodeServiceTest {
    @Autowired
    private GeocodeService geocodeService;

    @Test
    public void testReverseGeocoding() {
        CoordinateDto coordinate = new CoordinateDto(126.978388, 37.566610); // 서울 시청 근처

        ReverseGcResponseDto result = geocodeService.reverseGeocoding(coordinate);

        // 응답 결과 출력 (콘솔에 출력)
        System.out.println(result);

        // 예상되는 결과와 비교 (이 부분은 실제 결과에 맞게 조정해야 합니다)
        assertNotNull(result);
        assertTrue(result.getStatus().getCode() == 0 || result.getStatus().getCode() == 3);
    }
}
