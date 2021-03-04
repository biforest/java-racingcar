package io;

import java.util.HashMap;
import java.util.Map;

public interface MessageInterface {
    Map<String, String> generalMessageList = new HashMap<String, String>();

    private void genralMessageList() {
        generalMessageList.put("INPUT_NAMEOFCAR", "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        generalMessageList.put("INPUT_COUNT", "시도할 회수는 몇회인가요?");
        generalMessageList.put("OPERATION_RESULT", "실행 결과");
        generalMessageList.put("", "아무 문자도 입력되지 않았습니다.");
        generalMessageList.put("", "쉼표(,)가 연속으로 입력되었습니다.");
        generalMessageList.put("", "영어와 쉼표(,) 이외의 다른 문자가 입력되었습니다.");
        generalMessageList.put("", "같은 이름이 입력되었습니다.");
        generalMessageList.put("", "이름이 5자 이상입니다.");
        generalMessageList.put("", "숫자 이외의 다른 문자가 입력되었습니다.");
    }

    void selectMessage(String Keyword);
}
