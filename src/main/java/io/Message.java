package io;

import java.util.HashMap;
import java.util.Map;

public class Message implements MessageInterface {
    Map<String, String> generalMessageList = new HashMap<String, String>();
    Map<String, String> exceptionMessageList = new HashMap<String, String>();

    public Message() {
        this.exceptionMessageList();
        this.generalMessageList();
    }
    private void generalMessageList() {
        generalMessageList.put("INPUT_NAMEOFCAR", "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        generalMessageList.put("INPUT_COUNT", "시도할 회수는 몇회인가요?");
        generalMessageList.put("OPERATION_RESULT", "실행 결과");
    }

    private void exceptionMessageList() {
        exceptionMessageList.put("INPUT_NOTHING", "아무 문자도 입력되지 않았습니다.");
        exceptionMessageList.put("INPUT_COMMA_IN_A_ROW", "쉼표(,)가 연속으로 입력되었습니다.");
        exceptionMessageList.put("INPUT_CHARACTERS_OTHER_THAN_NAME", "영어와 쉼표(,) 이외의 다른 문자가 입력되었습니다.");
        exceptionMessageList.put("START_WITH_COMMA", "쉼표(,)로 시작합니다.");
        exceptionMessageList.put("END_WITH_COMMA", "쉼표(,)로 끝납니다.");
        exceptionMessageList.put("INPUT_SAME_NAME", "같은 이름이 입력되었습니다.");
        exceptionMessageList.put("OVER_5_CHARACTERS", "이름이 5자 이상입니다.");
        exceptionMessageList.put("INPUT_CHARACTERS_OTHER_THAN_DIGIT", "숫자 이외의 다른 문자가 입력되었습니다.");
    }

    @Override
    public String selectMessageFromGeneral(String Keyword) {
        return generalMessageList.get(Keyword);
    }

    @Override
    public String selectMessageFromException(String Keyword) {
        return exceptionMessageList.get(Keyword);
    }
}