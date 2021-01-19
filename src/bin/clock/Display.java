package bin.clock;

public class Display {
    private BinMap binar;
    public Display(BinMap binar){
        this.binar = binar;
    }
    private char[][] pole = {
            {'☺', '☺', '☺', '☺', '☺', '☺'},
            {'☺', '☺', '☺', '☺', '☺', '☺'},
            {'☺', '☺', '☺', '☺', '☺', '☺'},
            {'☺', '☺', '☺', '☺', '☺', '☺'},
    };
    public void refresh() {
        int x = 8;
        for (int i = 0; i < pole.length; i++) {
            System.out.print(x + " |&|");
            x/=2;
            for (int j = 0; j < pole[i].length; j++) {
                System.out.print(pole[i][j] + "|");
                if (j % 2 != 0){
                    System.out.print("&|");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public void update(){
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < pole.length; i++) {
                if (binar.getMap(j, i) == '1') {
                    pole[i][j] = '☻';
                } else {
                    pole[i][j] = '☺';
                }
            }
        }
    }
}
