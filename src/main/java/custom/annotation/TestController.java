package custom.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

@RestController
@RequestMapping("/test")
public class TestController {
    // 1. TestMapper 인터페이스를 기반으로 동적 프록시 객체 생성
    TestMapper testMapper = (TestMapper) Proxy.newProxyInstance(
            TestMapper.class.getClassLoader(),      // 1. 클래스 로더
            new Class[]{TestMapper.class},          // 2. 구현할 인터페이스 목록
            new MySQLHandler()                      // 3. 프록시의 실제 동작을 담은 핸들러
    );
    // 2. 프록시 객체의 메소드 호출
    public MemberDto memberDto = testMapper.selectByName("유재석");
} // class end