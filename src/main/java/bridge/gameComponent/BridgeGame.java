package bridge.gameComponent;

import bridge.exception.ExceptionMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int index; //현재까지 움직인 칸
    private int endIndex; //마지막 칸
    private int numberOfTries;

    public BridgeGame(Bridge bridge) {
        if (bridge == null) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_INPUT.getMessage());
        }
        this.index = -1;
        this.endIndex = bridge.getBridge().size() - 1;
        this.numberOfTries = 1;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public int getIndex() {
        return index;
    }

    public int getEndIndex() {
        return endIndex;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    /**
     * 마지막 칸까지 도달했다면 1 리턴, 그렇지 않으면 0 리턴
     **/
    public int move() {
        index++;
        if (isSuccess()) return 1;
        if (index < endIndex) return 0;
        throw new IllegalStateException(ExceptionMessage.CANNOT_MOVE_FURTHER.getMessage());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if (isSuccess()) throw new IllegalStateException(ExceptionMessage.GAME_ALREADY_SUCCESS.getMessage());
        this.numberOfTries++;
        this.index = -1;
    }

    public boolean isSuccess() {
        if (index == endIndex) return true;
        return false;
    }
}
