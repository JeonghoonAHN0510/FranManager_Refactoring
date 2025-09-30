package ongTest.controller;

import lombok.RequiredArgsConstructor;
import ongTest.service.FranService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fran
 * 가맹점 정보
 *
 * @author OngTK
 * */

@RestController
@RequestMapping("/fran")
@RequiredArgsConstructor
public class FranController {

    private final FranService franService;

} // class end
