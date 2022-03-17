public class Pattern {
    private String getPadding(int rightBound) {
        String s = "";

        for (int i = 1; i <= rightBound; i++) {
            for (int j = 0; j < String.valueOf(i).length()+1; j++) {
                s += " ";
            }
        }

        return s;
    }

    public String getPattern(int value) {
        String result = "";
        int i = 1, j = 1;

        while (i <= value*2-1) {
            if (i <= value) {
                result += getPadding(i-1);
                while (j <= value) {
                    if (j >= i) {
                        result += String.format("%d ", j);
                    }
                    j++;
                }
            } else {
                result += getPadding(value-1);
                while (j <= i-value) {
                    result += String.format("%d ", value-j);
                    j++;
                }
            }
            result += '\n';
            i++;
            j = 0;
        }

        return result;
    }

    public String getPatternDW(int value) {
        String result = "";
        int i = 1, j = 1;

        do {
            if (i <= value) {
                result += getPadding(i-1);
                do {
                    if (j >= i) {
                        result += String.format("%d ", j);
                    }
                    j++;
                } while (j <= value);
            } else {
                result += getPadding(value-1);
                do {
                    result += String.format("%d ", value-j);
                    j++;
                } while (j <= i-value);
            }
            result += '\n';
            i++;
            j = 0;
        } while (i <= value*2-1);

        return result;
    }
}

