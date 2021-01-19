package bin.clock;

public class BinMap {

    private char[][] binMap = {
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'}};

    CurrentTime date = new CurrentTime();

    public char setMap(int s, int a, int b) {

        String x = null;

        for(int j = a; j <= b; j++) {
            if (j % 2 == 0) {
                x = Integer.toBinaryString(s / 10);
            } else {
                x = Integer.toBinaryString(s - (s / 10) * 10);
            }
            for (int i = 0; i < x.length(); i++) {
                if (Integer.parseInt(x) == 0) {
                    binMap[j][0] = '0';
                    binMap[j][1] = '0';
                    binMap[j][2] = '0';
                    binMap[j][3] = '0';
                } else {
                    binMap[j][3 - i] = x.charAt(x.length() - 1 - i);
                }
            }
        }

        return 0;
    }

    public char getMap(int i, int j){
        return this.binMap[i][j];
    }
}
