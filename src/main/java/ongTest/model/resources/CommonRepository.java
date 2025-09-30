package ongTest.model.resources;

import java.util.List;

/// info ========================
///
/// Dao/service class 들의 공통기능인 CRUD 인터페이스
///
/// @author OngTK

public interface CommonRepository<T, ID> {
    // 제네릭
    // T dto    : Dto를 담을 제네릭
    // ID id    : PK 값을 받을 제넥릭 / 일반적으로 PK-Integer을 가장 많이 사용할 예정

    int create(T dto);           // 생성 func
    T read(ID id);          // 개별 조회 func
    List<T> readAll();        // 전체 조회 func
    int update(T dto);           // 수정 func
    int delete(ID id);      // 삭제(비활성화) func

} // class end
