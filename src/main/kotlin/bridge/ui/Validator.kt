package bridge.ui

import bridge.utils.DOWN
import bridge.utils.QUIT
import bridge.utils.RESTART
import bridge.utils.UP

class Validator {
    fun handleMixedCharCase(input: String) {
        for (ch in input) {
            if (!Character.isDigit(ch)){
                // 음수인 경우 다른 함수에서 처리하도록
                if(ch == '-' && input.toInt() < 0) continue
                throw IllegalArgumentException(MIXED_CHAR_ERROR_MSG)
            }
        }
    }

    fun handleOutOfRangeCase(num: Int) {
        if (num !in MIN_SIZE..MAX_SIZE)
            throw IllegalArgumentException(RANGE_BOUNDS_ERROR_MSG)
    }

    fun handleExceptionalDirection(input: String) {
        if(input != UP && input != DOWN)
            throw IllegalArgumentException(UP_DOWN_ERROR_MSG)
    }

    fun handleExceptionalCommand(input: String) {
        if(input != RESTART && input != QUIT)
            throw IllegalArgumentException(RESTART_QUIT_ERROR_MSG)
    }

    companion object {
        const val MIN_SIZE = 3
        const val MAX_SIZE = 20
        const val MIXED_CHAR_ERROR_MSG = "[ERROR] 숫자만 입력해주세요."
        const val RANGE_BOUNDS_ERROR_MSG = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
        const val UP_DOWN_ERROR_MSG = "[ERROR] U(위 칸)와 D(아래 칸) 중에서만 입력해주세요."
        const val RESTART_QUIT_ERROR_MSG = "[ERROR] R(재시작)과 Q(종료) 중에서만 입력해주세요."
    }
}