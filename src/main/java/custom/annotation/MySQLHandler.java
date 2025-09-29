package custom.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLHandler implements InvocationHandler {
    // DB 연결 정보 - 일단 여기에 정보 저장
    private static final String DB_URL = "jdbc:mysql://localhost:3306/InterfaceTest";
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
        // 1. 호출된 메소드에서 어노테이션 찾기
        CustomSelect annotation = method.getAnnotation(CustomSelect.class);
        // 2. 어노테이션이 존재하면, DB 작업 실행
        if (annotation != null){
            StringBuilder builder = new StringBuilder();
            for (String str : annotation.value()){
                builder.append(str);
            } // for end
            // 3. 데이터베이스 연결 및 쿼리 실행
            try {
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement ps = conn.prepareStatement(builder.toString());
                // 4. 입력받은 인자값들을 ?에 넣기
                if (args != null && args.length > 0){
                    for (int i = 0; i < args.length; i++){
                        ps.setObject(i+1, args[i]);
                    } // for end
                } // if end
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    MemberDto dto = new MemberDto();
                    dto.setName(rs.getString("name"));
                    dto.setAge(rs.getInt("age"));
                    return dto;
                } // if end
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } // if end
        return null;
    } // func end
} // class end