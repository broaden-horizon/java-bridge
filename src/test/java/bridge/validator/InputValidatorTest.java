package bridge.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();
    @Test
    void validateBridgeSizeTest_3_미만인_경우() {
        //given
        int size = 2;
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateBridgeSize(size);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateBridgeSizeTest_20_초과인_경우() {
        //given
        int size = 21;
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateBridgeSize(size);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateBridgeSizeTest_정상() {
        //given
        int size = 10;
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateBridgeSize(size);
        });
        //then
        assertThat(throwable)
                .isNull();
    }
    @Test
    void validateMoveTest_U또는D_아닌_경우() {
        //given
        String move = "Test";
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateMove(move);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateMoveTest_빈_문자열_경우() {
        //given
        String move = "";
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateMove(move);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateMoveTest_U_정상() {
        //given
        String move = "U";
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateMove(move);
        });
        //then
        assertThat(throwable)
                .isNull();
    }
    @Test
    void validateMoveTest_D_정상() {
        //given
        String move = "D";
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateMove(move);
        });
        //then
        assertThat(throwable)
                .isNull();
    }
}