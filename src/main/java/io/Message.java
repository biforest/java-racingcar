package io;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class Message {
    private GeneralMessages generalMessages;
    private ExceptionMessages exceptionMessages;

    public enum GeneralMessages {
        INPUT_NAMEOFCAR("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
        INPUT_COUNT("시도할 회수는 몇회인가요?"),
        OPERATION_RESULT("실행 결과"),
        FIANL_WINNER("가 최종 우승했습니다."),
        DEFAULT_SPACE("");

        private String message;

        GeneralMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum ExceptionMessages {
        INPUT_NOTHING("아무 문자도 입력되지 않았습니다."),
        INPUT_COMMA_IN_A_ROW("쉼표(,)가 연속으로 입력되었습니다."),
        INPUT_CHARACTERS_OTHER_THAN_NAME("영어와 쉼표(,) 이외의 다른 문자가 입력되었습니다."),
        START_WITH_COMMA("쉼표(,)로 시작합니다."),
        INPUT_SAME_NAME("쉼표(,)로 끝납니다."),
        OVER_SIZE_CHARACTERS("같은 이름이 입력되었습니다."),
        INPUT_CHARACTERS_OTHER_THAN_DIGIT("이름이 5자 이상입니다."),
        END_WITH_COMMA("숫자 이외의 다른 문자가 입력되었습니다.");

        private String message;

        ExceptionMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public String selectMessageFromGeneral(String Keyword) {
        generalMessages = GeneralMessages.valueOf(Keyword);
        return generalMessages.getMessage();
    }

    public String selectMessageFromException(String Keyword) {
        exceptionMessages = ExceptionMessages.valueOf(Keyword);
        return exceptionMessages.getMessage();
    }
}