package ongTest.controller;

import lombok.RequiredArgsConstructor;
import ongTest.model.dto.FranDto;
import ongTest.service.FranService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<Integer> createFran(@RequestBody FranDto franDto){
        System.out.println("FranController.createFran");
        System.out.println("franDto = " + franDto);

        int result = franService.create(franDto);

        if(result == 0 ){
            return ResponseEntity.status(422).body(result);
            // 422 처리할 수 없는 개체
        } else {
            return ResponseEntity.ok().body(result);
        }
    } // func end

    @GetMapping
    public ResponseEntity<List<FranDto>> getFranList(){
        System.out.println("FranController.getFranList");

        List<FranDto> result = franService.readAll();

        if( result == null) {
            return  ResponseEntity.status(400).body(null);
        } else {
            return ResponseEntity.ok().body(result);
        }
    } // func end

    @GetMapping("/indi")
    public ResponseEntity<FranDto> getFran(@RequestParam int franNo){
        System.out.println("FranController.getFran");
        System.out.println("franNo = " + franNo);

        FranDto result = franService.read(franNo);
        if(result == null ){
            return ResponseEntity.status(422).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    } // func end

    @PutMapping
    public ResponseEntity<Integer> updateFran(@RequestBody FranDto franDto){
        System.out.println("FranController.updateFran");
        System.out.println("franDto = " + franDto);

        int result = franService.update(franDto);

        if(result == 0 ){
            return ResponseEntity.status(422).body(result);
            // 422 처리할 수 없는 개체
        } else {
            return ResponseEntity.ok().body(result);
        }
    } // func end

    @DeleteMapping
    public ResponseEntity<Integer> deleteFran(@RequestParam int franNo){
        System.out.println("FranController.deleteFran");
        System.out.println("franNo = " + franNo);

        int result = franService.delete(franNo);

        if(result == 0 ){
            return ResponseEntity.status(422).body(result);
            // 422 처리할 수 없는 개체
        } else {
            return ResponseEntity.ok().body(result);
        }
    } // func end

} // class end
