import java.util.Stack;

public class Pactice02 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        AdvancedStack<Integer> stack = new AdvancedStack<>();
        stack.push(10);
        stack.push(7);
        stack.push(3);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        stack.push(2);
        stack.push(6);
        System.out.println("Minimum value: "+ stack.getMinimum());
        stack.pop();
        System.out.println("Minimum value: "+ stack.getMinimum());
        stack.pop();
        System.out.println("Minimum value: "+ stack.getMinimum());
        stack.pop();
        System.out.println("Minimum value: "+ stack.getMinimum());
    }

    public static class AdvancedStack<E extends Number> extends Stack<E> {

        private Stack<E> mMinimumStack = new Stack<>();

        @Override
        public E push(E item) {
            if (mMinimumStack.empty() || item.doubleValue() < mMinimumStack.peek().doubleValue()) {
                mMinimumStack.push(item);
            }
            return super.push(item);
        }

        @Override
        public synchronized E pop() {
            E object = super.pop();
            mMinimumStack.remove(object);
            return object;
        }

        public E getMinimum() {
            if (mMinimumStack.size() > 0) {
                return mMinimumStack.peek();
            }
            return null;
        }
    }
}
