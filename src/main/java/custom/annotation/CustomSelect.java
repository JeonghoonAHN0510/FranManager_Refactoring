package custom.annotation;

import java.lang.annotation.*;

/**
 * @Target : 어노테이션이 붙을 수 있는 대상을 설정
 * - METHOD(메소드)
 * - TYPE(클래스)
 * - FIELD(필드)
 *
 * @Retention : 어노테이션의 유지 기간을 설정
 * - RUNTIME : 런타임(실행)까지 유지 -> 리플렉션을 사용하려면 RUNTIME으로 설정 필요
 * - SOURCE : 컴파일 시 사라짐
 * - CLASS : 클래스 파일엔 남지만, 런타임 시 사라짐
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomSelect {

    String value();     // 어노테이션이 가질 속성 -> ex) @CustomSelect(value="")

} // annotation end