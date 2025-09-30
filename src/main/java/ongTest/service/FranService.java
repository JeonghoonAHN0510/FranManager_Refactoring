package ongTest.service;

import lombok.RequiredArgsConstructor;
import ongTest.model.dto.FranDto;
import ongTest.model.mapper.FranMapper;
import ongTest.model.resources.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranService extends AbstractService<FranDto, Integer>{

    @Autowired
    private FranMapper franMapper;

    @Override
    protected CommonRepository<FranDto, Integer> getMapper() {
        return (CommonRepository<FranDto, Integer>) franMapper;
    }
} // class ends