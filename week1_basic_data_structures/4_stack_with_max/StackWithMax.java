import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> aux = new Stack<Integer>();
        int max = -1;
        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();

            if ("push".equals(operation)) {

                int value = scanner.nextInt();
                if(stack.isEmpty()) {
                    max = value;
                    stack.push(value);
                    aux.push(value);
                }
                if(value > max){
                    stack.push(value);
                    max = value;
                    aux.push(max);
                } else {
                    stack.push(value);
                    aux.push(max);
                }

            } else if ("pop".equals(operation)) {

                if(stack.isEmpty()) {
                    return;
                }
                int t = stack.peek();
                stack.pop();
                aux.pop();
            } else if ("max".equals(operation)) {

                System.out.println(aux.peek());
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
