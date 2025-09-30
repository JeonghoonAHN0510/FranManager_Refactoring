package ongTest.service;

import lombok.RequiredArgsConstructor;
import ongTest.model.dto.FranDto;
import ongTest.model.resources.CommonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FranService extends AbstractService<FranDto, Integer, String>{


    @Override
    public int create(FranDto dto) {
        return super.create(dto);
    }

    @Override
    public FranDto read(Integer integer, String s) {
        return super.read(integer, s);
    }

    @Override
    public List<FranDto> readAll(String s) {
        return super.readAll(s);
    }

    @Override
    public int update(FranDto dto) {
        return super.update(dto);
    }

    @Override
    public int delete(Integer integer, String s) {
        return super.delete(integer, s);
    }

    @Override
    protected CommonRepository<FranDto, Integer, String> getDao() {

    }

} // class ends