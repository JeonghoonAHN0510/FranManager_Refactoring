package ongTest.service;

import lombok.RequiredArgsConstructor;
import ongTest.model.dto.FranDto;
import ongTest.model.resources.CommonRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranService extends AbstractService<FranDto, Integer>{

    @Override
    protected CommonRepository<FranDto, Integer> getMapper() {
        return null;
    }
} // class ends