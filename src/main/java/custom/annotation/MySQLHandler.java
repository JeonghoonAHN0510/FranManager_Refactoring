package custom.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.*;

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
                // 5. 자동 매핑 구현
                if (rs.next()){
                    // 5-1. 호출된 메소드의 반환 타입 가져오기
                    Class<?> type = method.getReturnType();
                    // 5-2. 반환 타입의 생성자를 사용하여 새로운 인스턴스를 생성
                    Object obj = type.getDeclaredConstructor().newInstance();
                    // 5-3. ResultSet의 컬럼 정보를 가져오기
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    // 5-4. 컬럼을 순회하며, 값 채우기
                    for (int i = 1; i <= columnCount; i++){
                        // 5-5. DB에서 컬럼명을 가져오기
                        String columnName = metaData.getColumnName(i);
                        // 5-6. 컬럼명에 해당하는 Setter 메소드명 만들기
                        String setterName = toSetterName(columnName);
                        // 5-7. Dto의 모든 메소드를 순회하면서 일치하는 Setter 찾기
                        for (Method dtoMethod : type.getDeclaredMethods()){
                            if (dtoMethod.getName().equals(setterName) && dtoMethod.getParameterCount() == 1){
                                // 5-8. 찾았으면, ResultSet에서 값을 가져와서 동적으로 메소드 호출
                                dtoMethod.invoke(obj, rs.getObject(columnName));
                                break;
                            } // if end
                        } // for end
                    } // for end
                    return obj;
                } // if end
            } catch (Exception e){
                System.out.println(e.getMessage());
            } // try-catch end
        } // if end
        return null;
    } // func end

    /**
     * 컬럼명을 Setter 메소드명으로 변환하는 메소드
     * @param columnName    데이터베이스 컬럼명
     * @return String       변환된 Setter 메소드명
     */
    private String toSetterName(String columnName) {
        StringBuilder setterName = new StringBuilder("set");
        for (String part : columnName.split("_")){
            setterName.append(part.substring(0, 1).toUpperCase());
            setterName.append(part.substring(1));
        } // for end
        return setterName.toString();
    } // func end
} // class end