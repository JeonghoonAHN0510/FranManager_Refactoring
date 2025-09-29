package custom.annotation;

public interface TestMapper {

    @CustomSelect("select * from test where name = ?")
    MemberDto selectByName(String name);
} // interface end