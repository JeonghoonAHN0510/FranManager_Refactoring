package custom.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MySQLHandler implements InvocationHandler {
    // DB 연결 정보 - 일단 여기에 정보 저장
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    /**
     * Mapper 인터페이스의 메소드가 호출될 때, 실제로 실행되는 로직
     *
     * @param proxy     프록시 객체
     * @param method    호출된 메소드 (예:select * from test where name = ?)
     * @param args      메소드에 전달된 인자들
     * @return DB 조회 결과
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 호출된 메소드에서 어노테이션 찾기
        CustomSelect annotation = method.getAnnotation(CustomSelect.class);
        // 2. 어노테이션이 존재하면, DB 작업 실행
        if (annotation != null){
            StringBuilder builder = new StringBuilder();
            for (String str : annotation.value()){
                builder.append(str);
            } // for end
            System.out.println("실행할 SQL 테스트 : " + builder);
        } // if end
    } // func end
} // class end