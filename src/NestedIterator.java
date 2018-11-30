import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by mming on 10/17/18.
 */
public class NestedIterator implements Iterator<Integer> { //wepay
    Stack<NestedIntegerII> stack;
    List<NestedIntegerII> nestedList;
    public NestedIterator(List<NestedIntegerII> nestedList) {
        stack = new Stack();
        this.nestedList = nestedList;
        pushToStack(nestedList);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushToStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }
    private void pushToStack(List<NestedIntegerII> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}
class NestedIntegerII {
    Integer num;
    List<NestedIntegerII> list;
    public boolean isInteger() {
        return num != null && list == null;
    }
    public boolean isList() {
        return num == null && list != null;
    }
    public int getInteger() {
        return num;
    }
    public List<NestedIntegerII> getList() {
        return list;
    }
    public NestedIntegerII(Integer num) {
        this.num = num;
    }
    public NestedIntegerII(List<NestedIntegerII> list) {
        this.list = list;
    }
}
