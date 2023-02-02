package hello.hellospring.controller;

public class MemberForm {
    private String name;
// 프론트에서 넘어오는 name 값
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
