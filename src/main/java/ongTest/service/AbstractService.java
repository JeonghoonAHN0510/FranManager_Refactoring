package ongTest.service;

import ongTest.model.resources.CommonRepository;

import java.util.List;

/** **info** ========================
 *
 * CommonService를 상속 받아 CRUD 기능을 구현
 *
 * getDao 추상 클래스를 정의
 * @author OngTK
 * */

public abstract class AbstractService<T, ID> implements CommonRepository<T, ID> {

    // [1] 추상 메소드
    protected abstract CommonRepository<T, ID> getMapper();
    
    // [2] CommonService 구현
    @Override
    // [2.1] 생성 구현
    public int create(T dto) {
        return getMapper().create(dto);
    } // func end

    @Override
    // [2.2] 전체 조회 구현
    public List<T> readAll() {
        return getMapper().readAll();
    } // func end

    @Override
    // [2.3] 개별 조회 구현
    public T read(ID id) {
        return getMapper().read(id);
    } // func end

    @Override
    // [2.4] 수정 구현
    public int update(T dto) {
        return getMapper().update(dto);
    } // func end

    @Override
    // [2.5] 삭제(비활성화) 구현
    public int delete(ID id) {
        return getMapper().delete(id);
    } // func end

} // func end
